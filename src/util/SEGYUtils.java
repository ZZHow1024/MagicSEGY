package util;

import pojo.entity.DataBody;
import pojo.entity.FileHeader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ZZHow
 * @date 2024/11/25
 */
public class SEGYUtils {

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
     * @param filePath SEG Y 文件路径
     * @return DataBody
     */
    public static DataBody parseDataBody(String filePath, FileHeader fileHeader) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("文件不存在");

            return null;
        }

        return parseDataBody(file, fileHeader);
    }

    /**
     * 解析 SEG Y 文件的数据体
     *
     * @param file SEG Y 文件
     * @return DataBody
     */
    public static DataBody parseDataBody(File file, FileHeader fileHeader) {
        DataBody dataBody = new DataBody();

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.skip(3600);

            byte[] bytes = new byte[240];
            fileInputStream.read(bytes, 0, bytes.length);

            dataBody.setTraceSequenceNumberWithinLine(combineToInt(bytes[0], bytes[1], bytes[2], bytes[3]));
            dataBody.setTraceSequenceNumberWithinSEGY(combineToInt(bytes[4], bytes[5], bytes[6], bytes[7]));
            dataBody.setOriginalFieldRecordNumber(combineToInt(bytes[8], bytes[9], bytes[10], bytes[11]));
            dataBody.setTraceNumberWithinTheOriginal(combineToInt(bytes[12], bytes[13], bytes[14], bytes[15]));
            dataBody.setEnergySourcePointNumber(combineToInt(bytes[16], bytes[17], bytes[18], bytes[19]));
            dataBody.setEnsembleNumber(combineToInt(bytes[20], bytes[21], bytes[22], bytes[23]));
            dataBody.setTraceNumberWithinTheEnsemble(combineToInt(bytes[24], bytes[25], bytes[26], bytes[27]));
            dataBody.setTraceIdentificationCode(combineToShort(bytes[28], bytes[29]));
            dataBody.setVerticallySummedTraces(combineToShort(bytes[30], bytes[31]));
            dataBody.setHorizontallyStackedTraces(combineToShort(bytes[32], bytes[33]));
            dataBody.setDataUse(combineToShort(bytes[34], bytes[35]));
            dataBody.setSourcePointToReceiverGroup(combineToInt(bytes[36], bytes[37], bytes[38], bytes[39]));
            dataBody.setReceiverGroupElevation(combineToInt(bytes[40], bytes[41], bytes[42], bytes[43]));
            dataBody.setSurfaceElevationAtSource(combineToInt(bytes[44], bytes[45], bytes[46], bytes[47]));
            dataBody.setSourceDepthBelowSurface(combineToInt(bytes[48], bytes[49], bytes[50], bytes[51]));
            dataBody.setDatumElevationAtReceiverGroup(combineToInt(bytes[52], bytes[53], bytes[54], bytes[55]));
            dataBody.setDatumElevationAtSource(combineToInt(bytes[56], bytes[57], bytes[58], bytes[59]));
            dataBody.setWaterDepthAtSource(combineToInt(bytes[60], bytes[61], bytes[62], bytes[63]));
            dataBody.setWaterDepthAtGroup(combineToInt(bytes[64], bytes[65], bytes[66], bytes[67]));
            dataBody.setScalar1(combineToShort(bytes[68], bytes[69]));
            dataBody.setScalar2(combineToShort(bytes[70], bytes[71]));
            dataBody.setSourceCoordinateX(combineToInt(bytes[72], bytes[73], bytes[74], bytes[75]));
            dataBody.setSourceCoordinateY(combineToInt(bytes[76], bytes[77], bytes[78], bytes[79]));
            dataBody.setGroupCoordinateX(combineToInt(bytes[80], bytes[81], bytes[82], bytes[83]));
            dataBody.setGroupCoordinateY(combineToInt(bytes[84], bytes[85], bytes[86], bytes[87]));
            dataBody.setCoordinateUnits(combineToShort(bytes[88], bytes[89]));
            dataBody.setWeatheringVelocity(combineToShort(bytes[90], bytes[91]));
            dataBody.setSubweatheringVelocity(combineToShort(bytes[92], bytes[93]));
            dataBody.setUpholeTimeAtSourceInMilliseconds(combineToShort(bytes[94], bytes[95]));
            dataBody.setUpholeTimeAtGroupInMilliseconds(combineToShort(bytes[96], bytes[97]));
            dataBody.setSourceStaticCorrectionInMilliseconds(combineToShort(bytes[98], bytes[99]));
            dataBody.setGroupStaticCorrectionInMilliseconds(combineToShort(bytes[100], bytes[101]));
            dataBody.setTotalStaticAppliedInMilliseconds(combineToShort(bytes[102], bytes[103]));
            dataBody.setLagTimeA(combineToShort(bytes[104], bytes[105]));
            dataBody.setLagTimeB(combineToShort(bytes[106], bytes[107]));
            dataBody.setDelayRecordingTime(combineToShort(bytes[108], bytes[109]));
            dataBody.setMuteTimeStart(combineToShort(bytes[110], bytes[111]));
            dataBody.setMuteTimeEnd(combineToShort(bytes[112], bytes[113]));
            dataBody.setNumberOfSamplesInThisTrace(combineToShort(bytes[114], bytes[115]));
            dataBody.setSampleIntervalInMicroseconds(combineToShort(bytes[116], bytes[117]));
            dataBody.setGainTypeOfFieldInstruments(combineToShort(bytes[118], bytes[119]));
            dataBody.setInstrumentGainConstant(combineToShort(bytes[120], bytes[121]));
            dataBody.setInstrumentEarlyOrInitialGain(combineToShort(bytes[122], bytes[123]));
            dataBody.setCorrelated(combineToShort(bytes[124], bytes[125]));
            dataBody.setSweepFrequencyAtStart(combineToShort(bytes[126], bytes[127]));
            dataBody.setSweepFrequencyAtEnd(combineToShort(bytes[128], bytes[129]));
            dataBody.setSweepLengthInMilliseconds(combineToShort(bytes[130], bytes[131]));
            dataBody.setSweepType(combineToShort(bytes[132], bytes[133]));
            dataBody.setSweepTraceTaperLengthAtStart(combineToShort(bytes[134], bytes[135]));
            dataBody.setSweepTraceTaperLengthAtEnd(combineToShort(bytes[136], bytes[137]));
            dataBody.setTaperType(combineToShort(bytes[138], bytes[139]));
            dataBody.setAliasFilterFrequency(combineToShort(bytes[140], bytes[141]));
            dataBody.setAliasFilterSlope(combineToShort(bytes[142], bytes[143]));
            dataBody.setNotchFilterFrequency(combineToShort(bytes[144], bytes[145]));
            dataBody.setNotchFilterSlope(combineToShort(bytes[146], bytes[147]));
            dataBody.setLowCutFrequency(combineToShort(bytes[148], bytes[149]));
            dataBody.setHighCutFrequency(combineToShort(bytes[150], bytes[151]));
            dataBody.setLowCutSlope(combineToShort(bytes[152], bytes[153]));
            dataBody.setHighCutSlope(combineToShort(bytes[154], bytes[155]));
            dataBody.setYearDataRecorded(combineToShort(bytes[156], bytes[157]));
            dataBody.setDayOfYear(combineToShort(bytes[158], bytes[159]));
            dataBody.setHourOfDay(combineToShort(bytes[160], bytes[161]));
            dataBody.setMinuteOfHour(combineToShort(bytes[162], bytes[163]));
            dataBody.setSecondOfMinute(combineToShort(bytes[164], bytes[165]));
            dataBody.setTimeBasisCode(combineToShort(bytes[166], bytes[167]));
            dataBody.setTraceWeightingFactor(combineToShort(bytes[168], bytes[169]));
            dataBody.setRollSwitchPositionOne(combineToShort(bytes[170], bytes[171]));
            dataBody.setTraceNumberOneWithinOriginal(combineToShort(bytes[172], bytes[173]));
            dataBody.setLastTraceWithinOriginal(combineToShort(bytes[174], bytes[175]));
            dataBody.setGapSize(combineToShort(bytes[176], bytes[177]));
            dataBody.setOverTravelAssociated(combineToShort(bytes[178], bytes[179]));
            dataBody.setxCoordinateOfEnsemble(combineToInt(bytes[180], bytes[181], bytes[182], bytes[183]));
            dataBody.setyCoordinateOfEnsemble(combineToInt(bytes[184], bytes[185], bytes[186], bytes[187]));
            dataBody.setInLineNumber(combineToInt(bytes[188], bytes[189], bytes[190], bytes[191]));
            dataBody.setCrossLineNumber(combineToInt(bytes[192], bytes[193], bytes[194], bytes[195]));
            dataBody.setShotpointNumber(combineToInt(bytes[196], bytes[197], bytes[198], bytes[199]));
            dataBody.setScalar3(combineToShort(bytes[200], bytes[201]));
            dataBody.setTraceValueMeasurementUnit(combineToShort(bytes[202], bytes[203]));
            dataBody.setTransductionConstant(combineToLong(bytes[204], bytes[205], bytes[206], bytes[207], bytes[208], bytes[209]));
            dataBody.setTransductionUnits(combineToShort(bytes[210], bytes[211]));
            dataBody.setDeviceTraceIdentifier(combineToShort(bytes[212], bytes[213]));
            dataBody.setScalar4(combineToShort(bytes[214], bytes[215]));
            dataBody.setSourceTypeOrientation(combineToShort(bytes[216], bytes[217]));
            dataBody.setSourceEnergyDirection(combineToLong(bytes[218], bytes[219], bytes[220], bytes[221], bytes[222], bytes[223]));
            dataBody.setSourceMeasurement(combineToLong(bytes[224], bytes[225], bytes[226], bytes[227], bytes[228], bytes[229]));
            dataBody.setSourceMeasurementUnit(combineToShort(bytes[230], bytes[232]));

            int len = fileHeader.getSamplesPerDataTraceOriginal();
            switch (fileHeader.getDataSampleFormatCode()) {
                case 1, 2, 4, 5 -> len *= 4;
                case 3 -> len *= 2;
            }
            bytes = new byte[len];
            fileInputStream.read(bytes, 0, bytes.length);
            dataBody.setSamplingData(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataBody;
    }

    private static long combineToLong(byte a, byte b, byte c, byte d, byte e, long f) {
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
}
