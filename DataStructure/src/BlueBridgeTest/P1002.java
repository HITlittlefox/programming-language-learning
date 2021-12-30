package BlueBridgeTest;

// 给定数列 1, 1, 1, 3, 5, 9, 17, \dots1,1,1,3,5,9,17,…，
// 从第 4 项开始，每项都是前 3 项的和。
// 求 第 2019032420190324 项的最后 4 位数字。


// f(n) = f(n-1)+f(n-2)+f(n-3)
// f(1)=f(2)=f(3)=1
//public class P1002 {
//    public static long fib(int n) {
//        if (n == 0 || n == 1 || n == 2) {
//            return n;
//        } else {
//            return (fib(n - 1) + fib(n - 2) + fib(n - 3));
//        }
//    }
//
//    public static void main(String[] args) {
//        //第n项
//        System.out.println(fib(100));
//    }
//}


//import java.math.BigInteger;
//
//public class P1002 {
//
//    public static BigInteger fibonacci(long n) {
//
//        if (n <= 1) return BigInteger.valueOf(n);
//
//        BigInteger previous = BigInteger.ZERO, next = BigInteger.ONE, sum;
//
//        for (int i = 2; i <= n; i++) {
//
//            sum = previous;
//            previous = next;
//            next = sum.add(previous);
//        }
//
//        return next;
//    }
//
//    public static void main(String[] args) {
//
////        for (int i = 0; i <= 99; i++) {
//
//            BigInteger val = fibonacci(2019032420190324L);
//            System.out.println(val);
////        }
//    }
//}

//public class P1002 {
//    public static int FBNQ(long n) {
//        int a = 1, b = 1, sum = 0;
//        if (n == 1 || n == 2)  //判断要求的n是多少，n为1,2项时它的值为1；
//            return 1;
//        else            //求n大于等于3时的值
//        {
//            a = 1;
//            b = 1;
//            sum = 0;//初始化第一项和第2项为1，声明变量sum存放第3项的值
//        }
//        for (int i = 3; i <= n; i++) {
//            sum = a + b;  //前两项的值相加为第三项的值
//            a = b;      //为求下一项做准备，把原来第2项的值给第一项
//            b = sum;    //第3项的值给第二项，下一循环就可以求第4项，以此类推。。
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
////        FBNQ(4);//调用FBNQ（）的方法求第n项的值
//        System.out.println("：：：");
//        System.out.println(FBNQ(2019032420190324L%10000));
//
//    }
//
//}

public class P1002 {


    public static void main(String[] args) {
        long[] num = new long[20190324];
        num[0] = 1;
        num[1] = 1;
        num[2] = 1;

        for (int i = 3; i < 20190324; i++) {
            num[i] = num[i - 1] + num[i - 2] + num[i - 3];
            num[i] = num[i] % 10000;
        }
        System.out.println(num[20190323]);

    }
}
