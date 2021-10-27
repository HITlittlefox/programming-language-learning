package JavaBook.chap8;

public class ExecDemo{
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("notepad");    
            Thread.sleep(5000);    //程序暂停1秒钟
            p.destroy();    //关闭外部程序
            System.out.println("main thread end.");
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        } 
    }
}