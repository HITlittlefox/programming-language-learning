package JavaBook.chap12;
//filename��App12_8.java

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class App12_8 {
    public static void main(String[] args) {
        //���������б����al
        List<Integer> al = new ArrayList<Integer>();
        //���
        for (int i = 1; i < 5; i++) {
            //�������б�al�����Ԫ��
            al.add(i);
        }

        System.out.println("ArrayList origin data: " + al);

        //���������б�al�ĵ�����listIter
        ListIterator<Integer> listIter = al.listIterator();
        //�����Ϊ0��Ԫ��ǰ���һ��Ԫ��
        listIter.add(0);
        System.out.println("data after add: " + al);

        if (listIter.hasNext()) {
            System.out.println("listIter.hasNext()): " + listIter.hasNext());
//            System.out.println("listIter.previousIndex()): " + listIter.previousIndex());
            //ָ���ӵ�0��ָ����һ��
            System.out.println("listIter.next()): " + listIter.next());
            //ָ���ӵ�1��ָ����һ��
            System.out.println("listIter.next()): " + listIter.next());
            //ָ���ӵ�2��ָ����һ����Ҳ����listIter[3],�ǵ��ĸ���,ֵΪ3
            int i = listIter.nextIndex();    //ִ�и����ʱi��ֵ��1
            System.out.println("value of i is: " + i);
            listIter.next();             //�������Ϊ1��Ԫ��
            listIter.set(9);  //�޸������б�al�����Ϊ1��Ԫ��
            System.out.println("data after edit: " + al);
        }

        listIter = al.listIterator(al.size());   //���´�����al���λ�ÿ�ʼ�ĵ�����listIter
        System.out.print("reverse: ");    //������������б�

        while (listIter.hasPrevious()) {
            System.out.print(listIter.previous() + "  ");    //������������б�
        }

    }
}
