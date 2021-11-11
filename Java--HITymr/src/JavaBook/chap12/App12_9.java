package JavaBook.chap12;//filename��App12_9.java

//��ÿ���ַ�����ӵ���ϣ�����У����������е�Ԫ�ز�����ӣ������ظ���Ԫ�������
//����ڶԼ��Ͻ��б��������������Ԫ�ء�
//HashSet�ص㣺���ظ�����˳��

import java.util.HashSet;

public class App12_9 {
    public static void main(String[] args) {

        String[] input_thing = new String[]{
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "11", "12", "13", "14", "15"
        };

        HashSet<String> hs = new HashSet<String>(); //������ϣ���϶���hs����ʼ����Ϊ16
        //LinkedHashSet<String> hs=new LinkedHashSet<String>();

        for (String a : input_thing)
            //���hsû����ӳɹ�a
            if (!hs.add(a))          //���ϣ����hs���Ԫ�أ����ظ���Ԫ�ز����
            {
                System.out.println("element: " + a + " is duplicate");        //����ظ���Ԫ��
            }
        System.out.println("Content of HashSet is: " + hs.size() + ", whose element is ");
        //������ϣ����hs�ĵ�����it
        //�жϼ������Ƿ��к���Ԫ��
        for (String h : hs) {
            System.out.print(h + "  ");   //�����ϣ�����е�Ԫ��
        }

    }
}
