package JavaBook.chap9;
//���һ�����������Ԫ�أ����������±�Խ���쳣���͡�����Ϊ0�쳣����

import java.io.IOException;

public class App9_1 {
    public static void main(String[] args) throws IOException {
        int i;
        int[] a = {1, 2, 3, 4};
//        try {
            for (i = 0; i < 5; i++)
                System.out.println("a[" + i + "]=" + a[i]);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("finally!");
//        }
        System.out.println("5/0=" + 5 / 0);
        System.out.println("main() end!");
    }
}
