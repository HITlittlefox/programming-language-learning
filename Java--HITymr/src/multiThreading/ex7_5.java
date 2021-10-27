package multiThreading;

class TestThread extends Thread {
    private int tick = 1;
    private final int num;

    public TestThread(int i) {
        this.num = i;
    }

    public void run() {
        while (tick < 200000) {
            tick++;
            if ((tick % 50000) == 0) { //每隔5000进行显示
                System.out.println("Thread #" + num + ", tick = " + tick);
                Thread.yield();  //放弃执行权
                try {
                    sleep(1);
                } catch (Exception ignored) {
                }
            }
        }
    }
}

public class ex7_5 {
    public static void main(String[] args) {
        TestThread[] runners = new TestThread[2];
        for (int i = 0; i < 2; i++) {
            runners[i] = new TestThread(i);//创造多线程
        }
        runners[0].setPriority(2);   //设置第一个线程优先级为2
        runners[1].setPriority(3);   //设置第二个线程优先级为3
        for (int i = 0; i < 2; i++) {
            runners[i].start();//start多线程
        }
    }
}

