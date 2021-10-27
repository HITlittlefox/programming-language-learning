package JavaBook.chap11;

//模拟航班售票系统，实现3个售票窗口发售某次航班的10张机票，一个售票窗口用一个线程来表示。
//用Runnable接口程序，模拟航班售票窗口

//每个线程都在独立地处理各自的资源
//解决这个问题
//3窗口共同卖10张票

class ThreadSale extends Thread {
    //私有变量tickets代表及票数，是共享数据
    private int tickets = 10;


    public void run() {
        while (true) {
            //如果有票可售
            if (tickets > 0) {
                System.out.println(this.getName() + " sale number " + tickets-- + ".");
            } else {
                System.exit(0);
            }
        }
    }
}

//创建类，main中创建并启动3个线程对象
public class App11_5 {
    public static void main(String[] args) {
        ThreadSale t = new ThreadSale();
        Thread t1 = new Thread(t, "first sale window");
        Thread t2 = new Thread(t, "second sale window");
        Thread t3 = new Thread(t, "third sale window");
        t1.start();
        t2.start();
        t3.start();
    }

}
