package JavaBook.chap11;

//��Runnable�ӿڴ������߳�
class MyThread implements Runnable {
    private String who;

    public MyThread(String str) {
        who = str;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                int num = (int) (1000 * Math.random());
                System.out.println(num);
                //MyThread������Runnableʵ�ֵģ�����sleep()��Ҫ��ǰ׺Thread
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(who + "is running!");
        }
    }
}

public class App11_2 {
    public static void main(String[] args) {
        MyThread you = new MyThread("you");
        MyThread she = new MyThread("she");
        Thread t1 = new Thread(you);
        Thread t2 = new Thread(you);
        t1.start();
        t2.start();


    }
}
