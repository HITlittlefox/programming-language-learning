package JavaBook.chap11;


//��:�����������в�ͬ���ȼ����̣߳�����1������200000��ÿ����50000��ʾһ�Ρ�
class Test50000 extends Thread {
    private int tick = 1;
    private int num;

    public Test50000(int i) {
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


public class _50000 {
    public static void main(String[] args) {
        Test50000[] runners = new Test50000[2];
        for (int i = 0; i < 2; i++) {
            //������߳�
            runners[i] = new Test50000(i);
        }
        //���õ�һ���߳����ȼ�Ϊ2
        runners[0].setPriority(10);
        //���õڶ����߳����ȼ�Ϊ3
        runners[1].setPriority(2);
        for (int i = 0; i < 2; i++) {
            //start���߳�
            runners[i].start();
        }
    }
}
