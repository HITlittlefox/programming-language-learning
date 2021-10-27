package JavaBook.chap10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//输出输入的内容
public class Ex10_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()).length() != 0)
            System.err.println(s);
        in.close();

    }

}