package chap10;

import java.util.Date;

public class NumberTest {
    public static void main(String[] args) {
        int one = 2000;
        double two = 2000.098;
        String s = String.format("the rank is %,d out of %,.2f", one, two);
        System.out.println(s);

        String t = String.format("%tc", new Date());
        String u = String.format("%tr", new Date());
        System.out.println(t);
        System.out.println(u);

        Date now = new Date();
        String v = String.format("%tA,%tB,%td,", now, now, now);
        String w = String.format("%tA,%<tB,%<td,", now);
        System.out.println(v);
        System.out.println(w);
    }

}



