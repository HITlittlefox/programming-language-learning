package com.fox.demo2;

public class demo2 {
    public static void main(String[] args) {
        System.out.println(f(5));
    }
    public static int f(int n){
        if (n==1){
            return 1;
        }else   {
            return n*f(n-1);
        }
    }
}
