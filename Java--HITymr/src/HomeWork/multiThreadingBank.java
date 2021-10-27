//
//package HomeWork;
//
////银行账户类
//class Account {
//    String name;
//    double balance;
//
//    //构造方法
//    public Account(String name) {
//        this.name = name;
//        this.balance = 0;
//    }
//
//    //存款方法，使用synchronized
//    public synchronized void put(double value) {
//
//        if (value > 0) {
//            this.balance += value;
//        }
//        System.out.println("您的存款金额为" + value + " ; " + "存款成功,您的余额为" + this.balance);
//
//    }
//
//    //取款方法，使用synchronized
//    public synchronized void get(double value) {
//
//
//        //如果取钱金额<=存款金额,取出来，并把存款金额减去取钱金额
//        if (this.balance > 0) {
//            //如果要取负数,取不到钱
//            if (value <= 0) {
//
//                System.out.println("您的取款金额是负数，无法取款负数的金额！" + "您的余额为" + this.balance);
//
//            } else if (value <= this.balance) {
//
//                this.balance -= value;
//                System.out.println("您的取款金额为" + value + " ; " + "取款成功,您的余额为" + this.balance);
//
//            } else {
//
//                //如果取钱金额>存款金额,就把剩余的钱全都取出来，并把存款清零
//                value = this.balance;
//                this.balance = 0;
//                System.out.println("您的取款金额是" + value + "<=存款金额，所以会把存款金额全部取出来 ; " + "取款成功,您的余额为" + this.balance);
//
//            }
//        } else {
//
//            System.out.println("您的余额是0，无法取款~");
//
//        }
//
//    }
//
//}
//
////多线程
//class SaveThread extends Thread {
//    private Account account;
//    private double value;
//
//    //传入一个account类、一个double值
//    public SaveThread(Account account, double value) {
//        this.account = account;
//        this.value = value;
//    }
//
//    public void run() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException ex) {
//        }
//        System.out.println("valueInPut:" + this.value);
//        this.account.put(this.value);
//    }
//
//}
//
////主线程
//class FetchThread extends Thread {
//
//    private Account account;
//    private double value;
//
//    public FetchThread(Account account, double value) {
//        this.account = account;
//        this.value = value;
//    }
//
//    public void run() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException ignored) {
//        }
//        System.out.println("valueInGet:" + this.value);
//        this.account.get(this.value);
//    }
//
//}
//
//
//public class multiThreadingBank {
//    public static void main(String[] args) {
//        Account Tony = new Account("Tony");
//
//        (new SaveThread(Tony, 500)).start();
//        (new FetchThread(Tony, 600)).start();
//        (new SaveThread(Tony, 700)).start();
//        (new SaveThread(Tony, 800)).start();
//        (new SaveThread(Tony, 900)).start();
//        (new SaveThread(Tony, 1000)).start();
//        (new SaveThread(Tony, 500)).start();
//        (new FetchThread(Tony, 500)).start();
//        (new FetchThread(Tony, 600)).start();
//        (new FetchThread(Tony, 700)).start();
//        (new FetchThread(Tony, 800)).start();
//        (new FetchThread(Tony, 900)).start();
//        (new SaveThread(Tony, 1000)).start();
//        (new FetchThread(Tony, 600)).start();
//
//
//    }
//}
