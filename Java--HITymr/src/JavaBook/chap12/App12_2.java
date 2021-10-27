package JavaBook.chap12;

//���ͷ�����Ӧ��
//filename App12_2.java
public class App12_2             //����һ���࣬���Ƿ�����
{

//    public static <E> void display(E[] list)  //���巺�ͷ�����EΪ���Ͳ���
//    {
//        for (int i = 0; i < list.length; i++)
//            System.out.print(list[i] + "  ");
//        System.out.println();
//    }

    //�÷����Ĳ������յ���E���͵����飬�������������������list���յ������ÿ������
    public static <E> void display(E[] list)  //���巺�ͷ�����EΪ���Ͳ���
    {
        for (E e : list) {
            System.out.print(e + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] num = {1, 2, 3, 4, 5};                     //��������
        String[] str = {"red", "Orange", "Yellow", "Green", "Cyanogen", "Blue", "Purple"};
        App12_2.<Integer>display(num);    //���÷��ͷ���
        App12_2.<String>display(str);
    }

}