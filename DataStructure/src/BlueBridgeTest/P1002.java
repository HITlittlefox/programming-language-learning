package BlueBridgeTest;

// �������� 1, 1, 1, 3, 5, 9, 17, \dots1,1,1,3,5,9,17,����
// �ӵ� 4 �ʼ��ÿ���ǰ 3 ��ĺ͡�
// �� �� 2019032420190324 ������ 4 λ���֡�


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
//        //��n��
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
//        if (n == 1 || n == 2)  //�ж�Ҫ���n�Ƕ��٣�nΪ1,2��ʱ����ֵΪ1��
//            return 1;
//        else            //��n���ڵ���3ʱ��ֵ
//        {
//            a = 1;
//            b = 1;
//            sum = 0;//��ʼ����һ��͵�2��Ϊ1����������sum��ŵ�3���ֵ
//        }
//        for (int i = 3; i <= n; i++) {
//            sum = a + b;  //ǰ�����ֵ���Ϊ�������ֵ
//            a = b;      //Ϊ����һ����׼������ԭ����2���ֵ����һ��
//            b = sum;    //��3���ֵ���ڶ����һѭ���Ϳ������4��Դ����ơ���
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
////        FBNQ(4);//����FBNQ�����ķ������n���ֵ
//        System.out.println("������");
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
