
package JavaBook.chap11;

import java.util.Random;

//银行账户类
class Account {
    String name;
    double balance;

    //单参构造方法
    public Account(String name) {
        this.name = name;
        this.balance = 0;
    }

}

//存款线程
class SaveThread extends Thread {
    private Account account;
    private double value;

    //构造函数:传入一个account类
    public SaveThread(Account account) {
        this.account = account;
    }

    public void run() {
        //存五次
        for (int i = 0; i < 5; i++) {
            //同步account对象
            synchronized (account) {

                //产生5个500~1000的随机整数
                Random random = new Random();
                this.value = random.nextInt(1000) + 500;
                System.out.println("valueInPut:" + this.value);

                //存款
                if (value > 0) {
                    account.balance += value;
                }
                System.out.println("您的存款金额为" + value + " ; " + "存款成功,您的余额为" + account.balance);

            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException ignored) {
            }

        }
    }
//synchronized
    //synchronized
}

//取款线程
class FetchThread extends Thread {

    private Account account;

    //传入一个account类、一个double值
    public FetchThread(Account account) {
        this.account = account;
    }

    public void run() {

        for (int i = 0; i < 5; i++) {
            synchronized (account) {

                //产生5个500~1000的随机整数
                Random random = new Random();
                double value = random.nextInt(1000) + 500;
                System.out.println("valueOutPut:" + value);

                //取款
                //如果取钱金额<=存款金额,取出来，并把存款金额减去取钱金额
                if (account.balance > 0) {
                    //如果要取负数,取不到钱
                    if (value <= 0) {

                        System.out.println("您的取款金额是负数，无法取款负数的金额！" + "您的余额为" + account.balance);

                    } else if (value <= account.balance) {

                        account.balance -= value;
                        System.out.println("您的取款金额为" + value + " ; " + "取款成功,您的余额为" + account.balance);

                    } else {

                        //如果取钱金额>存款金额,就把剩余的钱全都取出来，并把存款清零
                        value = account.balance;
                        account.balance = 0;
                        System.out.println("您的取款金额是" + value + "<=存款金额，所以会把存款金额全部取出来 ; " + "取款成功,您的余额为" + account.balance);

                    }
                } else {

                    System.out.println("您的余额是0，无法取款~");

                }

            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException ignored) {
            }

        }
    }
}


public class multiThreadingBankRefined {
    public static void main(String[] args) {
        Account Tony = new Account("Tony");
        (new FetchThread(Tony)).start();

        //两个线程，一个是存款线程（存款5次）、一个是取款线程（取款5次）
        (new SaveThread(Tony)).start();


    }
}
