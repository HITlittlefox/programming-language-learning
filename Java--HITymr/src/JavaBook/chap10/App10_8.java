package JavaBook.chap10;

import java.io.*;

//使用BufferedWriter复制文本文件
public class App10_8 {
    public static void main(String[] args) throws IOException {
        String str;

        try (

                BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\96361\\Desktop\\programming-language-learning2\\Java--HITymr\\src\\JavaBook\\chap10\\love.txt"));
                BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\96361\\Desktop\\programming-language-learning2\\Java--HITymr\\src\\JavaBook\\chap10\\love2.txt"));


        ) {
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                out.write(str);
                out.newLine();
            }
            out.flush();
        } catch (IOException ioe) {
            System.out.println("error! " + ioe);
        }
    }
}
