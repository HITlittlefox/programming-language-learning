package JavaBook.chap11;

/*
说明：运行程序，则发现整个程序在主线程结束时就随之中止运行了，如果注释掉t.setDaemon(true)语句，则程序永远不会结束。
 */
class ThreadTest extends Thread {
    public void run() {
        int i = 0;
        while (true) {
            i++;
            System.out.println("new thread!" + i);
        }
    }
}

public class App11_9 {
    public static void main(String[] args) {
        System.out.println("main thread starts!");
        ThreadTest t = new ThreadTest();
        t.setDaemon(true);
        t.start();
        //try{Thread.sleep(1);}catch(Exception e){}
        System.out.println("main thread ends!");
    }
}