package test;

import java.util.Arrays;

public class test9 {
    //    public class InsertSort {
    public static void insertSort(int[] a) {
        int i, j, insertNote;// Ҫ���������
        for (i = 1; i < a.length; i++) {// ������ĵڶ���Ԫ�ؿ�ʼѭ���������е�Ԫ�ز���
            insertNote = a[i];// ���������еĵ�2��Ԫ��Ϊ��һ��ѭ��Ҫ���������

            // �ƶ�"��insertNote��"��Ԫ��
            j = i - 1;
            while (j >= 0 && insertNote < a[j]) {
                a[j + 1] = a[j];// ���Ҫ�����Ԫ��С�ڵ�j��Ԫ��,�ͽ���j��Ԫ������ƶ�
                j--;
            }

            // ����"insertNote"Ԫ��
            a[j + 1] = insertNote;// ֱ��Ҫ�����Ԫ�ز�С�ڵ�j��Ԫ��,��insertNote���뵽������
        }
    }

    public static void main(String[] args) {
        int[] a = {38, 65, 97, 76, 13, 27, 49};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
//    }
}
