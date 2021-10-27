package com.fox.www;

public class Dog {
    String name;

    public static void main(String[] args) {
        // 创建Dog对象
        Dog dog1 = new Dog();
        dog1.bark();//null在吠叫！
        dog1.name = "Bart";
        // 创建Dog数组
        Dog[] myDogs = new Dog[3];
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        // 通过数组引用存取Dog
        myDogs[0].name = "Fred";
        myDogs[1].name = "Merge";

        // myDog[2]的名字是？是Bart哦~
        System.out.println("last dog's name is " + myDogs[2].name);

        // 挨个bark
        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x + 1;

        }

    }

    public void bark() {
        System.out.println(name + " says Ruff!");

    }
}
