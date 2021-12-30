package chap9;

//�鲢����
public class MergeSort {
    public static void merge(int[] a, int[] swap, int k) {
        int n = a.length;
        int m = 0, u1, l2, i, j, u2;
        int l1 = 0;                                //��һ�������������½�Ϊ0
        while (l1 + k <= n - 1) {
            l2 = l1 + k;                            //����ڶ��������������½�
            u1 = l2 - 1;                            //�����һ�������������Ͻ�
            u2 = (l2 + k - 1 <= n - 1) ? l2 + k - 1 : n - 1;        //����ڶ��������������Ͻ�

            for (i = l1, j = l2; i <= u1 && j <= u2; m++) {
                if (a[i] <= a[j]) {
                    swap[m] = a[i];
                    i++;
                } else {
                    swap[m] = a[j];
                    j++;
                }
            }

            //������2�ѹ鲢�꣬��������1��ʣ���Ԫ�ش�ŵ�����swap��
            while (i <= u1) {
                swap[m] = a[i];
                m++;
                i++;
            }

            //������1�ѹ鲢�꣬��������2��ʣ���Ԫ�ش�ŵ�����swap��
            while (j <= u2) {
                swap[m] = a[j];
                m++;
                j++;
            }

            l1 = u2 + 1;
        }

        //��ԭʼ������ֻ��һ�������Ԫ��˳���ŵ�����swap��
        for (i = l1; i < n; i++, m++)
            swap[m] = a[i];
    }

    public static void mergeSort(int[] a) {
        int i;
        int n = a.length;
        int k = 1;//�鲢���ȴ�1��ʼ
        int[] swap = new int[n];

        while (k < n) {
            merge(a, swap, k);//���ú���merge()

            for (i = 0; i < n; i++)
                a[i] = swap[i];//��Ԫ�ش���ʱ����swap�Ż�����a��

            k = 2 * k;//�鲢���ȼӱ�
        }
    }

    public static void main(String[] args) {
        int[] test = {72, 73, 71, 23, 94, 16, 5, 68, 46};
        ;
        int n = test.length;

        mergeSort(test);
        for (int i = 0; i < n; i++)
            System.out.print(test[i] + "  ");
    }
}
