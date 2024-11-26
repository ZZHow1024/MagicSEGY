package util;

import pojo.entity.DataBody;
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

    public static SEGY parseSEGY(String filePath) {
        SEGY segy = new SEGY();

        System.out.println("正在解析文件中，请稍后...");
        long start = System.currentTimeMillis();
        FileHeader fileHeader = SEGYUtils.parseFileHeader(filePath);
        segy.setFileHeader(fileHeader);
        Map<Long, DataBody> longDataBodyMap = null;
        longDataBodyMap = SEGYUtils.parseDataBody(filePath, fileHeader, false);
        segy.setDataBodies(longDataBodyMap);
        long end = System.currentTimeMillis();
        System.out.println("文件解析完成，耗时：" + (end - start) + "ms");
        System.out.println("文件共有 " + longDataBodyMap.keySet().size() + " 个数据道");

        return segy;
    }

    /**
     * 解析 SEG Y 文件的的文件头
     *
     * @param filePath SEG Y 文件路径
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
     * 解析 SEG Y 文件的的文件头
     *
     * @param file SEG Y 文件
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
     * 解析 SEG Y 文件的的数据体
     *
     * @param file SEG Y 文件
     * @return DataBody
     */
    public static Map<Long, DataBody> parseDataBody(File file, FileHeader fileHeader, boolean processDisplay) {
        return parseDataBody(file.getAbsolutePath(), fileHeader, processDisplay);
    }

    /**
     * 解析 SEG Y 文件的数据体
     *
     * @param filePath SEG Y 文件路径
     * @return DataBody
     */
    public static Map<Long, DataBody> parseDataBody(String filePath, FileHeader fileHeader, boolean processDisplay) {
        Map<Long, DataBody> dataBodyMap = new HashMap<>();

        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            long cnt = 0;
            file.seek(3600L); // 跳过文件头 3600 bytes

            while (file.getFilePointer() < file.length()) {
                cnt++;
                if (processDisplay)
                    System.out.println("++第 " + cnt + " 数据道++");
                DataBody dataBody = new DataBody();
                byte[] bytes = new byte[240];
                file.read(bytes, 0, bytes.length);
                ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN);

                dataBody.setTraceSequenceNumberWithinLine(buffer.getInt());
                dataBody.setTraceSequenceNumberWithinSEGY(buffer.getInt());
                dataBody.setOriginalFieldRecordNumber(buffer.getInt());
                dataBody.setTraceNumberWithinTheOriginal(buffer.getInt());
                dataBody.setEnergySourcePointNumber(buffer.getInt());
                dataBody.setEnsembleNumber(buffer.getInt());
                dataBody.setTraceNumberWithinTheEnsemble(buffer.getInt());
                dataBody.setTraceIdentificationCode(buffer.getShort());
                dataBody.setVerticallySummedTraces(buffer.getShort());
                dataBody.setHorizontallyStackedTraces(buffer.getShort());
                dataBody.setDataUse(buffer.getShort());
                dataBody.setSourcePointToReceiverGroup(buffer.getInt());
                dataBody.setReceiverGroupElevation(buffer.getInt());
                dataBody.setSurfaceElevationAtSource(buffer.getInt());
                dataBody.setSourceDepthBelowSurface(buffer.getInt());
                dataBody.setDatumElevationAtReceiverGroup(buffer.getInt());
                dataBody.setDatumElevationAtSource(buffer.getInt());
                dataBody.setWaterDepthAtSource(buffer.getInt());
                dataBody.setWaterDepthAtGroup(buffer.getInt());
                dataBody.setScalar1(buffer.getShort());
                dataBody.setScalar2(buffer.getShort());
                dataBody.setSourceCoordinateX(buffer.getInt());
                dataBody.setSourceCoordinateY(buffer.getInt());
                dataBody.setGroupCoordinateX(buffer.getInt());
                dataBody.setGroupCoordinateY(buffer.getInt());
                dataBody.setCoordinateUnits(buffer.getShort());
                dataBody.setWeatheringVelocity(buffer.getShort());
                dataBody.setSubweatheringVelocity(buffer.getShort());
                dataBody.setUpholeTimeAtSourceInMilliseconds(buffer.getShort());
                dataBody.setUpholeTimeAtGroupInMilliseconds(buffer.getShort());
                dataBody.setSourceStaticCorrectionInMilliseconds(buffer.getShort());
                dataBody.setGroupStaticCorrectionInMilliseconds(buffer.getShort());
                dataBody.setTotalStaticAppliedInMilliseconds(buffer.getShort());
                dataBody.setLagTimeA(buffer.getShort());
                dataBody.setLagTimeB(buffer.getShort());
                dataBody.setDelayRecordingTime(buffer.getShort());
                dataBody.setMuteTimeStart(buffer.getShort());
                dataBody.setMuteTimeEnd(buffer.getShort());
                dataBody.setNumberOfSamplesInThisTrace(buffer.getShort());
                dataBody.setSampleIntervalInMicroseconds(buffer.getShort());
                dataBody.setGainTypeOfFieldInstruments(buffer.getShort());
                dataBody.setInstrumentGainConstant(buffer.getShort());
                dataBody.setInstrumentEarlyOrInitialGain(buffer.getShort());
                dataBody.setCorrelated(buffer.getShort());
                dataBody.setSweepFrequencyAtStart(buffer.getShort());
                dataBody.setSweepFrequencyAtEnd(buffer.getShort());
                dataBody.setSweepLengthInMilliseconds(buffer.getShort());
                dataBody.setSweepType(buffer.getShort());
                dataBody.setSweepTraceTaperLengthAtStart(buffer.getShort());
                dataBody.setSweepTraceTaperLengthAtEnd(buffer.getShort());
                dataBody.setTaperType(buffer.getShort());
                dataBody.setAliasFilterFrequency(buffer.getShort());
                dataBody.setAliasFilterSlope(buffer.getShort());
                dataBody.setNotchFilterFrequency(buffer.getShort());
                dataBody.setNotchFilterSlope(buffer.getShort());
                dataBody.setLowCutFrequency(buffer.getShort());
                dataBody.setHighCutFrequency(buffer.getShort());
                dataBody.setLowCutSlope(buffer.getShort());
                dataBody.setHighCutSlope(buffer.getShort());
                dataBody.setYearDataRecorded(buffer.getShort());
                dataBody.setDayOfYear(buffer.getShort());
                dataBody.setHourOfDay(buffer.getShort());
                dataBody.setMinuteOfHour(buffer.getShort());
                dataBody.setSecondOfMinute(buffer.getShort());
                dataBody.setTimeBasisCode(buffer.getShort());
                dataBody.setTraceWeightingFactor(buffer.getShort());
                dataBody.setRollSwitchPositionOne(buffer.getShort());
                dataBody.setTraceNumberOneWithinOriginal(buffer.getShort());
                dataBody.setLastTraceWithinOriginal(buffer.getShort());
                dataBody.setGapSize(buffer.getShort());
                dataBody.setOverTravelAssociated(buffer.getShort());
                dataBody.setxCoordinateOfEnsemble(buffer.getInt());
                dataBody.setyCoordinateOfEnsemble(buffer.getInt());
                dataBody.setInLineNumber(buffer.getInt());
                dataBody.setCrossLineNumber(buffer.getInt());
                dataBody.setShotpointNumber(buffer.getInt());
                dataBody.setScalar3(buffer.getShort());
                dataBody.setTraceValueMeasurementUnit(buffer.getShort());
                dataBody.setTransductionConstant(get6BytesAsLong(buffer));
                dataBody.setTransductionUnits(buffer.getShort());
                dataBody.setDeviceTraceIdentifier(buffer.getShort());
                dataBody.setScalar4(buffer.getShort());
                dataBody.setSourceTypeOrientation(buffer.getShort());
                dataBody.setSourceEnergyDirection(get6BytesAsLong(buffer));
                dataBody.setSourceMeasurement(get6BytesAsLong(buffer));
                dataBody.setSourceMeasurementUnit(buffer.getShort());

                // 处理数据体第二部分
                float[] floats = new float[dataBody.getNumberOfSamplesInThisTrace()];
                for (int i = 0; i < dataBody.getNumberOfSamplesInThisTrace(); i++) {
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
                dataBody.setSamplingData(floats);

                dataBodyMap.put(cnt, dataBody);

                if (processDisplay)
                    System.out.println(dataBody);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataBodyMap;
    }

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

    private static int combineToInt(byte a, byte b, byte c, byte d) {
        int res = 0;
        res += a << 24;
        res += b << 16;
        res += c << 8;
        res += d;

        return res;
    }

    private static short combineToShort(byte a, byte b) {
        short res = 0;
        res += (short) (a << 8);
        res += b;

        return res;
    }

    // IBM浮点数转换 (实现参考 SEGY 规范)
    private static float convertIbmToFloat(int ibmFloat) {
        int sign = ((ibmFloat >> 31) == 0) ? 1 : -1;
        int exponent = ((ibmFloat >> 24) & 0x7F) - 64;
        int mantissa = (ibmFloat & 0x00FFFFFF);
        return (float) (sign * mantissa * Math.pow(16, exponent - 6));
    }

    private static long get6BytesAsLong(ByteBuffer buffer) {
        // 读取6字节，按大端序拼接
        long value = 0;
        for (int i = 0; i < 6; i++) {
            value = (value << 8) | (buffer.get() & 0xFF);
        }
        return value;
    }
}
