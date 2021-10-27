package chap04;

public class PassByValueOrReference {
    public static void main(String[] args) {
        int a = 1;
        Int b = new Int();
        add(a);
        add(b);
        System.out.println("a:" + a);
        System.out.println("b.c:" + b.c);
    }

    static void add(Int b) {
        b.c++;
        System.out.println("方法内 b.c:" + b.c);
    }

    static void add(int a) {
        a++;
        System.out.println("方法内 a:" + a);
    }

}

class Int {
    int c = 1;
}
