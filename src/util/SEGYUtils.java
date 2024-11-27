package util;

import pojo.entity.DataTrace;
import pojo.entity.FileHeader;
import pojo.entity.SEGY;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZZHow
 * @date 2024/11/25
 */
public class SEGYUtils {

    /**
     * 解析 SEG-Y 文件
     *
     * @param file SEG-Y 文件
     * @return SEGY
     */
    public static SEGY parseSEGY(File file) {
        return parseSEGY(file.getAbsolutePath());
    }

    /**
     * 解析 SEG-Y 文件
     *
     * @param filePath SEG-Y 文件路径
     * @return SEGY
     */
    public static SEGY parseSEGY(String filePath) {
        SEGY segy = new SEGY();

        System.out.println("正在解析文件中，请稍后...");
        long start = System.currentTimeMillis();
        FileHeader fileHeader = SEGYUtils.parseFileHeader(filePath);
        segy.setFileHeader(fileHeader);
        Map<Long, DataTrace> longDataBodyMap = null;
        longDataBodyMap = SEGYUtils.parseDataBody(filePath, fileHeader, false);
        segy.setDataBody(longDataBodyMap);
        long end = System.currentTimeMillis();
        System.out.println("文件解析完成，耗时：" + (end - start) + "ms");
        System.out.println("文件共有 " + longDataBodyMap.keySet().size() + " 个数据道");

        return segy;
    }

    /**
     * 解析 SEG-Y 文件的文件头
     *
     * @param filePath SEG-Y 文件路径
     * @return FileHeader
     */
    public static FileHeader parseFileHeader(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("文件不存在");

            return null;
        }

        return parseFileHeader(file);
    }

    /**
     * 解析 SEG-Y 文件的文件头
     *
     * @param file SEG-Y 文件
     * @return FileHeader
     */
    public static FileHeader parseFileHeader(File file) {
        FileHeader fileHeader = new FileHeader();

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[3200];
            fileInputStream.read(bytes, 0, bytes.length);
            fileHeader.setTextualFileHeader(new String(bytes, "EBCDIC-CP-US"));

            bytes = new byte[400];
            fileInputStream.read(bytes, 0, bytes.length);
            fileHeader.setJobIdentificationNumber(combineToInt(bytes[0], bytes[1], bytes[2], bytes[3]));
            fileHeader.setLineNumber(combineToInt(bytes[4], bytes[5], bytes[6], bytes[7]));
            fileHeader.setReelNumber(combineToInt(bytes[8], bytes[9], bytes[10], bytes[11]));
            fileHeader.setDataTraces(combineToShort(bytes[12], bytes[13]));
            fileHeader.setAuxiliaryTraces(combineToShort(bytes[14], bytes[15]));
            fileHeader.setSampleIntervalInMicroseconds(combineToShort(bytes[16], bytes[17]));
            fileHeader.setSampleIntervalInMicrosecondsOriginal(combineToShort(bytes[18], bytes[19]));
            fileHeader.setSamplesPerDataTrace(combineToShort(bytes[20], bytes[21]));
            fileHeader.setSamplesPerDataTraceOriginal(combineToShort(bytes[22], bytes[23]));
            fileHeader.setDataSampleFormatCode(combineToShort(bytes[24], bytes[25]));
            fileHeader.setEnsembleFold(combineToShort(bytes[26], bytes[27]));
            fileHeader.setTraceSortingCode(combineToShort(bytes[28], bytes[29]));
            fileHeader.setVerticalSumCode(combineToShort(bytes[30], bytes[31]));
            fileHeader.setSweepFrequencyAtStart(combineToShort(bytes[32], bytes[33]));
            fileHeader.setSweepFrequencyAtEnd(combineToShort(bytes[34], bytes[35]));
            fileHeader.setSweepLength(combineToShort(bytes[36], bytes[37]));
            fileHeader.setSweepTypeCode(combineToShort(bytes[38], bytes[39]));
            fileHeader.setTraceNumberOfSweepChannel(combineToShort(bytes[40], bytes[41]));
            fileHeader.setSweepTraceTaperLengthStart(combineToShort(bytes[42], bytes[43]));
            fileHeader.setSweepTraceTaperLengthEnd(combineToShort(bytes[44], bytes[45]));
            fileHeader.setTaperType(combineToShort(bytes[46], bytes[47]));
            fileHeader.setCorrelatedDataTraces(combineToShort(bytes[48], bytes[49]));
            fileHeader.setBinaryGainRecovered(combineToShort(bytes[50], bytes[51]));
            fileHeader.setAmplitudeRecoveryMethod(combineToShort(bytes[52], bytes[53]));
            fileHeader.setMeasurementSystem(combineToShort(bytes[54], bytes[55]));
            fileHeader.setImpulseSignalPolarity(combineToShort(bytes[56], bytes[57]));
            fileHeader.setVibratoryPolarityCode(combineToShort(bytes[58], bytes[59]));
            fileHeader.setSEGYFormatRevisionNumber(combineToShort(bytes[300], bytes[301]));
            fileHeader.setFixedLengthTraceFlag(combineToShort(bytes[302], bytes[303]));
            fileHeader.setExtendedTextualFileHeader(combineToShort(bytes[304], bytes[305]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileHeader;
    }

    /**
     * 解析 SEG-Y 文件的的数据体
     *
     * @param file SEG-Y 文件
     * @return DataTrace
     */
    public static Map<Long, DataTrace> parseDataBody(File file, FileHeader fileHeader, boolean processDisplay) {
        return parseDataBody(file.getAbsolutePath(), fileHeader, processDisplay);
    }

    /**
     * 解析 SEG-Y 文件的数据体
     *
     * @param filePath SEG-Y 文件路径
     * @return DataTrace
     */
    public static Map<Long, DataTrace> parseDataBody(String filePath, FileHeader fileHeader, boolean processDisplay) {
        Map<Long, DataTrace> dataBodyMap = new HashMap<>();

        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            long cnt = 0;
            file.seek(3600L); // 跳过文件头 3600 bytes

            while (file.getFilePointer() < file.length()) {
                cnt++;
                if (processDisplay)
                    System.out.println("++第 " + cnt + " 数据道++");
                DataTrace dataTrace = new DataTrace();
                byte[] bytes = new byte[240];
                file.read(bytes, 0, bytes.length);
                ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN);

                dataTrace.setTraceSequenceNumberWithinLine(buffer.getInt());
                dataTrace.setTraceSequenceNumberWithinSEGY(buffer.getInt());
                dataTrace.setOriginalFieldRecordNumber(buffer.getInt());
                dataTrace.setTraceNumberWithinTheOriginal(buffer.getInt());
                dataTrace.setEnergySourcePointNumber(buffer.getInt());
                dataTrace.setEnsembleNumber(buffer.getInt());
                dataTrace.setTraceNumberWithinTheEnsemble(buffer.getInt());
                dataTrace.setTraceIdentificationCode(buffer.getShort());
                dataTrace.setVerticallySummedTraces(buffer.getShort());
                dataTrace.setHorizontallyStackedTraces(buffer.getShort());
                dataTrace.setDataUse(buffer.getShort());
                dataTrace.setSourcePointToReceiverGroup(buffer.getInt());
                dataTrace.setReceiverGroupElevation(buffer.getInt());
                dataTrace.setSurfaceElevationAtSource(buffer.getInt());
                dataTrace.setSourceDepthBelowSurface(buffer.getInt());
                dataTrace.setDatumElevationAtReceiverGroup(buffer.getInt());
                dataTrace.setDatumElevationAtSource(buffer.getInt());
                dataTrace.setWaterDepthAtSource(buffer.getInt());
                dataTrace.setWaterDepthAtGroup(buffer.getInt());
                dataTrace.setScalar1(buffer.getShort());
                dataTrace.setScalar2(buffer.getShort());
                dataTrace.setSourceCoordinateX(buffer.getInt());
                dataTrace.setSourceCoordinateY(buffer.getInt());
                dataTrace.setGroupCoordinateX(buffer.getInt());
                dataTrace.setGroupCoordinateY(buffer.getInt());
                dataTrace.setCoordinateUnits(buffer.getShort());
                dataTrace.setWeatheringVelocity(buffer.getShort());
                dataTrace.setSubweatheringVelocity(buffer.getShort());
                dataTrace.setUpholeTimeAtSourceInMilliseconds(buffer.getShort());
                dataTrace.setUpholeTimeAtGroupInMilliseconds(buffer.getShort());
                dataTrace.setSourceStaticCorrectionInMilliseconds(buffer.getShort());
                dataTrace.setGroupStaticCorrectionInMilliseconds(buffer.getShort());
                dataTrace.setTotalStaticAppliedInMilliseconds(buffer.getShort());
                dataTrace.setLagTimeA(buffer.getShort());
                dataTrace.setLagTimeB(buffer.getShort());
                dataTrace.setDelayRecordingTime(buffer.getShort());
                dataTrace.setMuteTimeStart(buffer.getShort());
                dataTrace.setMuteTimeEnd(buffer.getShort());
                dataTrace.setNumberOfSamplesInThisTrace(buffer.getShort());
                dataTrace.setSampleIntervalInMicroseconds(buffer.getShort());
                dataTrace.setGainTypeOfFieldInstruments(buffer.getShort());
                dataTrace.setInstrumentGainConstant(buffer.getShort());
                dataTrace.setInstrumentEarlyOrInitialGain(buffer.getShort());
                dataTrace.setCorrelated(buffer.getShort());
                dataTrace.setSweepFrequencyAtStart(buffer.getShort());
                dataTrace.setSweepFrequencyAtEnd(buffer.getShort());
                dataTrace.setSweepLengthInMilliseconds(buffer.getShort());
                dataTrace.setSweepType(buffer.getShort());
                dataTrace.setSweepTraceTaperLengthAtStart(buffer.getShort());
                dataTrace.setSweepTraceTaperLengthAtEnd(buffer.getShort());
                dataTrace.setTaperType(buffer.getShort());
                dataTrace.setAliasFilterFrequency(buffer.getShort());
                dataTrace.setAliasFilterSlope(buffer.getShort());
                dataTrace.setNotchFilterFrequency(buffer.getShort());
                dataTrace.setNotchFilterSlope(buffer.getShort());
                dataTrace.setLowCutFrequency(buffer.getShort());
                dataTrace.setHighCutFrequency(buffer.getShort());
                dataTrace.setLowCutSlope(buffer.getShort());
                dataTrace.setHighCutSlope(buffer.getShort());
                dataTrace.setYearDataRecorded(buffer.getShort());
                dataTrace.setDayOfYear(buffer.getShort());
                dataTrace.setHourOfDay(buffer.getShort());
                dataTrace.setMinuteOfHour(buffer.getShort());
                dataTrace.setSecondOfMinute(buffer.getShort());
                dataTrace.setTimeBasisCode(buffer.getShort());
                dataTrace.setTraceWeightingFactor(buffer.getShort());
                dataTrace.setRollSwitchPositionOne(buffer.getShort());
                dataTrace.setTraceNumberOneWithinOriginal(buffer.getShort());
                dataTrace.setLastTraceWithinOriginal(buffer.getShort());
                dataTrace.setGapSize(buffer.getShort());
                dataTrace.setOverTravelAssociated(buffer.getShort());
                dataTrace.setxCoordinateOfEnsemble(buffer.getInt());
                dataTrace.setyCoordinateOfEnsemble(buffer.getInt());
                dataTrace.setInLineNumber(buffer.getInt());
                dataTrace.setCrossLineNumber(buffer.getInt());
                dataTrace.setShotpointNumber(buffer.getInt());
                dataTrace.setScalar3(buffer.getShort());
                dataTrace.setTraceValueMeasurementUnit(buffer.getShort());
                dataTrace.setTransductionConstant(get6BytesAsLong(buffer));
                dataTrace.setTransductionUnits(buffer.getShort());
                dataTrace.setDeviceTraceIdentifier(buffer.getShort());
                dataTrace.setScalar4(buffer.getShort());
                dataTrace.setSourceTypeOrientation(buffer.getShort());
                dataTrace.setSourceEnergyDirection(get6BytesAsLong(buffer));
                dataTrace.setSourceMeasurement(get6BytesAsLong(buffer));
                dataTrace.setSourceMeasurementUnit(buffer.getShort());

                // 处理数据体第二部分
                float[] floats = new float[dataTrace.getNumberOfSamplesInThisTrace()];
                for (int i = 0; i < dataTrace.getNumberOfSamplesInThisTrace(); i++) {
                    switch (fileHeader.getDataSampleFormatCode()) {
                        case 1: // IBM浮点数
                            floats[i] = convertIbmToFloat(file.readInt());
                            break;
                        case 5: // IEEE浮点数
                            floats[i] = file.readFloat();
                            break;
                        case 3: // 16位整型
                            floats[i] = file.readShort();
                            break;
                        default:
                            throw new UnsupportedOperationException("Unsupported format code: " + fileHeader.getDataSampleFormatCode());
                    }
                }
                dataTrace.setSamplingData(floats);

                dataBodyMap.put(cnt, dataTrace);

                if (processDisplay)
                    System.out.println(dataTrace);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataBodyMap;
    }

    // 6 字节合并为 long 型
    private static long combineToLong(byte a, byte b, byte c, byte d, byte e, byte f) {
        long res = 0;
        res += (long) a << 40;
        res += (long) b << 32;
        res += c << 24;
        res += d << 16;
        res += e << 8;
        res += f;

        return res;
    }

    // 4 字节合并为 short 型
    private static int combineToInt(byte a, byte b, byte c, byte d) {
        int res = 0;
        res += a << 24;
        res += b << 16;
        res += c << 8;
        res += d;

        return res;
    }

    // 2 字节合并为 short 型
    private static short combineToShort(byte a, byte b) {
        short res = 0;
        res += (short) (a << 8);
        res += b;

        return res;
    }

    // IBM 浮点数转换 (实现参考 SEG-Y 规范)
    private static float convertIbmToFloat(int ibmFloat) {
        int sign = ((ibmFloat >> 31) == 0) ? 1 : -1;
        int exponent = ((ibmFloat >> 24) & 0x7F) - 64;
        int mantissa = (ibmFloat & 0x00FFFFFF);
        return (float) (sign * mantissa * Math.pow(16, exponent - 6));
    }

    // 读取 6 字节为 long 型，按大端序拼接
    private static long get6BytesAsLong(ByteBuffer buffer) {
        long value = 0;
        for (int i = 0; i < 6; i++) {
            value = (value << 8) | (buffer.get() & 0xFF);
        }
        return value;
    }
}
