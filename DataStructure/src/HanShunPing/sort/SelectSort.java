package HanShunPing.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("�����");
        System.out.println(Arrays.toString(arr));


//        //�ٶ�test
//        //����һ��ð��������ٶ�O(n^2)����8w�����ݲ���
//        //����һ��8w�����������
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000);// ����һ��[0,80000)��
//        }
//        new SelectSort(arr);
    }

    public SelectSort(int[] arr) {
        long time = new Date().getTime();
        selectSort(arr);
        long time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");
    }

    //ѡ������
    public static void selectSort(int[] arr) {
        //ʹ�����Ƶ��ķ�ʽ��������ѡ������
        //��1��
        //ԭʼ�����飺101��34��119��1
        //��һ������1��34��119��101
        //�㷨 �ȼ�-->�Ѹ����㷨��ּ�-->�𲽽��
        //�Ƶ������з��ֹ��ɣ�����ʹ��for�����

        //ʱ�临�Ӷ���O(n^2)��Ƕ��forѭ��
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {

                //���Ҫ�Ӵ�С���򣬾�min<arr[j]

                if (min > arr[j]) {//˵���ٶ�����Сֵ����������С
                    min = arr[j];//����min
                    minIndex = j;//����minIndex
                }
            }
            //����Сֵ������arr[0]��������
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("��" + (i + 1) + "�ֺ�~~");
            System.out.println(Arrays.toString(arr));
        }
    }
}
