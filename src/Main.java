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
        String filePath = "";

        System.out.println("ZSEGY 1.0");
        System.out.println("Author: ZZHow");

        if (args.length != 0) {

            switch (args[0]) {
                case "-head", "head" -> {
                    System.out.println("正在解析中...");
                    System.out.println(SEGYUtils.parseFileHeader(args[1]));
                    System.exit(0);
                }
                case "-body", "body" -> {
                    long num = 1;
                    try {
                        num = Long.parseLong(args[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("格式错误，输入 -help 查看提示");
                        System.exit(0);;
                    }
                    segy = SEGYUtils.parseSEGY(args[2]);
                    System.out.println("\n@@@第 " + num + " 个数据道@@@");
                    System.out.println(segy.getDataBodies().get(num));
                    System.exit(0);
                }
                case "-all", "all" -> {
                    long num;
                    try {
                        num = Long.parseLong(args[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("输入格式错误，输入 -help 查看提示");
                        break;
                    }
                    segy = SEGYUtils.parseSEGY(args[2]);
                    System.out.println(segy.getFileHeader());
                    System.out.println("\n@@@第 " + num + " 个数据道@@@");
                    System.out.println(segy.getDataBodies().get(num));
                    System.exit(0);
                }
                case "-i", "i" -> {
                    filePath = args[1];
                }
                case "-help", "help" -> {
                    System.out.println("--- ZSEGY 1.0 使用说明 ---");
                    System.out.println("java -jar zsegy.jar [-command] <num> [filePath]");
                    System.out.println("[-command]: ");
                    System.out.println("-head [filePath]：解析并输出文件头");
                    System.out.println("-body <num> [filePath]：解析并输出数据体中的第 num 个数据道");
                    System.out.println("-all <num> [filePath]：解析并输出文件头和数据体中的第 num 个数据道");
                    System.out.println("-i [filePath]：解析并进入交互模式");
                    System.out.println();
                    System.out.println("-help：呼出本提示");
                    System.exit(0);
                }
            }
        }

        // 交互模式
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
            System.out.print("->");
            op = scanner.next();
            scanner.nextLine();
        }
    }
}