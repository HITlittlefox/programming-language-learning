package JavaBook.chap10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//使用BufferedReader读取文本文件
public class App10_7 {
    public static void main(String[] args) throws IOException {
        String thisLine;
        int count = 0;
        try (
                FileReader fr = new FileReader("C:\\Users\\96361\\Desktop\\programming-language-learning2\\Java--HITymr\\src\\JavaBook\\chap10\\love.txt");

                BufferedReader bfr = new BufferedReader(fr)) {
//            BufferedReader bfr = new BufferedReader(new FileReader(love.txt)))

            while ((thisLine = bfr.readLine()) != null) {
                count++;
                System.out.println(thisLine);
            }
            System.out.println("total read " + count + " line.");
        } catch (IOException ioe) {
            System.out.println("error!" + ioe);
        }
    }
}
