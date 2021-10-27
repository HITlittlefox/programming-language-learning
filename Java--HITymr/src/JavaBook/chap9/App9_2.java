package JavaBook.chap9;
//使用try-catch-finally语句对程序中产生的异常进行捕获与处理

import java.io.IOException;

public class App9_2 {
    public static void main(String[] args) throws IOException {
        int i;
        int[] a = {1, 2, 3, 4};

        for (i = 0; i < 5; i++) {
            try {
                System.out.println("a[" + i + "]/" + i + "=" + (a[i] / i));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException");
            } catch (ArithmeticException e) {
                System.out.println("name" + e);
            } catch (Exception e) {
                System.out.println("catch " + e.getMessage() + " Exception!");
            } finally {
                System.out.println("  finally  i = " + i);
            }
        }
        System.out.println("GOON");

    }
}
