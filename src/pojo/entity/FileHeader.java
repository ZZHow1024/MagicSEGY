package pojo.entity;

/**
 * @author ZZHow
 * @date 2024/11/25
 */
public class FileHeader {
    /* 文件头第一部分 */
    // 3200bytes，参数卡：文件头第一部分，EBCDIC字符集
    private String textualFileHeader;

    /* 文件头第二部分 */
    // 3201-3204：作业标识号
    private Integer jobIdentificationNumber;
    // 3205-3208：测线号
    private Integer LineNumber;
    // 3209-3212：卷号
    private Integer ReelNumber;
    // 3213-3214：每个道集的数据道数。叠前数据强制要求
    private Short dataTraces;
    // 3215-3216：每个道集的辅助道数。叠前数据强制要求
    private Short auxiliaryTraces;
    // 3217-3218：微秒（us）形式的采样间隔。叠前数据强制要求
    private Short sampleIntervalInMicroseconds;
    // 3219-3220：微秒（us）形式的原始野外记录采样间隔
    private Short sampleIntervalInMicrosecondsOriginal;
    // 3221-3222：数据道采样点数。叠前数据强制要求
    private Short samplesPerDataTrace;
    // 3223-3224：原始野外记录每道采样点数
    private Short samplesPerDataTraceOriginal;
    // 3225-3226：数据采样格式编码
    private Short dataSampleFormatCode;
    // 3227-3228：道集覆盖次数――每个数据集的期望数据道数（例如CMP覆盖次数）
    private Short ensembleFold;
    // 3229-3230：道分选码（即集合类型）
    private Short traceSortingCode;
    // 3231-3232：垂直求和码
    private Short verticalSumCode;
    // 3233-3234：起始扫描频率（Hz）
    private Short sweepFrequencyAtStart;
    // 3235-3236：终止扫描频率（Hz）
    private Short sweepFrequencyAtEnd;
    // 3237-3238：扫描长度（ms）
    private Short sweepLength;
    // 3239-3240：扫描类型码
    private Short sweepTypeCode;
    // 3241-3242：扫描信道的道数
    private Short traceNumberOfSweepChannel;
    // 3243-3244：有斜坡时，以毫秒表示的扫描道起始斜坡长度（斜坡从零时刻开始，对这个长度有效）
    private Short sweepTraceTaperLengthStart;
    // 3245-3246：以毫秒表示的扫描道终止斜坡长度（斜坡终止始于扫描长度减去斜坡结尾处的长度）
    private Short sweepTraceTaperLengthEnd;
    // 3247-3248：斜坡类型
    private Short taperType;
    // 3249-3250：相关数据道
    private Short correlatedDataTraces;
    // 3251-3252：二进制增益恢复
    private Short binaryGainRecovered;
    // 3253-3254：振幅恢复方法
    private Short amplitudeRecoveryMethod;
    // 3255-3256：测量系统
    private Short measurementSystem;
    // 3257-3258：脉冲极化码
    private Short impulseSignalPolarity;
    // 3259-3260：可控源极化码
    private Short vibratoryPolarityCode;
    // 3261-3500：未赋值
    /**/
    // 3501-3502：SEG Y格式修订版号
    private Short SEGYFormatRevisionNumber;
    // 3503-3504：固定长度道标志
    private Short fixedLengthTraceFlag;
    // 3505-3506：3200字节扩展原文文件头记录在二进制头后
    private Short extendedTextualFileHeader;
    // 3507-3600：未赋值
    /**/

    public FileHeader() {
    }

    public String getTextualFileHeader() {
        return textualFileHeader;
    }

    public Integer getJobIdentificationNumber() {
        return jobIdentificationNumber;
    }

    public Integer getLineNumber() {
        return LineNumber;
    }

    public Integer getReelNumber() {
        return ReelNumber;
    }

    public Short getDataTraces() {
        return dataTraces;
    }

    public Short getAuxiliaryTraces() {
        return auxiliaryTraces;
    }

    public Short getSampleIntervalInMicroseconds() {
        return sampleIntervalInMicroseconds;
    }

    public Short getSampleIntervalInMicrosecondsOriginal() {
        return sampleIntervalInMicrosecondsOriginal;
    }

    public Short getSamplesPerDataTrace() {
        return samplesPerDataTrace;
    }

    public Short getSamplesPerDataTraceOriginal() {
        return samplesPerDataTraceOriginal;
    }

    public Short getDataSampleFormatCode() {
        return dataSampleFormatCode;
    }

    public Short getEnsembleFold() {
        return ensembleFold;
    }

    public Short getTraceSortingCode() {
        return traceSortingCode;
    }

    public Short getVerticalSumCode() {
        return verticalSumCode;
    }

    public Short getSweepFrequencyAtStart() {
        return sweepFrequencyAtStart;
    }

    public Short getSweepFrequencyAtEnd() {
        return sweepFrequencyAtEnd;
    }

    public Short getSweepLength() {
        return sweepLength;
    }

    public Short getSweepTypeCode() {
        return sweepTypeCode;
    }

    public Short getTraceNumberOfSweepChannel() {
        return traceNumberOfSweepChannel;
    }

    public Short getSweepTraceTaperLengthStart() {
        return sweepTraceTaperLengthStart;
    }

    public Short getSweepTraceTaperLengthEnd() {
        return sweepTraceTaperLengthEnd;
    }

    public Short getTaperType() {
        return taperType;
    }

    public Short getCorrelatedDataTraces() {
        return correlatedDataTraces;
    }

    public Short getBinaryGainRecovered() {
        return binaryGainRecovered;
    }

    public Short getAmplitudeRecoveryMethod() {
        return amplitudeRecoveryMethod;
    }

    public Short getMeasurementSystem() {
        return measurementSystem;
    }

    public Short getImpulseSignalPolarity() {
        return impulseSignalPolarity;
    }

    public Short getVibratoryPolarityCode() {
        return vibratoryPolarityCode;
    }

    public Short getSEGYFormatRevisionNumber() {
        return SEGYFormatRevisionNumber;
    }

    public Short getFixedLengthTraceFlag() {
        return fixedLengthTraceFlag;
    }

    public Short getExtendedTextualFileHeader() {
        return extendedTextualFileHeader;
    }

    public void setTextualFileHeader(String textualFileHeader) {
        this.textualFileHeader = textualFileHeader;
    }

    public void setJobIdentificationNumber(Integer jobIdentificationNumber) {
        this.jobIdentificationNumber = jobIdentificationNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        LineNumber = lineNumber;
    }

    public void setReelNumber(Integer reelNumber) {
        ReelNumber = reelNumber;
    }

    public void setDataTraces(Short dataTraces) {
        this.dataTraces = dataTraces;
    }

    public void setAuxiliaryTraces(Short auxiliaryTraces) {
        this.auxiliaryTraces = auxiliaryTraces;
    }

    public void setSampleIntervalInMicroseconds(Short sampleIntervalInMicroseconds) {
        this.sampleIntervalInMicroseconds = sampleIntervalInMicroseconds;
    }

    public void setSampleIntervalInMicrosecondsOriginal(Short sampleIntervalInMicrosecondsOriginal) {
        this.sampleIntervalInMicrosecondsOriginal = sampleIntervalInMicrosecondsOriginal;
    }

    public void setSamplesPerDataTrace(Short samplesPerDataTrace) {
        this.samplesPerDataTrace = samplesPerDataTrace;
    }

    public void setSamplesPerDataTraceOriginal(Short samplesPerDataTraceOriginal) {
        this.samplesPerDataTraceOriginal = samplesPerDataTraceOriginal;
    }

    public void setDataSampleFormatCode(Short dataSampleFormatCode) {
        this.dataSampleFormatCode = dataSampleFormatCode;
    }

    public void setEnsembleFold(Short ensembleFold) {
        this.ensembleFold = ensembleFold;
    }

    public void setTraceSortingCode(Short traceSortingCode) {
        this.traceSortingCode = traceSortingCode;
    }

    public void setVerticalSumCode(Short verticalSumCode) {
        this.verticalSumCode = verticalSumCode;
    }

    public void setSweepFrequencyAtStart(Short sweepFrequencyAtStart) {
        this.sweepFrequencyAtStart = sweepFrequencyAtStart;
    }

    public void setSweepFrequencyAtEnd(Short sweepFrequencyAtEnd) {
        this.sweepFrequencyAtEnd = sweepFrequencyAtEnd;
    }

    public void setSweepLength(Short sweepLength) {
        this.sweepLength = sweepLength;
    }

    public void setSweepTypeCode(Short sweepTypeCode) {
        this.sweepTypeCode = sweepTypeCode;
    }

    public void setTraceNumberOfSweepChannel(Short traceNumberOfSweepChannel) {
        this.traceNumberOfSweepChannel = traceNumberOfSweepChannel;
    }

    public void setSweepTraceTaperLengthStart(Short sweepTraceTaperLengthStart) {
        this.sweepTraceTaperLengthStart = sweepTraceTaperLengthStart;
    }

    public void setSweepTraceTaperLengthEnd(Short sweepTraceTaperLengthEnd) {
        this.sweepTraceTaperLengthEnd = sweepTraceTaperLengthEnd;
    }

    public void setTaperType(Short taperType) {
        this.taperType = taperType;
    }

    public void setCorrelatedDataTraces(Short correlatedDataTraces) {
        this.correlatedDataTraces = correlatedDataTraces;
    }

    public void setBinaryGainRecovered(Short binaryGainRecovered) {
        this.binaryGainRecovered = binaryGainRecovered;
    }

    public void setAmplitudeRecoveryMethod(Short amplitudeRecoveryMethod) {
        this.amplitudeRecoveryMethod = amplitudeRecoveryMethod;
    }

    public void setMeasurementSystem(Short measurementSystem) {
        this.measurementSystem = measurementSystem;
    }

    public void setImpulseSignalPolarity(Short impulseSignalPolarity) {
        this.impulseSignalPolarity = impulseSignalPolarity;
    }

    public void setVibratoryPolarityCode(Short vibratoryPolarityCode) {
        this.vibratoryPolarityCode = vibratoryPolarityCode;
    }

    public void setSEGYFormatRevisionNumber(Short SEGYFormatRevisionNumber) {
        this.SEGYFormatRevisionNumber = SEGYFormatRevisionNumber;
    }

    public void setFixedLengthTraceFlag(Short fixedLengthTraceFlag) {
        this.fixedLengthTraceFlag = fixedLengthTraceFlag;
    }

    public void setExtendedTextualFileHeader(Short extendedTextualFileHeader) {
        this.extendedTextualFileHeader = extendedTextualFileHeader;
    }

    @Override
    public String toString() {
        return "###文件头第一部分###\n" +
                textualFileHeader +
                "\n\n###文件头第二部分###" +
                "\n作业标识号=" + jobIdentificationNumber +
                "\n测线号=" + LineNumber +
                "\n卷号=" + ReelNumber +
                "\n每个道集的数据道数=" + dataTraces +
                "\n每个道集的辅助道数=" + auxiliaryTraces +
                "\n微秒（us）形式的采样间隔=" + sampleIntervalInMicroseconds +
                "\n微秒（us）形式的原始野外记录采样间隔=" + sampleIntervalInMicrosecondsOriginal +
                "\n数据道采样点数=" + samplesPerDataTrace +
                "\n原始野外记录每道采样点数=" + samplesPerDataTraceOriginal +
                "\n数据采样格式编码=" + dataSampleFormatCode +
                "\n道集覆盖次数=" + ensembleFold +
                "\n道分选码=" + traceSortingCode +
                "\n垂直求和码=" + verticalSumCode +
                "\n起始扫描频率（Hz）=" + sweepFrequencyAtStart +
                "\n终止扫描频率（Hz）=" + sweepFrequencyAtEnd +
                "\n扫描长度（ms）=" + sweepLength +
                "\n扫描类型码=" + sweepTypeCode +
                "\n扫描信道的道数=" + traceNumberOfSweepChannel +
                "\n以毫秒表示的扫描道起始斜坡长度=" + sweepTraceTaperLengthStart +
                "\n以毫秒表示的扫描道终止斜坡长度=" + sweepTraceTaperLengthEnd +
                "\n斜坡类型=" + taperType +
                "\n相关数据道=" + correlatedDataTraces +
                "\n二进制增益恢复=" + binaryGainRecovered +
                "\n振幅恢复方法=" + amplitudeRecoveryMethod +
                "\n测量系统=" + measurementSystem +
                "\n脉冲极化码=" + impulseSignalPolarity +
                "\n可控源极化码=" + vibratoryPolarityCode +
                "\nSEG Y格式修订版号=" + SEGYFormatRevisionNumber +
                "\n固定长度道标志=" + fixedLengthTraceFlag +
                "\n3200字节扩展原文文件头记录在二进制头后=" + extendedTextualFileHeader;
    }
}
