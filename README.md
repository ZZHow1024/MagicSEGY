# [Java 项目]ZSEGY（中文说明）

---

Website:

[[Java 项目]ZSEGY | ZZHow](https://www.zzhow.com/ZSEGY)

Source Code:

https://github.com/ZZHow1024/ZSEGY

Releases:

https://github.com/ZZHow1024/ZSEGY/releases

---

## 它是什么？

ZSEGY 是一款跨平台的 SEG-Y 文件解析工具，支持命令模式和交互模式，可以解析并显示 SEG-Y 文件的文件头和数据体。

---

## 许可证

该项目根据 MIT 许可证获得许可 - 有关详细信息，请参阅 [LICENSE](https://github.com/ZZHow1024/ZSEGY/blob/main/LICENSE) 文件。

---

## 使用说明

下载地址：https://github.com/ZZHow1024/ZSEGY/releases

- 下载 .jar 文件
- 命令模式：
    - 通过 `java -jar zsegy.jar [-command] <num> [filePath]` 命令使用软件。
        - -head [filePath]：解析并输出文件头
        - -body <num> [filePath]：解析并输出数据体中的第 num 个数据道
        - -all <num> [filePath]：解析并输出文件头和数据体中的第 num 个数据道
        -i [filePath]：解析并进入交互模式
        - help：呼出本提示
- 交互模式：
    - 通过 `java -jar zsegy.jar` 命令使用软件。
        1. 指定文件全路径
        2. 展示文件头
        3. 展示数据体
        4. 退出程序

---

## 各版本功能介绍

- ZSEGY1.0.0
    - 解析 SEG-Y文件
    - 输出解析后的内容
    - 支持命令模式与交互模式

---

## 各版本主界面

![ZSEGY1.0.0](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2F77686c07-8ce0-4713-9982-c0fbb624147e%2FZSEGY1.0.0.png?table=block&id=14ae64bd-e40f-8010-b353-e36c9a36e3d9&t=14ae64bd-e40f-8010-b353-e36c9a36e3d9&width=434&cache=v2)

ZSEGY1.0.0