package test;

import java.util.Arrays;

//ѡ������
public class test8 {
//    public class selectSort {

    //ѡ������
    public static void selectSort(int[] arr) {
        //�������е���
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            //�ѵ�ǰ���������ͺ������е������ν��бȽϣ�����¼����С�������±�
            for (int j = i + 1; j < arr.length; j++) {
                //�������Ƚϵ����ȼ�¼����С����С
                if (arr[j] < arr[min]) {
                    //��¼��С���Ǹ������±�
                    min = j;
                }
            }
            //�����С�����͵�ǰ���������±겻һ�£�˵���±�Ϊmin�����ȵ�ǰ����������С
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
//}
}

