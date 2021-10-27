package JavaBook.chap10;

import java.io.FileWriter;
import java.io.IOException;

//使用FileReader类读取文件
public class App10_5 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\96361\\Desktop\\programming-language-learning2\\Java--HITymr\\src\\JavaBook\\chap10\\love2.txt");
        char[] c = {'H', 'H', 'H', 'H', 'H', 'H'};
        String str = "Welcome to using java";
        fw.write(c);
        fw.write(str);
        fw.close();

    }
}
