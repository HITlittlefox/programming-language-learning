package test;

class A {
    public void printA() {
        System.out.println("A --> public void print(){}");
    }

    public void fun() {
        printA();
    }
}

class B extends A {
    public void printB() {
        System.out.println("B --> public void print(){}");
    }

    public void print() {// 子类B新增一个方法
        System.out.println("Hello B");
    }
}

public class polymorphism {
    // 你可以理解为A有的方法B都有 A就可以指向B 但A只能调用A有的方法
    public static void main(String args[]) {
        // B a = new B(); // 子类对象变为父类对象
        // a.printA();
        // A a = new A(); // 子类对象变为父类对象
        // a.printB();
        //B a = new A(); // 子类对象变为父类对象
        //a.printB();
    }
}