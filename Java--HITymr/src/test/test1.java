package test;          //定义该程序属于ch01包

import java.io.*;      //导入java.io类库中的所有类

public class test1 {    //定义类：App1_1
    public static void main(String[] args) {
        char c = ' ';
        System.out.print("请输入一个字符：");
        try {
            c = (char) System.in.read();
        } catch (IOException s) {
            s.printStackTrace();
        }
        System.out.println("您输入的字符是：" + c);
    }
}
