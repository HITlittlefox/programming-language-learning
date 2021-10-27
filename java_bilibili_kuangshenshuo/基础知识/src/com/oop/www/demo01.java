package com.oop.www;

//object
public class demo01 {
    //method
    public static void main(String[] args) {

    }
    /**
     * 修饰符 返回值类型 方法名(...){
     *     方法体
     *     return 返回值;
     * }
     */
    public String sayHello(){
        return "hello,world";
    }
    public void hello(){
        return;
    }

    public int max(int a , int b) {
        return a>b?a:b; //三元运算符
    }
}
