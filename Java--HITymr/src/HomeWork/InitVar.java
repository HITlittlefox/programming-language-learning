public class InitVar {
    public static void main(String[] args) {
        byte a = 10;
        short b = 20;   //声明一个短整数型变量b，初始化为20
        int c = 30;     //声明一个整数型变量c，初始化为30
        long d = 40L;
        float e = 50F;  //声明一个单精度型变量e，初始化为50F
        double f = 60;  //声明一个双精度型变量f，初始化为60
        char g = 'A';   //声明一个字符型变量g，初始化为'A'
        boolean h = true;       //声明一个布尔型变量h，初始化为true
        final double PI = 3.14; //声明一个双精度型常量PI，值为3.14
        System.out.println("字节型，a = " + a);
        System.out.println("短整型，b = " + b);
        System.out.println("整数型，c = " + c);
        System.out.println("长整型，d = " + d);
        System.out.println("单精度型，e = " + e);
        System.out.println("双精度型，f = " + f);
        System.out.println("字符型，g = " + g);
        System.out.println("布尔型，h = " + h);
        System.out.println("圆周率，pi = " + PI);

    }
}
