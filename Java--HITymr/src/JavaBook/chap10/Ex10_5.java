package JavaBook.chap10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//使用BufferedReader读取文件信息

class Ex10_5 {
    public static void main(String[] args) {
        String fileName = "Hello3.txt", line;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            line = in.readLine();   //读取一行内容
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
            in.close();
        } catch (IOException iox) {
            System.out.println("Problem reading " + fileName);
        }
    }
}