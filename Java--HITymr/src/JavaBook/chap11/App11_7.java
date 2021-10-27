package JavaBook.chap11;

//���һ��ģ���û�������ȡ���Ӧ�ó�����ĳ�����˻�����ĳ�ֵ��2000Ԫ�����߳�ģ�������û��ֱ������ȡ�������������û���4�ηֱ��һ�ҵ�ͬһ�˻�ȡ�ÿ��ȡ100Ԫ��

//���Ӧ��ʣ��2000-400-400=1200�������ȷ��
//��Ϊ�޶�take()Ϊͬ������������
class Mbank {
    private static int sum = 2000;

    //�޶�take()Ϊͬ������
    public synchronized static void take(int k) {
        int temp = sum;
        temp -= k;
        try {
            Thread.sleep((int) (1000 * Math.random()));
        } catch (InterruptedException ignored) {
        }
        sum = temp;
        System.out.println("sum= " + sum);
    }
}

class Customer extends Thread {
    public void run() {
        for (int i = 1; i <= 4; i++) {
            Mbank.take(100);
        }
    }
}


public class App11_7 {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        c1.start();
        c2.start();
    }
}
