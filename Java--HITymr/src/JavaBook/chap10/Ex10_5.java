package JavaBook.chap10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//ʹ��BufferedReader��ȡ�ļ���Ϣ

class Ex10_5 {
    public static void main(String[] args) {
        String fileName = "Hello3.txt", line;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            line = in.readLine();   //��ȡһ������
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
            in.close();
        } catch (IOException iox) {
            System.out.println("Problem reading " + fileName);
        }
    }
}