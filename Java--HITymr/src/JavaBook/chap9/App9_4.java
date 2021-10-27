package JavaBook.chap9;

//求命令行方式中输入的整数n的阶乘n!，并捕获可能出现的异常。
public class App9_4 {
    public static double multi(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Find negative factorial exception");
        }
        double s = 1;
        for (int i = 1; i < n; i++) {
            s = s * i;
        }
        return s;
    }

    public static void main(String[] args) {
        try {
            args = new String[]{"-5"};

            int m = Integer.parseInt(args[0]);
            System.out.println(m + "!=" + multi(m));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("without input!");
        } catch (NumberFormatException e) {
            System.out.println("need a Integer!");
        } catch (IllegalArgumentException e) {
            System.out.println("Find an Exception named:" + e.toString());
        } finally {
            System.out.println("end!");
        }
    }
}
