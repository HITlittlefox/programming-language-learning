package com.fox.www;

public class Loopy {
    public static void main(String[] args) {
        int x = 1;
        System.out.println("Before the Loop");
        while (x < 100) {
            System.out.println("in the loop");
            System.out.println("Value of x is " + x);
            x = x + 1;
        }
        System.out.println("This is after the loop");
    }
}