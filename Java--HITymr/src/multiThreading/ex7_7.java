package multiThreading;

//without synchronized
//同步代码 或 同步方法
class Tickets {
    int number = 0;          //票号
    int size;                   //总票数
    boolean available = false;  //表示目前是否有票可售

    public Tickets(int size) { //构造函数，传入总票数参数
        this.size = size;
    }
}

class Producer extends Thread {//存票线程
    private Tickets t = null;

    public Producer(Tickets t) {
        this.t = t;
    }


    public void run() {
        while (t.number < t.size) {
            synchronized (t) { // 申请对象t的互斥锁

                System.out.println("Producer puts ticket " + (++t.number));
                t.available = true;
            } // 释放对象t的互斥锁

        }
        System.out.println("Producer ends!");
    }
}

class Consumer extends Thread { //售票线程

    Tickets t = null;
    int i = 0; //卖票票号

    public Consumer(Tickets t) {
        this.t = t;
    }

    public void run() {
        while (i < t.size) {
            synchronized (t) {  //申请对象t的锁旗标
                if (t.available && i <= t.number)
                    System.out.println("Consumer buys ticket " + (++i));
                if (i == t.number) {
                    //try{Thread.sleep(1);}catch(Exception e){}
                    t.available = false;
                }
            }    //释放对象t的锁旗标
        }
        System.out.println("Consumer ends");
    }
}

public class ex7_7 {
    public static void main(String[] args) {
        Tickets t = new Tickets(10);
        new Consumer(t).start();
        new Producer(t).start();
    }
}
