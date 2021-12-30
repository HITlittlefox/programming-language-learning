package HanShunPing.sort;

import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        // int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        // ����Ҫ��80000�������������
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }

        new QuickSort(arr);
        //new MergeSort(arr);
    }

    public MergeSort(int[] arr) {
        int temp[] = new int[arr.length]; // �鲢������Ҫһ������ռ�
        long time = new Date().getTime();
        mergeSort(arr, 0, arr.length - 1, temp);
        long time2 = new Date().getTime();
        System.out.println("�������� ��" + (arr.length) + "�����ݣ�ʹ��" + (time2 - time) + "����");

    }

    // ����(��+��)���� Api
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;// �м�����

            // ����ݹ�ֽ�
            mergeSort(arr, left, mid, temp);
            // ���ҵݹ�ֽ�
            mergeSort(arr, mid + 1, right, temp);
            // �ϲ�
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * �ϲ��ķ���
     *
     * @param arr   �����ԭʼ����
     * @param left  ����������еĳ�ʼ����
     * @param mid   �м�����
     * @param right �ұ�����
     * @param temp  ����ת������
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left; // ��ʼ�� i,����������еĳ�ʼ����
        int j = mid + 1;// ��ʼ�� j,�ұ��������еĳ�ʼ����
        int t = 0; // ָ�� temp ����ĵ�ǰ����

        // (һ)
        // 1���Ȱ��������ߣ����򣩵����ݣ����չ�����䵽 temp����
        // 2��ֱ�����������������У���һ�ߴ������Ϊֹ
        while (i <= mid && j <= right) {// ִ������
            // ������������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
            // ����ߵĵ�ǰԪ�أ���䵽 temp ����
            // ֮���� t++, i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {// ��֮�����ұ��������еĵ�ǰԪ����䵽 temp ������
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        // (��)����ʣ�����ݵ�һ�ߵ����ݣ�����ȫ����䵽temp ��
        while (i <= mid) {
            // (1) ����������е�ʣ������Ԫ�أ���䵽 temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            // (2) �ұ��������е�ʣ������Ԫ�أ���䵽 temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // (��)
        // �� temp ���鿽���� arr
        // ע�� ����ÿ�ζ���������
        t = 0;
        int tempLeft = left;
        // ��һ�κϲ� tempLeft = 0 , right = 1 // tempLeft = 2 right = 3 // tempLeft=0 right=3
        // ���һ�� tempLeft = 0 right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
