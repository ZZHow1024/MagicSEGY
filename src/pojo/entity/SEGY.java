package pojo.entity;

import java.util.Map;

/**
 * @author ZZHow
 * @date 2024/11/25
 */
public class SEGY {
    // 文件头
    private FileHeader fileHeader;
    // 数据体
    private Map<Long, DataTrace> dataBody;

    public SEGY() {
    }

    public SEGY(FileHeader fileHeader, Map<Long, DataTrace> dataBody) {
        this.fileHeader = fileHeader;
        this.dataBody = dataBody;
    }

    public FileHeader getFileHeader() {
        return fileHeader;
    }

    public Map<Long, DataTrace> getDataBody() {
        return dataBody;
    }

    public void setFileHeader(FileHeader fileHeader) {
        this.fileHeader = fileHeader;
    }

    public void setDataBody(Map<Long, DataTrace> dataBody) {
        this.dataBody = dataBody;
    }
}
