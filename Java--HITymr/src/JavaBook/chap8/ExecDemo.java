package JavaBook.chap8;

public class ExecDemo{
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("notepad");    
            Thread.sleep(5000);    //������ͣ1����
            p.destroy();    //�ر��ⲿ����
            System.out.println("main thread end.");
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        } 
    }
}