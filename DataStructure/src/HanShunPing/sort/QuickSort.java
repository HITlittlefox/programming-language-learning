package HanShunPing.sort;

import java.util.Date;

/**
 * title: ��������
 *
 * @author ��K
 * 2020��12��12�� ����3:05:16
 */
public class QuickSort {
    public static void main(String[] args) {
        // int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};

        // ���Կ��ŵ�ִ���ٶ�
        // ����Ҫ��80000�������������
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }

        new QuickSort(arr);
        // System.out.println(Arrays.toString(arr));
    }

    public QuickSort(int[] arr) {
        long time = new Date().getTime();
        quickSort(arr, 0, arr.length - 1);
        long time2 = new Date().getTime();
        System.out.println("�������� ��" + (arr.length) + "�����ݣ�ʹ��" + (time2 - time) + "����");
    }

    // �������� Api
    public void quickSort(int[] arr, int left, int rigth) {
        int l = left;// ���±�
        int r = rigth;// ���±�

        // pivot ������ ��ֵ
        int pivot = arr[(rigth + left) / 2];
        int temp = 0;// temp ��ʱ����Ϊ����ʱ ����

        // whileĿ�ģ�
        // 1������� pivot С��ֵ �����
        // 2������� pivot ���ֵ ���ұ�
        while (l < r) {// ǰ�᣺ ���ʼ��С���ұߵ�ֵ
            // ��pivot �����һֱ�ң��ҵ����ڵ��� pivotֵ�����˳�
            while (arr[l] < pivot) {
                l += 1;// ��l++������ �������ƺ�Ч�ʵͣ���Ϊ���ջ��� l=l+1 �� l+=1
            }
            // ��pivot ���ұ�һֱ�ң��ҵ�С�ڵ���pivotֵ�����˳�
            while (arr[r] > pivot) {
                r -= 1;
            }

            // �� l >= r ��˵�� pivot ���ߵ�ֵ�Ѿ����� ���� ��
            // ���ȫ��С�ڵ���pivot,�ұ�ȫ�����ڵ���pivot ���к���(���ս��)
            if (l >= r) {
                break;
            }

            // ����
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // ���������֣�arr[l] = arr[pivot] ֵ��ȣ� ��ǰ�� r--
            if (arr[l] == pivot) {
                r -= 1;
            }
            // ���������֣�arr[r] = arr[pivot] ֵ��ȣ� ����� l++
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // �� l==r ,����� l++��r-- ����������ѭ��������ջ���
        if (l == r) {
            l += 1;
            r -= 1;
        }

        // ����ݹ�
        if (left < r)
            quickSort(arr, left, r);
        // ���ҵݹ�
        if (rigth > l)
            quickSort(arr, l, rigth);
    }
}
