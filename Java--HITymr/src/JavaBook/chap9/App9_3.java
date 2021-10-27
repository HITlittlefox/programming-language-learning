package JavaBook.chap9;

//使用throw语句在方法内抛出异常，并在同一方法内进行相应的异常处理
public class App9_3 {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            if (b == 0) {
                System.out.println("1");
                //抛出异常类所产生的对象，需要new一下(匿名对象  )
                throw new ArithmeticException();
            } else {
                System.out.println(a + "/" + b + "=" + a / b);
            }
        }//捕获异常
        catch (ArithmeticException e) {
            System.out.println("Exception: " + e + " is thrown!");
            e.printStackTrace();
        }
    }
}
