//package JavaBook.chap11;
//
////ģ�⺽����Ʊϵͳ��ʵ��3����Ʊ���ڷ���ĳ�κ����10�Ż�Ʊ��һ����Ʊ������һ���߳�����ʾ��
////����һ��Thread�����࣬ģ�⺽����Ʊ����
//
////ÿ���̶߳��ڶ����ش�����Ե���Դ
//
//class ThreadSale extends Thread {
//    //˽�б���tickets����Ʊ�����ǹ�������
//    private int tickets = 10;
//
//
//    public void run() {
//        while (true) {
//            //�����Ʊ����
//            if (tickets > 0) {
//                System.out.println(this.getName() + " sale number " + tickets-- + ".");
//            } else {
//                System.exit(0);
//            }
//        }
//    }
//}
//
////�����࣬main�д���������3���̶߳���
//public class App11_4 {
//    public static void main(String[] args) {
//        ThreadSale t1 = new ThreadSale();
//        ThreadSale t2 = new ThreadSale();
//        ThreadSale t3 = new ThreadSale();
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//
//}
