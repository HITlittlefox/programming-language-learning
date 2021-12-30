package chap6;

import java.util.Arrays;
import java.util.Date;

public class Hw614 {
    public static void main(String[] args) {

        //����
        int[] arr = {1, 3, 4, 7, 9};
        System.out.println("ԭ����Ϊ" + Arrays.toString(arr));
        int index = binarySearch(arr, 1);
        System.out.println("��Ҫ��1�����Ϊ" + index);
        index = binarySearch(arr, 2);
        System.out.println("��Ҫ��2�����Ϊ" + index);
        index = binarySearch(arr, 9);
        System.out.println("��Ҫ��9�����Ϊ" + index);

//    }

        //�ٶ�test
        //����һ��ð��������ٶ�O(n^2)����8w�����ݲ���
        //����һ��10000�����������
        int[] arr2 = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr2[i] = (int) (Math.random() * 1000000);// ����һ��[0,80000)��
        }
        new Hw614(arr2);
        BinarySearchRecur(arr2, 6999, 0, 10000);
    }

    public Hw614(int[] arr) {
        long time = new Date().getTime();
        binarySearch(arr, 6999);
        long time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");
    }

    public static void BinarySearchRecur(int[] a, int x, int low, int high) {
        long time = new Date().getTime();

        int bn = bSearch(a, x, low, high);
        if (bn == -1)
            System.out.println("x��������a��");
        else
            System.out.println("x������a�У��±�Ϊ" + bn);

        long time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");
    }


    //���ֲ��ҵ�ѭ���ṹ����

    /**
     * @param arr    ��Ҫ���ҵ����飬����arr������
     * @param target ��Ҫ���ҵ���
     * @return ���ض�Ӧ���±�-1��ʾû���ҵ�
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {//˵����������
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;//����߲���
            } else {
                left = mid + 1;//���ұ߲���
            }
        }
        return -1;
    }


    public static int bSearch(int[] a, int x, int low, int high) {
        int mid;

        if (low > high)
            return -1;

        mid = (low + high) / 2;
        if (x == a[mid])
            return mid;
        else if (x < a[mid])
            return bSearch(a, x, low, mid - 1);
        else
            return bSearch(a, x, mid + 1, high);
    }

}
