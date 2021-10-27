public class Conver {
    public static void main(String[] args) {
        byte a = 0;
        short b = 0;
        int c = 0;
        long d = 0;
        float e = 0F;
        double f = 0D;
        String s = "10";
        //字符串转换成数值型
        a = Byte.parseByte(s);
        b = Short.parseShort(s);
        c = Integer.parseInt(s);
        d = Long.parseLong(s);
        e = Float.parseFloat(s);
        f = Double.parseDouble(s);
        //数值型转换成字符串
        int MyInt = 1234;
        String MyString = "" + MyInt;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(MyString);


    }
}
