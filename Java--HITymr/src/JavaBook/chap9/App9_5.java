package JavaBook.chap9;

//�������ṩ�ɼ������ṩ�ĳ���2λ����һ����ָ���쳣�Ĵ������������飬��check�׳���ֵ��ʽ�쳣����û���ṩ����������main���쳣����
public class App9_5 {
    //���������Ǹ����������׳��쳣:�����˵�һ��׳�������ʵ��ideû�õ�����쳣�����ͻ�˵��Ϊ��˵����������
    static void check(String str1) throws NullPointerException {

        if (str1.length() > 2) {
//            str1 = null;
//            System.out.println(str1.length());
            throw new NullPointerException();
        }
        char ch;
        for (int i = 0; i < str1.length(); i++) {
            ch = str1.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new NullPointerException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int num;
        try {
            args = new String[]{"100"};
            check(args[0]);
            num = Integer.parseInt(args[0]);
            if (num > 60) {
                System.out.println("GoOn");
            } else {
                System.out.println("you need learn more!");
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException:" + e.toString());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException:" + e.toString());
        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
    }
}
