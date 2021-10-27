package test;

public class test3 {
    public static void main(String[] args) {
        System.out.println("浮点型：");
        double a1, b1, c1;
        a1 = 5 / 6;
        System.out.println(a1 + "");
        b1 = 5.0 / 6.0;
        System.out.println(b1 + "");
        c1 = 5 / 6.0;
        System.out.println(c1 + "");

        System.out.println("整数型：");
        // int a1, b1, c1;
        a1 = (int) 5 / 6;
        System.out.println(a1 + "");
        b1 = (int) (5.0 / 6.0);
        System.out.println(b1 + "");
        c1 = (int) (5 / 6.0);
        System.out.println(c1 + "");
        String a = "123";
        String b = a;
        b = "234";
        System.out.println(a);
        System.out.println(b);
    }
}
