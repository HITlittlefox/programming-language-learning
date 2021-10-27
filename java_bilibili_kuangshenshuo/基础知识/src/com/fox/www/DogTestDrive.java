package com.fox.www;

class Dog2 {
    int size;
    String name;

    void bark(int numOfBarks) {
        while (numOfBarks > 0) {
            System.out.println("ruff!");
            numOfBarks = numOfBarks - 1;
        }
        // if (size > 60) {
        // System.out.println("woof!woof!");
        //
        // } else if (size > 14) {
        // System.out.println("ruff!ruff!");
        //
        // } else {
        // System.out.println("yip!yip!");
        // }
    }
}

public class DogTestDrive {
    public static void main(String[] args) {
        Dog2 one = new Dog2();
        one.size = 70;
        Dog2 two = new Dog2();
        two.size = 8;
        Dog2 three = new Dog2();
        three.size = 35;
        one.bark(3);
        two.bark(3);
        three.bark(3);
    }
}
