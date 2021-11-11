package JavaBook.chap11;

//��Thread�ഴ�����̵߳ķ���:
//��Thread������һ�����࣬�������������Ķ��󣬾Ϳ��Բ���һ���µ��̣߳�
//�������Ӧ����дThread���run()��������run������д����Ҫ�����߳���ִ�е����Σ�
//�������Ķ�����Ҫ����start()���������������߳̽��Զ�����run������ԭ�߳̽�ͬʱ��������ִ�С�

//ʹ��Thread��������������߳�
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
