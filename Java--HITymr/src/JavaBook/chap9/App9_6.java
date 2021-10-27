package JavaBook.chap9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class App9_6 {
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader buf = new BufferedReader(new InputStreamReader((System.in)));
        while (true) {
            try {
                System.out.println("plz input something: ");
                str = buf.readLine();
                if (str.length() > 0) {
                    break;
                } else {
                    throw new IOException();
                }

            } catch (IOException e) {
                System.out.println("u must input something!");
                continue;
            }

        }
        String s = str.toUpperCase(Locale.ROOT);
        System.out.println("strings after convert: " + s);
    }
}
