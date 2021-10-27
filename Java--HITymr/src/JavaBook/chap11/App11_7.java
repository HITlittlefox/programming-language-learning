package JavaBook.chap11;

//设计一个模拟用户从银行取款的应用程序。设某银行账户存款额的初值是2000元，用线程模拟两个用户分别从银行取款的情况。两个用户分4次分别从一囊的同一账户取款，每次取100元。

//最后应该剩下2000-400-400=1200，结果正确！
//因为限定take()为同步方法！！！
class Mbank {
    private static int sum = 2000;

    //限定take()为同步方法
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
