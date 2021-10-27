package test;

import java.util.*;

public class CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[25];
        int[] j = new int[25];
        System.out.println("================");
        Arrays.fill(i, 47);
        System.out.println("i:" + Arrays.toString(i));
        Arrays.fill(j, 99);
        System.out.println("j:" + Arrays.toString(j));
        System.out.println("================");
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("================");
        System.out.println("i:" + Arrays.toString(i));
        System.out.println("j:" + Arrays.toString(j));
        System.out.println("================");

        int[] k = new int[10];
        Arrays.fill(k, 103);
        System.out.println("================");
        System.out.println("i:" + Arrays.toString(i));
        System.out.println("j:" + Arrays.toString(j));
        System.out.println("k:" + Arrays.toString(k));
        System.out.println("================");

        System.arraycopy(i, 0, k, 0, k.length);
        System.out.println("================");
        System.out.println("i:" + Arrays.toString(i));
        System.out.println("j:" + Arrays.toString(j));
        System.out.println("k:" + Arrays.toString(k));
        System.out.println("================");

        Arrays.fill(k, 103);
        System.out.println("================");
        System.out.println("k:" + Arrays.toString(k));
        System.out.println("================");

        System.arraycopy(k, 0, i, 0, k.length);
        System.out.println("================");
        System.out.println("i:" + Arrays.toString(i));
        System.out.println("j:" + Arrays.toString(j));
        System.out.println("k:" + Arrays.toString(k));
        System.out.println("================");
    }
}
