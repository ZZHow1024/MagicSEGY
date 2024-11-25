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
     * 解析 SEG Y 文件的数据体
     *
     * @param file SEG Y 文件
     * @return DataBody
     */
    public static DataBody parseDataBody(File file) {
        return null;
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
