//package JavaBook.chap11;
//
////模拟航班售票系统，实现3个售票窗口发售某次航班的10张机票，一个售票窗口用一个线程来表示。
////创建一个Thread子列类，模拟航班售票窗口
//
////每个线程都在独立地处理各自的资源
//
//class ThreadSale extends Thread {
//    //私有变量tickets代表及票数，是共享数据
//    private int tickets = 10;
//
//
//    public void run() {
//        while (true) {
//            //如果有票可售
//            if (tickets > 0) {
//                System.out.println(this.getName() + " sale number " + tickets-- + ".");
//            } else {
//                System.exit(0);
//            }
//        }
//    }
//}
//
////创建类，main中创建并启动3个线程对象
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
