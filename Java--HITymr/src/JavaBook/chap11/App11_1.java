package JavaBook.chap11;

//由Thread类创建多线程的方法:
//从Thread类派生一个子类，并创建这个子类的对象，就可以产生一个新的线程；
//这个子类应该重写Thread类的run()方法，在run方法中写入需要在新线程中执行的语句段；
//这个子类的对象需要调用start()方法来启动，新线程将自动进入run方法。原线程将同时继续往下执行。

//使用Thread类的子类来创建线程
class MyThread0 extends Thread {
    private final String who;

    public MyThread0(String str) {
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

public class App11_1 {
    public static void main(String[] args) {

        MyThread0 you = new MyThread0("you");
        MyThread0 she = new MyThread0("she");
        you.start();
        she.start();
        System.out.println("main() ran over!");
    }
}
