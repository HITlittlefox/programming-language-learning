package JavaBook.chap10;

//��:�����������в�ͬ���ȼ����̣߳�����1������200000��ÿ����50000��ʾһ�Ρ�
class TestThread extends Thread {
    private int tick = 1;
    private int num;

    public TestThread(int i) {
        this.num = i;
    }

    public void run() {
        while (tick < 200000) {
            tick++;
            //ÿ��5000������ʾ
            if ((tick % 50000) == 0) {
                System.out.println("Thread #" + num + ", tick = " + tick);
                //����ִ��Ȩ
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


public class ex7_5 {
    public static void main(String[] args) {
        TestThread[] runners = new TestThread[2];
        for (int i = 0; i < 2; i++) {
            //������߳�
            runners[i] = new TestThread(i);
        }
        //���õ�һ���߳����ȼ�Ϊ2
        runners[0].setPriority(2);
        //���õڶ����߳����ȼ�Ϊ3
        runners[1].setPriority(2);
        for (int i = 0; i < 2; i++) {
            //start���߳�
            runners[i].start();
        }
    }
}
