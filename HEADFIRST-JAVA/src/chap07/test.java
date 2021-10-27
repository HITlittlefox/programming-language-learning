package chap07;


public class test {
    public static void main(String[] args) {

        Father test = new Son();//Father 类型 Son实例化
        test.m1();// Son's m1 这个Father 类型 Son实例化使用方法重写的子类方法

        //test.m3();// 这个Father 类型 Son实例化 “不能” 使用子类方法。

    }

}

class Father {
    int ivar = 7;

    void m1() {
        System.out.println("Father's m1, ");
    }

}

class Son extends Father {
    void m1() {
        System.out.println("Son's m1, ");
    }

    void m3() {
        System.out.println("Son's m3, ");
    }
}