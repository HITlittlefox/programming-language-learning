package JavaBook.chap11;

/*
程序说明：
当Consumer线程售出票后，available值变为false，当Producer线程放入票后，available值变为true；
只有available为true时，Consumer线程才能售票，否则就必须等待Producer线程放入新的票后的通知；
只有available为false时，Producer线程才能放票，否则必须等待Consumer线程售出票后的通知。

//实现的是存一票卖一票
 */

//票类
class Tickets {
    protected int size;
    int number = 0;
    boolean available = false;

    public Tickets(int size) {
        this.size = size;
    }

    //对方法同步，同一个对象实现互斥同步，对这个方法属于的类实现同步，也就是t
    public synchronized void put() {
        if (available)
            try {
                //进入等待池，并释放互斥锁(锁旗标)
                wait();
            } catch (Exception ignored) {
            }
        System.out.println("存入第【" + (++number) + "】号票");
        available = true;
        //唤醒另一个进程
        notify();
    }

    public synchronized void sell() {
        if (!available)
            try {
                //进入等待池，并释放互斥锁(锁旗标)
                wait();
            } catch (Exception ignored) {
            }
        System.out.println("售出第【" + (number) + "】号票");
        available = false;
        //唤醒另一个进程
        notify();
        if (number == size) number = size + 1;
        //number>size表示售票结束
    }
}

//生产者类，是一个线程
class Producer extends Thread {
    Tickets t = null;

    public Producer(Tickets t) {
        this.t = t;
    }

    public void run() {
        //while循环
        while (t.number < t.size)
            t.put();
    }
}

//消费者类，是一个线程
class Consumer extends Thread {
    Tickets t = null;

    public Consumer(Tickets t) {
        this.t = t;
    }

    public void run() {
        while (t.number <= t.size)
            t.sell();
    }
}

public class App11_8 {
    public static void main(String[] args) {
        Tickets t = new Tickets(10);
        //启动两个线程
        //两个线程操作同一个临界资源t
        new Producer(t).start();
        new Consumer(t).start();
    }
}