package chap9;

public class QuickSort {
    public static void quickSort(int[] a, int low, int high) {
        int i, j;
        int temp;

        i = low;
        j = high;
        temp = a[low];//ȡ��һ��Ԫ��Ϊ��׼����Ԫ�أ���i���ڵ�Ԫ�ر�����һ�ߣ�

        while (i < j) {
            //��������Ҷ�ɨ��
            //j�����ߣ�������������������������temp���ͼ������������ֱ��ij��������ֱ��������һ��С��temp����
            while (i < j && temp <= a[j]) j--;
            //�������while��i��Ȼ��j���
            if (i < j) {
                //��ʱ�Ѹղ�j�ҵ��ı�tempС�������ŵ�i
                a[i] = a[j];
                //i������һ��
                i++;
            }

            //����������ɨ��
            //iû������j��ʱ�򣬲���i����λ�õ���С��temp��ʱ��һֱ���ұ�����֪��ij����������i����һ����temp�����
            while (i < j && a[i] < temp) i++;
            //�������while��i��Ȼ��j���
            if (i < j) {
                //��ʱ�Ѹղ�j�ҵ��ı�temp��������ŵ�j
                a[j] = a[i];
                //j������һ��
                j--;
            }
            //����ij������
        }
        //��������ij�������Ǹ�ֵ����Ϊtemp����
        a[i] = temp;

        if (low < i) quickSort(a, low, i - 1);//������Ӽ��ϵݹ�
        if (i < high) quickSort(a, j + 1, high);//���Ҷ��Ӽ��ϵݹ�
    }

    public static void main(String[] args) {
        int[] test = {60, 55, 48, 37, 10, 90, 84, 36};
        int n = 8;

        quickSort(test, 0, 7);
        for (int i = 0; i < n; i++)
            System.out.print(test[i] + "  ");
    }
}
