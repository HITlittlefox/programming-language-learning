package test;

public class test10 {
    public static int SingleTest(int n, int amount) {
        int j = 2;
        //3-->n-1
        for (; j < n; j++) {
            //ֻҪ��һ��������0�����Ͳ�������
            if (n % j == 0) {
                break;
            }
        }
        //����ղ�ѭ��û��break��jһֱ��������n����ôn��������
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
