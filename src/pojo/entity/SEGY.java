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
    private Map<Long, DataBody> dataBodies;

    public SEGY() {
    }

    public SEGY(FileHeader fileHeader, Map<Long, DataBody> dataBodies) {
        this.fileHeader = fileHeader;
        this.dataBodies = dataBodies;
    }

    public FileHeader getFileHeader() {
        return fileHeader;
    }

    public Map<Long, DataBody> getDataBodies() {
        return dataBodies;
    }

    public void setFileHeader(FileHeader fileHeader) {
        this.fileHeader = fileHeader;
    }

    public void setDataBodies(Map<Long, DataBody> dataBodies) {
        this.dataBodies = dataBodies;
    }
}
