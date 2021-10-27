package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class testSplit {
    public static void main(String[] args) {

        //原始字符串需要导入txt文件显示
        String fileName = "src/main/java/com/example/demo1/data.txt", line;
        StringBuilder input_string_raw = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            line = in.readLine();   //读取一行内容
            while (line != null) {
                System.out.println(line);
                input_string_raw.append(line);
                line = in.readLine();
            }
            System.out.println("您导入的data.txt文件中的字符串是:" + input_string_raw);
            in.close();
        } catch (IOException iox) {
            System.out.println("Problem reading " + fileName);
        }

        //把文章的所有标点替换为空格！然后再用空格分割！
        String input_string = input_string_raw.toString();
        String str = "[`\\\\~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%…&*（）——+|{}【】‘；：”“’。，、？\"\"]";

        String input_string_replaced = input_string.replaceAll(str, " ");
        System.out.println("被替换符号后是:" + input_string_replaced);

        //用空格分割！
//        //获得字符串
//        input_string = Arrays.toString(input_string_replaced.split("\\s+"));
//        System.out.println("被分割后的String形态是:" + input_string);
//        System.out.println("String形态长度是:" + input_string.length());

        //获得数组
        String[] input_string_array = input_string_replaced.split("\\s+");
        System.out.println("被分割后的数组形态是:" + Arrays.toString(input_string_array));
        System.out.println("数组形态长度是:" + input_string_array.length);

//        StringBuilder input_string_reverse = new StringBuilder();

//        //按单词倒序输出！
//        for (int i = input_string_array.length - 1; i >= 0; i--) {
//            System.out.println(input_string_array[i]);
//            input_string_reverse.append(input_string_array[i]).append(" ");
//
//        }
//
//        System.out.println(input_string_reverse);
//
//
//        //按单词统计
//        String aim = "love";
//        int count = 0;
//        for (String i : input_string_array) {
//            if (Objects.equals(i, aim)) {
//                count++;
//            }
//        }
//        System.out.println(count);

        //按单词替换！


        String[] input_string_array_click1 = input_string_array;
        String be_replaced = "love";
        String replaced = "123";

        for (int i = 0; i < input_string_array_click1.length; i++) {
            if (Objects.equals(input_string_array_click1[i], be_replaced)) {
                input_string_array_click1[i] = replaced;
            }
        }
//        for (String i : input_string_array) {
//            System.out.print(i + " ");
//
//        }
//        System.out.println();


        StringBuilder input_string_replaced2 = new StringBuilder("");
        //把替换后的数组按顺序输出！
        System.out.println("单词替换后数组形态长度是:" + input_string_array_click1.length);
        for (int i = 0; i < input_string_array_click1.length; i++) {
            input_string_replaced2.append(input_string_array_click1[i] + " ");
        }
        System.out.println("单词替换后的样子是：" + input_string_replaced2);

    }
}