package com.oop.www;

public class 构造函数 {
    int age = 20;

    public 构造函数() {
        age = 30;
    }

    public static void main(String[] args) {
        构造函数 function2 = new 构造函数();
        System.out.println(function2.age);
    }
}
