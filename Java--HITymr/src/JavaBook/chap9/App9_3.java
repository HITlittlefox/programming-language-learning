package JavaBook.chap9;

//ʹ��throw����ڷ������׳��쳣������ͬһ�����ڽ�����Ӧ���쳣����
public class App9_3 {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            if (b == 0) {
                System.out.println("1");
                //�׳��쳣���������Ķ�����Ҫnewһ��(��������  )
                throw new ArithmeticException();
            } else {
                System.out.println(a + "/" + b + "=" + a / b);
            }
        }//�����쳣
        catch (ArithmeticException e) {
            System.out.println("Exception: " + e + " is thrown!");
            e.printStackTrace();
        }
    }
}
