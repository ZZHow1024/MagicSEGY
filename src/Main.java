import pojo.entity.SEGY;
import util.SEGYUtils;

import java.io.File;
import java.util.Scanner;

/**
 * @author ZZHow
 * @date 2024/11/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SEGY segy = new SEGY();
        // String filePath = args[0];
        String filePath = "";


        // 程序主界面
        System.out.println("0. 指定文件全路径\t\t");
        System.out.println("1. 展示文件头");
        System.out.println("2. 展示数据体");
        System.out.println("3. 退出程序");

        String op = "-1";
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("尚未指定文件");
            op = "0";
        } else {
            try {
                segy = SEGYUtils.parseSEGY(filePath);
            } catch (UnsupportedOperationException e) {
                System.out.println("数据采样格式编码错误，请检查");
            }
        }

        while (true) {
            switch (op) {
                case "0" -> {
                    System.out.println("请输入文件全路径：");
                    filePath = scanner.next();
                    if (!new File(filePath).exists()) {
                        filePath = null;
                        System.out.println("文件不存在！");
                    } else {
                        try {
                            segy = SEGYUtils.parseSEGY(filePath);
                        } catch (UnsupportedOperationException e) {
                            System.out.println("数据采样格式编码错误，请检查");
                        }
                    }
                }
                case "1" -> {
                    System.out.println(segy.getFileHeader());
                }
                case "2" -> {
                    System.out.print("数据道数：");
                    long num = scanner.nextLong();
                    System.out.println(segy.getDataBodies().get(num));
                }
                case "3" -> {
                    System.out.println("程序退出...");
                    System.exit(0);
                }
                case "-1" -> {
                }
                default -> {
                    System.out.println("无效输入");
                }
            }
            op = scanner.next();
        }
    }
}