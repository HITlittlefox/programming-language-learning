package JavaBook.chap11;

//多线程中join()方法

class MyThread1 extends Thread {
    private final String who;

    public MyThread1(String str) {
        who = str;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                int num = (int) (1000 * Math.random());
                System.out.println(num);
                sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(who + "is running!");
        }
    }
}

public class App11_3 {
    public static void main(String[] args) {

        MyThread1 you = new MyThread1("you");
        MyThread1 she = new MyThread1("she");
        you.start();
        try {
            //当某一线程调用join()方法时，则其他线程会等到该线程结束后才开始执行。
            you.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        she.start();
        try {
            she.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main() ran over!");
    }
}
