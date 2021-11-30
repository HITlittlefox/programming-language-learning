package test;

public class test3D {
    public static void main(String[] args) {
        B1 b = new B1();
        System.out.println(b.f(10.0, 8.0));
        System.out.println(b.g(3));
    }
}

class A1 {
    double f(double x, double y) {
        return x + y;
    }

    static int g(int n) {
        return n * n;
    }
}

class B1 extends A1 {
    double f(double x, double y) {
        double m = super.f(x, y);
        return m + x * y;
    }

    static int g(int n) {
        int m = A1.g(n);
        return m + n;
    }
}
