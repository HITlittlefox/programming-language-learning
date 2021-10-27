package chap07;

public class Mixed2 {


    public static void main(String[] args) {
        A a = new A();//A 类型 A 实例化
        B b = new B();//B 类型 B 实例化
        C c = new C();//C 类型 C 实例化
        A a2 = new C();//A 类型 C实例化
        a.m1();// A's m1
        //c.m1();// A's m1 ×， 继承的B，所以c.m1被override了
        a.m2();// A's m2
        b.m2();// A's m2
        c.m2();// A's m2
        c.m3();// C's m3
        a2.m3();// C's m3
        b.m1();// B's m1
        c.m1();// B's m1
        a.m3();// A's m3
        b.m3();// A's m3
    }

}

class A {
    int ivar = 7;

    void m1() {
        System.out.println("A's m1, ");
    }

    void m2() {
        System.out.println("A's m2, ");
    }

    void m3() {
        System.out.println("A's m3, ");
    }

}

class B extends A {
    void m1() {
        System.out.println("B's m1, ");
    }
}

class C extends B {
    void m3() {
        System.out.println("C's m3, " + (ivar + 6));
    }
}