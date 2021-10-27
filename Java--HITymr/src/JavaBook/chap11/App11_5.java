package JavaBook.chap11;

//ģ�⺽����Ʊϵͳ��ʵ��3����Ʊ���ڷ���ĳ�κ����10�Ż�Ʊ��һ����Ʊ������һ���߳�����ʾ��
//��Runnable�ӿڳ���ģ�⺽����Ʊ����

//ÿ���̶߳��ڶ����ش�����Ե���Դ
//����������
//3���ڹ�ͬ��10��Ʊ

class ThreadSale extends Thread {
    //˽�б���tickets����Ʊ�����ǹ�������
    private int tickets = 10;


    public void run() {
        while (true) {
            //�����Ʊ����
            if (tickets > 0) {
                System.out.println(this.getName() + " sale number " + tickets-- + ".");
            } else {
                System.exit(0);
            }
        }
    }
}

//�����࣬main�д���������3���̶߳���
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
