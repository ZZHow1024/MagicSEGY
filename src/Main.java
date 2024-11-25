import pojo.entity.FileHeader;
import util.SEGYUtils;

/**
 * @author ZZHow
 * @date 2024/11/25
 */
public class Main {
    public static void main(String[] args) {
        // String filePath = args[0];
        String filePath = "";

        FileHeader fileHeader = SEGYUtils.parseFileHeader(filePath);
        System.out.println(fileHeader);
    }
}