package pojo.entity;

import java.util.Arrays;

/**
 * @author ZZHow
 * @date 2024/11/25
 */
public class DataBody {
    /* 数据体第一部分——道头 */
    // 1-4：测线中道顺序号
    private Integer traceSequenceNumberWithinLine;
    // 5-8：SEG Y文件中道顺序号
    private Integer traceSequenceNumberWithinSEGY;
    // 9-12：野外原始记录号
    private Integer originalFieldRecordNumber;
    // 13-16：野外原始记录的道号
    private Integer traceNumberWithinTheOriginal;
    // 17-20：震源点号
    private Integer energySourcePointNumber;
    // 21-24：道集号
    private Integer ensembleNumber;
    // 25-28：道集的道数
    private Integer traceNumberWithinTheEnsemble;
    // 29-30：道识别码
    private Short traceIdentificationCode;
    // 31-32：产生该道的垂直叠加道数
    private Short verticallySummedTraces;
    // 33-34：产生该道的水平叠加道数
    private Short horizontallyStackedTraces;
    // 35-36：数据用途
    private Short dataUse;
    // 37-40：从震源中心点到检波器组中心的距离
    private Integer sourcePointToReceiverGroup;
    // 41-44：检波器组高程
    private Integer receiverGroupElevation;
    // 45-48：震源地表高程
    private Integer surfaceElevationAtSource;
    // 49-52：震源距地表深度（正数）
    private Integer sourceDepthBelowSurface;
    // 53-56：检波器组基准高程
    private Integer datumElevationAtReceiverGroup;
    // 57-60：震源基准高程
    private Integer datumElevationAtSource;
    // 61-64：震源水深
    private Integer waterDepthAtSource;
    // 65-68：检波器组水深
    private Integer waterDepthAtGroup;
    // 69-70：应用于所有在道头41-68字节给定的真实高程和深度的因子
    private Short scalar1;
    // 71-72：应用于所有在道头73-88字节和181-188字节给定的真实坐标值的因子
    private Short scalar2;
    // 73-76：震源坐标――X
    private Integer sourceCoordinateX;
    // 77-80：震源坐标――Y
    private Integer sourceCoordinateY;
    // 81-84：检波器组坐标――X
    private Integer groupCoordinateX;
    // 85-88：检波器组坐标――Y
    private Integer groupCoordinateY;
    // 89-90：坐标单位
    private Short coordinateUnits;
    // 91-92：风化层速度
    private Short weatheringVelocity;
    // 93-94：风化层下速度
    private Short subweatheringVelocity;
    // 95-96：震源处井口时间（毫秒）
    private Short upholeTimeAtSourceInMilliseconds;
    // 97-98：检波器组处井口时间（毫秒）
    private Short upholeTimeAtGroupInMilliseconds;
    // 99-100：震源的静校正量（毫秒）
    private Short sourceStaticCorrectionInMilliseconds;
    // 101-102：检波器组的校正量（毫秒）
    private Short groupStaticCorrectionInMilliseconds;
    // 103-104：应用的总静校正量（毫秒）（如没有应用静校正量为零）
    private Short totalStaticAppliedInMilliseconds;
    // 105-106：延迟时间A
    private Short lagTimeA;
    // 107-108：延迟时间B
    private Short lagTimeB;
    // 109-110：记录延迟时间
    private Short delayRecordingTime;
    // 111-112：起始切除时间（毫秒）
    private Short muteTimeStart;
    // 113-114：终止切除时间（毫秒）
    private Short muteTimeEnd;
    // 115-116：该道采样点数
    private Short numberOfSamplesInThisTrace;
    // 117-118：该道采样间隔（微秒）
    private Short sampleIntervalInMicroseconds;
    // 119-120：野外仪器增益类型
    private Short gainTypeOfFieldInstruments;
    // 121-122：仪器增益常数（分贝）
    private Short instrumentGainConstant;
    // 123-124：仪器初始增益（分贝）
    private Short instrumentEarlyOrInitialGain;
    // 125-126：相关
    private Short correlated;
    // 127-128：起始扫描频率（赫兹）
    private Short sweepFrequencyAtStart;
    // 129-130：终止扫描频率（赫兹）
    private Short sweepFrequencyAtEnd;
    // 131-132：扫描长度（毫秒）
    private Short sweepLengthInMilliseconds;
    // 133-134：扫描类型
    private Short sweepType;
    // 135-136：扫描道斜坡起始长度（毫秒）
    private Short sweepTraceTaperLengthAtStart;
    // 137-138：扫描道斜坡终止长度（毫秒）
    private Short sweepTraceTaperLengthAtEnd;
    // 139-140：斜坡类型
    private Short taperType;
    // 141-142：假频滤波频率（赫兹）
    private Short aliasFilterFrequency;
    // 143-144：假频滤波坡度（分贝/倍频程）
    private Short aliasFilterSlope;
    // 145-146：陷波频率（赫兹）
    private Short notchFilterFrequency;
    // 147-148：陷波坡度（分贝/倍频程）
    private Short notchFilterSlope;
    // 149-150：低截频率（赫兹）
    private Short lowCutFrequency;
    // 151-152：高截频率（赫兹）
    private Short highCutFrequency;
    // 153-154：低截坡度（分贝/倍频程）
    private Short lowCutSlope;
    // 155-156：高截坡度（分贝/倍频程）
    private Short highCutSlope;
    // 157-158：数据记录的年
    private Short yearDataRecorded;
    // 159-160：日（以格林尼治标准时间和通用协调时间为基准的公元日）
    private Short dayOfYear;
    // 161-162：时（24小时制）
    private Short hourOfDay;
    // 163-164：分
    private Short minuteOfHour;
    // 165-166：秒
    private Short secondOfMinute;
    // 167-168：时间基准码
    private Short timeBasisCode;
    // 169-170：道加权因子
    private Short traceWeightingFactor;
    // 171-172：滚动开关位置1的检波器组号
    private Short RollSwitchPositionOne;
    // 173-174：野外原始记录中道号1的检波器组号
    private Short traceNumberOneWithinOriginal;
    // 175-176：野外原始记录中最后一道的检波器组号
    private Short lastTraceWithinOriginal;
    // 177-178：间隔大小（滚动时甩掉的总检波器组数）
    private Short gapSize;
    // 179-180：相对测线斜坡起始或终止点的移动
    private Short overTravelAssociated;
    // 181-184：该道的道集（CDP）位置X坐标（应用道头71-72字节的因子）
    private Integer xCoordinateOfEnsemble;
    // 185-188：该道的道集（CDP）位置Y坐标（应用道头71-72字节的因子）
    private Integer yCoordinateOfEnsemble;
    // 189-192：对于3-D叠后数据，本字段用来填纵向线号（In-line）
    private Integer inLineNumber;
    // 193-196：对于3-D叠后数据，本字段用来填横向线号（Cross-line）
    private Integer crossLineNumber;
    // 197-200：炮点编号 — 这可能仅适用于 2-D 叠后数据
    private Integer shotpointNumber;
    // 201-202：应用于道头中197-200字节中炮点号的因子，以得到实际数值
    private Short scalar3;
    // 203-204：道值测量单位
    private Short traceValueMeasurementUnit;
    // 205-210：转换常数
    private Long transductionConstant;
    // 211-212：转换单位
    private Short transductionUnits;
    // 213-214：设备/道标识
    private Short deviceTraceIdentifier;
    // 215-216：在道头95-114字节给出的作用于时间的因子，以得到真实的毫秒表示的时间值
    private Short scalar4;
    // 217-218：震源类型/方位――定义类型或能量源的方位
    private Short sourceTypeOrientation;
    // 219-224：相对震源方位的震源能量方向――正方位方向在道头217-218字节定义
    private Long sourceEnergyDirection;
    // 225-230：震源测量――描述产生道的震源效应
    private Long sourceMeasurement;
    // 231-232：震源测量单位――用于震源测量、道头225-230字节的单位
    private Short sourceMeasurementUnit;
    // 233-240：未赋值――为任选信息预留
    /**/

    private byte[] samplingData;

    public DataBody() {
    }

    public Integer getTraceSequenceNumberWithinLine() {
        return traceSequenceNumberWithinLine;
    }

    public Integer getTraceSequenceNumberWithinSEGY() {
        return traceSequenceNumberWithinSEGY;
    }

    public Integer getOriginalFieldRecordNumber() {
        return originalFieldRecordNumber;
    }

    public Integer getTraceNumberWithinTheOriginal() {
        return traceNumberWithinTheOriginal;
    }

    public Integer getEnergySourcePointNumber() {
        return energySourcePointNumber;
    }

    public Integer getEnsembleNumber() {
        return ensembleNumber;
    }

    public Integer getTraceNumberWithinTheEnsemble() {
        return traceNumberWithinTheEnsemble;
    }

    public Short getTraceIdentificationCode() {
        return traceIdentificationCode;
    }

    public Short getVerticallySummedTraces() {
        return verticallySummedTraces;
    }

    public Short getHorizontallyStackedTraces() {
        return horizontallyStackedTraces;
    }

    public Short getDataUse() {
        return dataUse;
    }

    public Integer getSourcePointToReceiverGroup() {
        return sourcePointToReceiverGroup;
    }

    public Integer getReceiverGroupElevation() {
        return receiverGroupElevation;
    }

    public Integer getSurfaceElevationAtSource() {
        return surfaceElevationAtSource;
    }

    public Integer getSourceDepthBelowSurface() {
        return sourceDepthBelowSurface;
    }

    public Integer getDatumElevationAtReceiverGroup() {
        return datumElevationAtReceiverGroup;
    }

    public Integer getDatumElevationAtSource() {
        return datumElevationAtSource;
    }

    public Integer getWaterDepthAtSource() {
        return waterDepthAtSource;
    }

    public Integer getWaterDepthAtGroup() {
        return waterDepthAtGroup;
    }

    public Short getScalar1() {
        return scalar1;
    }

    public Short getScalar2() {
        return scalar2;
    }

    public Integer getSourceCoordinateX() {
        return sourceCoordinateX;
    }

    public Integer getSourceCoordinateY() {
        return sourceCoordinateY;
    }

    public Integer getGroupCoordinateX() {
        return groupCoordinateX;
    }

    public Integer getGroupCoordinateY() {
        return groupCoordinateY;
    }

    public Short getCoordinateUnits() {
        return coordinateUnits;
    }

    public Short getWeatheringVelocity() {
        return weatheringVelocity;
    }

    public Short getSubweatheringVelocity() {
        return subweatheringVelocity;
    }

    public Short getUpholeTimeAtSourceInMilliseconds() {
        return upholeTimeAtSourceInMilliseconds;
    }

    public Short getUpholeTimeAtGroupInMilliseconds() {
        return upholeTimeAtGroupInMilliseconds;
    }

    public Short getSourceStaticCorrectionInMilliseconds() {
        return sourceStaticCorrectionInMilliseconds;
    }

    public Short getGroupStaticCorrectionInMilliseconds() {
        return groupStaticCorrectionInMilliseconds;
    }

    public Short getTotalStaticAppliedInMilliseconds() {
        return totalStaticAppliedInMilliseconds;
    }

    public Short getLagTimeA() {
        return lagTimeA;
    }

    public Short getLagTimeB() {
        return lagTimeB;
    }

    public Short getDelayRecordingTime() {
        return delayRecordingTime;
    }

    public Short getMuteTimeStart() {
        return muteTimeStart;
    }

    public Short getMuteTimeEnd() {
        return muteTimeEnd;
    }

    public Short getNumberOfSamplesInThisTrace() {
        return numberOfSamplesInThisTrace;
    }

    public Short getSampleIntervalInMicroseconds() {
        return sampleIntervalInMicroseconds;
    }

    public Short getGainTypeOfFieldInstruments() {
        return gainTypeOfFieldInstruments;
    }

    public Short getInstrumentGainConstant() {
        return instrumentGainConstant;
    }

    public Short getInstrumentEarlyOrInitialGain() {
        return instrumentEarlyOrInitialGain;
    }

    public Short getCorrelated() {
        return correlated;
    }

    public Short getSweepFrequencyAtStart() {
        return sweepFrequencyAtStart;
    }

    public Short getSweepFrequencyAtEnd() {
        return sweepFrequencyAtEnd;
    }

    public Short getSweepLengthInMilliseconds() {
        return sweepLengthInMilliseconds;
    }

    public Short getSweepType() {
        return sweepType;
    }

    public Short getSweepTraceTaperLengthAtStart() {
        return sweepTraceTaperLengthAtStart;
    }

    public Short getSweepTraceTaperLengthAtEnd() {
        return sweepTraceTaperLengthAtEnd;
    }

    public Short getTaperType() {
        return taperType;
    }

    public Short getAliasFilterFrequency() {
        return aliasFilterFrequency;
    }

    public Short getAliasFilterSlope() {
        return aliasFilterSlope;
    }

    public Short getNotchFilterFrequency() {
        return notchFilterFrequency;
    }

    public Short getNotchFilterSlope() {
        return notchFilterSlope;
    }

    public Short getLowCutFrequency() {
        return lowCutFrequency;
    }

    public Short getHighCutFrequency() {
        return highCutFrequency;
    }

    public Short getLowCutSlope() {
        return lowCutSlope;
    }

    public Short getHighCutSlope() {
        return highCutSlope;
    }

    public Short getYearDataRecorded() {
        return yearDataRecorded;
    }

    public Short getDayOfYear() {
        return dayOfYear;
    }

    public Short getHourOfDay() {
        return hourOfDay;
    }

    public Short getMinuteOfHour() {
        return minuteOfHour;
    }

    public Short getSecondOfMinute() {
        return secondOfMinute;
    }

    public Short getTimeBasisCode() {
        return timeBasisCode;
    }

    public Short getTraceWeightingFactor() {
        return traceWeightingFactor;
    }

    public Short getRollSwitchPositionOne() {
        return RollSwitchPositionOne;
    }

    public Short getTraceNumberOneWithinOriginal() {
        return traceNumberOneWithinOriginal;
    }

    public Short getLastTraceWithinOriginal() {
        return lastTraceWithinOriginal;
    }

    public Short getGapSize() {
        return gapSize;
    }

    public Short getOverTravelAssociated() {
        return overTravelAssociated;
    }

    public Integer getxCoordinateOfEnsemble() {
        return xCoordinateOfEnsemble;
    }

    public Integer getyCoordinateOfEnsemble() {
        return yCoordinateOfEnsemble;
    }

    public Integer getInLineNumber() {
        return inLineNumber;
    }

    public Integer getCrossLineNumber() {
        return crossLineNumber;
    }

    public Integer getShotpointNumber() {
        return shotpointNumber;
    }

    public Short getScalar3() {
        return scalar3;
    }

    public Short getTraceValueMeasurementUnit() {
        return traceValueMeasurementUnit;
    }

    public Long getTransductionConstant() {
        return transductionConstant;
    }

    public Short getTransductionUnits() {
        return transductionUnits;
    }

    public Short getDeviceTraceIdentifier() {
        return deviceTraceIdentifier;
    }

    public Short getScalar4() {
        return scalar4;
    }

    public Short getSourceTypeOrientation() {
        return sourceTypeOrientation;
    }

    public Long getSourceEnergyDirection() {
        return sourceEnergyDirection;
    }

    public Long getSourceMeasurement() {
        return sourceMeasurement;
    }

    public Short getSourceMeasurementUnit() {
        return sourceMeasurementUnit;
    }

    public byte[] getSamplingData() {
        return samplingData;
    }

    public void setTraceSequenceNumberWithinLine(Integer traceSequenceNumberWithinLine) {
        this.traceSequenceNumberWithinLine = traceSequenceNumberWithinLine;
    }

    public void setTraceSequenceNumberWithinSEGY(Integer traceSequenceNumberWithinSEGY) {
        this.traceSequenceNumberWithinSEGY = traceSequenceNumberWithinSEGY;
    }

    public void setOriginalFieldRecordNumber(Integer originalFieldRecordNumber) {
        this.originalFieldRecordNumber = originalFieldRecordNumber;
    }

    public void setTraceNumberWithinTheOriginal(Integer traceNumberWithinTheOriginal) {
        this.traceNumberWithinTheOriginal = traceNumberWithinTheOriginal;
    }

    public void setEnergySourcePointNumber(Integer energySourcePointNumber) {
        this.energySourcePointNumber = energySourcePointNumber;
    }

    public void setEnsembleNumber(Integer ensembleNumber) {
        this.ensembleNumber = ensembleNumber;
    }

    public void setTraceNumberWithinTheEnsemble(Integer traceNumberWithinTheEnsemble) {
        this.traceNumberWithinTheEnsemble = traceNumberWithinTheEnsemble;
    }

    public void setTraceIdentificationCode(Short traceIdentificationCode) {
        this.traceIdentificationCode = traceIdentificationCode;
    }

    public void setVerticallySummedTraces(Short verticallySummedTraces) {
        this.verticallySummedTraces = verticallySummedTraces;
    }

    public void setHorizontallyStackedTraces(Short horizontallyStackedTraces) {
        this.horizontallyStackedTraces = horizontallyStackedTraces;
    }

    public void setDataUse(Short dataUse) {
        this.dataUse = dataUse;
    }

    public void setSourcePointToReceiverGroup(Integer sourcePointToReceiverGroup) {
        this.sourcePointToReceiverGroup = sourcePointToReceiverGroup;
    }

    public void setReceiverGroupElevation(Integer receiverGroupElevation) {
        this.receiverGroupElevation = receiverGroupElevation;
    }

    public void setSurfaceElevationAtSource(Integer surfaceElevationAtSource) {
        this.surfaceElevationAtSource = surfaceElevationAtSource;
    }

    public void setSourceDepthBelowSurface(Integer sourceDepthBelowSurface) {
        this.sourceDepthBelowSurface = sourceDepthBelowSurface;
    }

    public void setDatumElevationAtReceiverGroup(Integer datumElevationAtReceiverGroup) {
        this.datumElevationAtReceiverGroup = datumElevationAtReceiverGroup;
    }

    public void setDatumElevationAtSource(Integer datumElevationAtSource) {
        this.datumElevationAtSource = datumElevationAtSource;
    }

    public void setWaterDepthAtSource(Integer waterDepthAtSource) {
        this.waterDepthAtSource = waterDepthAtSource;
    }

    public void setWaterDepthAtGroup(Integer waterDepthAtGroup) {
        this.waterDepthAtGroup = waterDepthAtGroup;
    }

    public void setScalar1(Short scalar1) {
        this.scalar1 = scalar1;
    }

    public void setScalar2(Short scalar2) {
        this.scalar2 = scalar2;
    }

    public void setSourceCoordinateX(Integer sourceCoordinateX) {
        this.sourceCoordinateX = sourceCoordinateX;
    }

    public void setSourceCoordinateY(Integer sourceCoordinateY) {
        this.sourceCoordinateY = sourceCoordinateY;
    }

    public void setGroupCoordinateX(Integer groupCoordinateX) {
        this.groupCoordinateX = groupCoordinateX;
    }

    public void setGroupCoordinateY(Integer groupCoordinateY) {
        this.groupCoordinateY = groupCoordinateY;
    }

    public void setCoordinateUnits(Short coordinateUnits) {
        this.coordinateUnits = coordinateUnits;
    }

    public void setWeatheringVelocity(Short weatheringVelocity) {
        this.weatheringVelocity = weatheringVelocity;
    }

    public void setSubweatheringVelocity(Short subweatheringVelocity) {
        this.subweatheringVelocity = subweatheringVelocity;
    }

    public void setUpholeTimeAtSourceInMilliseconds(Short upholeTimeAtSourceInMilliseconds) {
        this.upholeTimeAtSourceInMilliseconds = upholeTimeAtSourceInMilliseconds;
    }

    public void setUpholeTimeAtGroupInMilliseconds(Short upholeTimeAtGroupInMilliseconds) {
        this.upholeTimeAtGroupInMilliseconds = upholeTimeAtGroupInMilliseconds;
    }

    public void setSourceStaticCorrectionInMilliseconds(Short sourceStaticCorrectionInMilliseconds) {
        this.sourceStaticCorrectionInMilliseconds = sourceStaticCorrectionInMilliseconds;
    }

    public void setGroupStaticCorrectionInMilliseconds(Short groupStaticCorrectionInMilliseconds) {
        this.groupStaticCorrectionInMilliseconds = groupStaticCorrectionInMilliseconds;
    }

    public void setTotalStaticAppliedInMilliseconds(Short totalStaticAppliedInMilliseconds) {
        this.totalStaticAppliedInMilliseconds = totalStaticAppliedInMilliseconds;
    }

    public void setLagTimeA(Short lagTimeA) {
        this.lagTimeA = lagTimeA;
    }

    public void setLagTimeB(Short lagTimeB) {
        this.lagTimeB = lagTimeB;
    }

    public void setDelayRecordingTime(Short delayRecordingTime) {
        this.delayRecordingTime = delayRecordingTime;
    }

    public void setMuteTimeStart(Short muteTimeStart) {
        this.muteTimeStart = muteTimeStart;
    }

    public void setMuteTimeEnd(Short muteTimeEnd) {
        this.muteTimeEnd = muteTimeEnd;
    }

    public void setNumberOfSamplesInThisTrace(Short numberOfSamplesInThisTrace) {
        this.numberOfSamplesInThisTrace = numberOfSamplesInThisTrace;
    }

    public void setSampleIntervalInMicroseconds(Short sampleIntervalInMicroseconds) {
        this.sampleIntervalInMicroseconds = sampleIntervalInMicroseconds;
    }

    public void setGainTypeOfFieldInstruments(Short gainTypeOfFieldInstruments) {
        this.gainTypeOfFieldInstruments = gainTypeOfFieldInstruments;
    }

    public void setInstrumentGainConstant(Short instrumentGainConstant) {
        this.instrumentGainConstant = instrumentGainConstant;
    }

    public void setInstrumentEarlyOrInitialGain(Short instrumentEarlyOrInitialGain) {
        this.instrumentEarlyOrInitialGain = instrumentEarlyOrInitialGain;
    }

    public void setCorrelated(Short correlated) {
        this.correlated = correlated;
    }

    public void setSweepFrequencyAtStart(Short sweepFrequencyAtStart) {
        this.sweepFrequencyAtStart = sweepFrequencyAtStart;
    }

    public void setSweepFrequencyAtEnd(Short sweepFrequencyAtEnd) {
        this.sweepFrequencyAtEnd = sweepFrequencyAtEnd;
    }

    public void setSweepLengthInMilliseconds(Short sweepLengthInMilliseconds) {
        this.sweepLengthInMilliseconds = sweepLengthInMilliseconds;
    }

    public void setSweepType(Short sweepType) {
        this.sweepType = sweepType;
    }

    public void setSweepTraceTaperLengthAtStart(Short sweepTraceTaperLengthAtStart) {
        this.sweepTraceTaperLengthAtStart = sweepTraceTaperLengthAtStart;
    }

    public void setSweepTraceTaperLengthAtEnd(Short sweepTraceTaperLengthAtEnd) {
        this.sweepTraceTaperLengthAtEnd = sweepTraceTaperLengthAtEnd;
    }

    public void setTaperType(Short taperType) {
        this.taperType = taperType;
    }

    public void setAliasFilterFrequency(Short aliasFilterFrequency) {
        this.aliasFilterFrequency = aliasFilterFrequency;
    }

    public void setAliasFilterSlope(Short aliasFilterSlope) {
        this.aliasFilterSlope = aliasFilterSlope;
    }

    public void setNotchFilterFrequency(Short notchFilterFrequency) {
        this.notchFilterFrequency = notchFilterFrequency;
    }

    public void setNotchFilterSlope(Short notchFilterSlope) {
        this.notchFilterSlope = notchFilterSlope;
    }

    public void setLowCutFrequency(Short lowCutFrequency) {
        this.lowCutFrequency = lowCutFrequency;
    }

    public void setHighCutFrequency(Short highCutFrequency) {
        this.highCutFrequency = highCutFrequency;
    }

    public void setLowCutSlope(Short lowCutSlope) {
        this.lowCutSlope = lowCutSlope;
    }

    public void setHighCutSlope(Short highCutSlope) {
        this.highCutSlope = highCutSlope;
    }

    public void setYearDataRecorded(Short yearDataRecorded) {
        this.yearDataRecorded = yearDataRecorded;
    }

    public void setDayOfYear(Short dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public void setHourOfDay(Short hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public void setMinuteOfHour(Short minuteOfHour) {
        this.minuteOfHour = minuteOfHour;
    }

    public void setSecondOfMinute(Short secondOfMinute) {
        this.secondOfMinute = secondOfMinute;
    }

    public void setTimeBasisCode(Short timeBasisCode) {
        this.timeBasisCode = timeBasisCode;
    }

    public void setTraceWeightingFactor(Short traceWeightingFactor) {
        this.traceWeightingFactor = traceWeightingFactor;
    }

    public void setRollSwitchPositionOne(Short rollSwitchPositionOne) {
        RollSwitchPositionOne = rollSwitchPositionOne;
    }

    public void setTraceNumberOneWithinOriginal(Short traceNumberOneWithinOriginal) {
        this.traceNumberOneWithinOriginal = traceNumberOneWithinOriginal;
    }

    public void setLastTraceWithinOriginal(Short lastTraceWithinOriginal) {
        this.lastTraceWithinOriginal = lastTraceWithinOriginal;
    }

    public void setGapSize(Short gapSize) {
        this.gapSize = gapSize;
    }

    public void setOverTravelAssociated(Short overTravelAssociated) {
        this.overTravelAssociated = overTravelAssociated;
    }

    public void setxCoordinateOfEnsemble(Integer xCoordinateOfEnsemble) {
        this.xCoordinateOfEnsemble = xCoordinateOfEnsemble;
    }

    public void setyCoordinateOfEnsemble(Integer yCoordinateOfEnsemble) {
        this.yCoordinateOfEnsemble = yCoordinateOfEnsemble;
    }

    public void setInLineNumber(Integer inLineNumber) {
        this.inLineNumber = inLineNumber;
    }

    public void setCrossLineNumber(Integer crossLineNumber) {
        this.crossLineNumber = crossLineNumber;
    }

    public void setShotpointNumber(Integer shotpointNumber) {
        this.shotpointNumber = shotpointNumber;
    }

    public void setScalar3(Short scalar3) {
        this.scalar3 = scalar3;
    }

    public void setTraceValueMeasurementUnit(Short traceValueMeasurementUnit) {
        this.traceValueMeasurementUnit = traceValueMeasurementUnit;
    }

    public void setTransductionConstant(Long transductionConstant) {
        this.transductionConstant = transductionConstant;
    }

    public void setTransductionUnits(Short transductionUnits) {
        this.transductionUnits = transductionUnits;
    }

    public void setDeviceTraceIdentifier(Short deviceTraceIdentifier) {
        this.deviceTraceIdentifier = deviceTraceIdentifier;
    }

    public void setScalar4(Short scalar4) {
        this.scalar4 = scalar4;
    }

    public void setSourceTypeOrientation(Short sourceTypeOrientation) {
        this.sourceTypeOrientation = sourceTypeOrientation;
    }

    public void setSourceEnergyDirection(Long sourceEnergyDirection) {
        this.sourceEnergyDirection = sourceEnergyDirection;
    }

    public void setSourceMeasurement(Long sourceMeasurement) {
        this.sourceMeasurement = sourceMeasurement;
    }

    public void setSourceMeasurementUnit(Short sourceMeasurementUnit) {
        this.sourceMeasurementUnit = sourceMeasurementUnit;
    }

    public void setSamplingData(byte[] samplingData) {
        this.samplingData = samplingData;
    }

    @Override
    public String toString() {
        return "\n###数据体第一部分###" +
                "\n测线中道顺序号=" + traceSequenceNumberWithinLine +
                "\nSEG Y文件中道顺序号=" + traceSequenceNumberWithinSEGY +
                "\n野外原始记录号=" + originalFieldRecordNumber +
                "\n野外原始记录的道号=" + traceNumberWithinTheOriginal +
                "\n震源点号=" + energySourcePointNumber +
                "\n道集号=" + ensembleNumber +
                "\n道集的道数=" + traceNumberWithinTheEnsemble +
                "\n道识别码=" + traceIdentificationCode +
                "\n产生该道的垂直叠加道数=" + verticallySummedTraces +
                "\n产生该道的水平叠加道数=" + horizontallyStackedTraces +
                "\n数据用途=" + dataUse +
                "\n从震源中心点到检波器组中心的距离=" + sourcePointToReceiverGroup +
                "\n检波器组高程=" + receiverGroupElevation +
                "\n震源地表高程=" + surfaceElevationAtSource +
                "\n震源距地表深度（正数）=" + sourceDepthBelowSurface +
                "\n检波器组基准高程=" + datumElevationAtReceiverGroup +
                "\n震源基准高程=" + datumElevationAtSource +
                "\n震源水深=" + waterDepthAtSource +
                "\n检波器组水深=" + waterDepthAtGroup +
                "\n应用于所有在道头41-68字节给定的真实高程和深度的因子=" + scalar1 +
                "\n应用于所有在道头73-88字节和181-188字节给定的真实坐标值的因子=" + scalar2 +
                "\n震源坐标――X=" + sourceCoordinateX +
                "\n震源坐标――Y=" + sourceCoordinateY +
                "\n检波器组坐标――X=" + groupCoordinateX +
                "\n检波器组坐标――Y=" + groupCoordinateY +
                "\n坐标单位=" + coordinateUnits +
                "\n风化层速度=" + weatheringVelocity +
                "\n风化层下速度=" + subweatheringVelocity +
                "\n震源处井口时间（毫秒）=" + upholeTimeAtSourceInMilliseconds +
                "\n检波器组处井口时间（毫秒）=" + upholeTimeAtGroupInMilliseconds +
                "\n震源的静校正量（毫秒）=" + sourceStaticCorrectionInMilliseconds +
                "\n检波器组的校正量（毫秒）=" + groupStaticCorrectionInMilliseconds +
                "\n应用的总静校正量（毫秒）（如没有应用静校正量为零）=" + totalStaticAppliedInMilliseconds +
                "\n延迟时间A=" + lagTimeA +
                "\n延迟时间B=" + lagTimeB +
                "\n记录延迟时间=" + delayRecordingTime +
                "\n起始切除时间（毫秒）=" + muteTimeStart +
                "\n终止切除时间（毫秒）=" + muteTimeEnd +
                "\n该道采样点数=" + numberOfSamplesInThisTrace +
                "\n该道采样间隔（微秒）=" + sampleIntervalInMicroseconds +
                "\n野外仪器增益类型=" + gainTypeOfFieldInstruments +
                "\n仪器增益常数（分贝）=" + instrumentGainConstant +
                "\n仪器初始增益（分贝）=" + instrumentEarlyOrInitialGain +
                "\n相关=" + correlated +
                "\n起始扫描频率（赫兹）=" + sweepFrequencyAtStart +
                "\n终止扫描频率（赫兹）=" + sweepFrequencyAtEnd +
                "\n扫描长度（毫秒）=" + sweepLengthInMilliseconds +
                "\n扫描类型=" + sweepType +
                "\n扫描道斜坡起始长度（毫秒）=" + sweepTraceTaperLengthAtStart +
                "\n扫描道斜坡终止长度（毫秒）=" + sweepTraceTaperLengthAtEnd +
                "\n斜坡类型=" + taperType +
                "\n假频滤波频率（赫兹）=" + aliasFilterFrequency +
                "\n假频滤波坡度（分贝/倍频程）=" + aliasFilterSlope +
                "\n陷波频率（赫兹）=" + notchFilterFrequency +
                "\n陷波坡度（分贝/倍频程）=" + notchFilterSlope +
                "\n低截频率（赫兹）=" + lowCutFrequency +
                "\n高截频率（赫兹）=" + highCutFrequency +
                "\n低截坡度（分贝/倍频程）=" + lowCutSlope +
                "\n高截坡度（分贝/倍频程）=" + highCutSlope +
                "\n数据记录的年=" + yearDataRecorded +
                "\n日（以格林尼治标准时间和通用协调时间为基准的公元日）=" + dayOfYear +
                "\n时（24小时制）=" + hourOfDay +
                "\n分=" + minuteOfHour +
                "\n秒=" + secondOfMinute +
                "\n时间基准码=" + timeBasisCode +
                "\n道加权因子=" + traceWeightingFactor +
                "\n滚动开关位置1的检波器组号=" + RollSwitchPositionOne +
                "\n野外原始记录中道号1的检波器组号=" + traceNumberOneWithinOriginal +
                "\n野外原始记录中最后一道的检波器组号=" + lastTraceWithinOriginal +
                "\n间隔大小（滚动时甩掉的总检波器组数）=" + gapSize +
                "\n相对测线斜坡起始或终止点的移动=" + overTravelAssociated +
                "\n该道的道集（CDP）位置X坐标（应用道头71-72字节的因子）=" + xCoordinateOfEnsemble +
                "\n该道的道集（CDP）位置Y坐标（应用道头71-72字节的因子）=" + yCoordinateOfEnsemble +
                "\n对于3-D叠后数据，本字段用来填纵向线号（In-line）=" + inLineNumber +
                "\n对于3-D叠后数据，本字段用来填横向线号（Cross-line）=" + crossLineNumber +
                "\n炮点编号 — 这可能仅适用于 2-D 叠后数据=" + shotpointNumber +
                "\n应用于道头中197-200字节中炮点号的因子=" + scalar3 +
                "\n道值测量单位=" + traceValueMeasurementUnit +
                "\n转换常数=" + transductionConstant +
                "\n转换单位=" + transductionUnits +
                "\n设备/道标识=" + deviceTraceIdentifier +
                "\n在道头95-114字节给出的作用于时间的因子=" + scalar4 +
                "\n震源类型/方位――定义类型或能量源的方位=" + sourceTypeOrientation +
                "\n相对震源方位的震源能量方向=" + sourceEnergyDirection +
                "\n震源测量=" + sourceMeasurement +
                "\n震源测量单位=" + sourceMeasurementUnit +
                "\n\n###数据体第二部分###\n" + Arrays.toString(samplingData);
    }
}
