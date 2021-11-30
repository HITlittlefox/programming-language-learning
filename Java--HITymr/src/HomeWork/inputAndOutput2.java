package HomeWork;
/*
产生15个20~9999的随机整数，
然后利用File、BufferedWriter/Reader等类将其写入文件file2.txt中，
然后再读取该文件中的数据
并将它们按升序排序。
 */

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class inputAndOutput2 {
    public static void main(String[] args) throws IOException {
        //产生15个20~9999的随机整数
        int[] a = new int[15];
//        int len = 0;
        Random random = new Random();
        for (int i = 0; i <= a.length - 1; i++) {
            a[i] = random.nextInt(9999) + 20;//用数组保存产生的随机数
        }
        System.out.println("产生15个20~9999的随机整数：" + Arrays.toString(a));

        //写入文本文件
        String fileName = "C:\\Users\\96361\\Desktop\\programming-language-learning\\Java--HITymr\\123.dat";
        DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));

        //逐行输入
        for (int i : a) {
            System.out.println(i);
            out.write(i);
//            out.newLine();
        }
        out.close();

        //读取文本文件
//        String fileName2 = "C:\\Users\\96361\\Desktop\\programming-language-learning2\\Java--HITymr\\123.txt", line;
        String line;
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));

        line = in.readLine();   //读取一行内容

        while (line != null) {
            System.out.println(line);
            line = in.readLine();
        }
        in.close();

    }
}
