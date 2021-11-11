package JavaBook.chap11;


//例:创建两个具有不同优先级的线程，都从1递增到200000，每增加50000显示一次。
class Test50000 extends Thread {
    private int tick = 1;
    private int num;

    public Test50000(int i) {
        this.num = i;
    }

    public void run() {
        while (tick < 200000) {
            tick++;
            //每隔5000进行显示
            if ((tick % 50000) == 0) {
                System.out.println("Thread #" + num + ", tick = " + tick);
                //放弃执行权
                Thread.yield();
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


public class _50000 {
    public static void main(String[] args) {
        Test50000[] runners = new Test50000[2];
        for (int i = 0; i < 2; i++) {
            //创造多线程
            runners[i] = new Test50000(i);
        }
        //设置第一个线程优先级为2
        runners[0].setPriority(10);
        //设置第二个线程优先级为3
        runners[1].setPriority(2);
        for (int i = 0; i < 2; i++) {
            //start多线程
            runners[i].start();
        }
    }
}
