package JavaBook.chap10;
//package lesson6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//使用BufferedWriter把信息写入文件

class Ex10_4 {
    public static void main(String[] args) throws IOException {
        //String fileName = "E:\\javaexamples\\lesson6\\Hello3.txt";
        String fileName = "Hello3.txt";
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));

        out.write("Hello!");
        out.newLine();
        out.write("This is another text file using BufferedWriter,");
        out.newLine();
        out.write("So I can use a common way to start a newline");
        out.newLine();
        out.close();
    }
}
