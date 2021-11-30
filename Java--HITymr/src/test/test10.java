package test;

public class test10 {
    public static int SingleTest(int n, int amount) {
        int j = 2;
        //3-->n-1
        for (; j < n; j++) {
            //只要有一个余数是0，他就不是素数
            if (n % j == 0) {
                break;
            }
        }
        //如果刚才循环没有break，j一直增长到了n，那么n就是素数
        if (n == j) {
            amount++;
        }
        return amount;
    }

    public static void main(String[] args) {

        int n = 100;
        int amount = 0;
        for (int i = 1; i < n; i++) {
            amount = SingleTest(i, amount);
        }
        System.out.println(n + "'s prime number amount is " + amount);

    }
}
