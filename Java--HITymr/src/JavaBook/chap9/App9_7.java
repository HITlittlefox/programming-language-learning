package JavaBook.chap9;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class App9_7 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Paths.get("C:\\Users\\96361\\Desktop\\programming-language-learning2\\Java--HITymr\\src\\JavaBook\\chap9\\t.txt"));
        while (in.hasNext()) {
            System.out.println(in.nextLine());
        }
    }
}
