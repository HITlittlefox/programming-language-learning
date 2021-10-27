package HomeWork;
/*
产生15个20~9999的随机整数，
然后利用File、BufferedWriter/Reader等类将其写入文件file2.txt中，
然后再读取该文件中的数据
并将它们按升序排序。
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

public class inputAndOutput {
    public static void main(String[] args) throws IOException {
        //产生15个20~9999的随机整数
        int[] a = new int[15];
//        int len = 0;
        Random random = new Random();
        for (int i = 0; i <= a.length - 1; i++) {
            a[i] = random.nextInt(9999) + 20;//用数组保存产生的随机数
        }
        System.out.println("产生15个20~9999的随机整数：a：" + Arrays.toString(a));

        //写入文本文件
        String fileName = "123.txt";
//        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));

        OutputStreamWriter fWriter = new OutputStreamWriter(new FileOutputStream(fileName));
        BufferedWriter out = new BufferedWriter(fWriter);

        //逐行输入
        for (int len = 0; len < a.length; len++) {
//            System.out.println(String.valueOf(a[len]));
            out.write(String.valueOf(a[len]));
            out.newLine();
        }
        out.close();

        //读取文本文件
//        String fileName2 = "C:\\Users\\96361\\Desktop\\programming-language-learning2\\Java--HITymr\\123.txt", line;
        String line;
//        BufferedReader in = new BufferedReader(new FileReader(fileName));
        InputStreamReader fReader = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(fReader);
        line = in.readLine();   //读取一行内容
        int[] b = new int[15];
        int j = 0;
        while (line != null) {
//            System.out.println(line);
            b[j] = Integer.parseInt(line);//读出后进行数据类型转换并保存进数组
            j++;
            line = in.readLine();
        }
        in.close();
        System.out.println("读取整数：b：" + Arrays.toString(b));
        int[] c = b;
        Arrays.sort(c);//给数组排序
        //以数组形式展示升序排序后的状态
        System.out.println("升序排序：c：" + Arrays.toString(c));
        //挨个展示升序排序后的数字
//        System.out.println("升序排序后：");
//        for (int k = 0; k < b.length; k++) {
//            System.out.println(b[k]);//输出数组b的数据
//        }

    }
}