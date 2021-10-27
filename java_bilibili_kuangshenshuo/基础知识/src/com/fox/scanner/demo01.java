package com.fox.scanner;


import com.fox.www.Dog;

import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
        Dog dog2 = new Dog();
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用next方式接收");
        if (scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println("输出的内容为："+str);
        }
        scanner.close();
    }
}
