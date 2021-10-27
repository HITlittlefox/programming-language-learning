package JavaBook.chap10;

import java.io.FileReader;
import java.io.IOException;

//使用FileReader类读取文件
public class App10_4 {
    public static void main(String[] args) throws IOException {
        char[] c = new char[500];
        try (FileReader fr = new FileReader("C:\\Users\\96361\\Desktop\\programming-language-learning2\\Java--HITymr\\src\\JavaBook\\chap10\\love.txt");
        ) {
            int num = fr.read(c);
            String str = new String(c, 0, num);
            System.out.println("read chars number is: " + num + ", and their content is: ");
            System.out.println(str);
        }
    }
}
