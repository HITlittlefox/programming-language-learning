package chap9;

public class HeapSort {

    //�������ѣ����������ã�
    public static void createHeap(int[] a, int n, int h) {
        int i, j, flag;
        int temp;

        i = h;// iΪҪ���ѵĶ�����������±�
        j = 2 * i + 1;// jΪi�������ӽ����±�
        temp = a[i];
        flag = 0;

        //�����Һ�����ֵ�ϴ����ظ�����ɸѡ
        while (j < n && flag != 1) {

            //Ѱ�����Һ��ӽ���еĽϴ���,jΪ���±�
            if (j < n - 1 && a[j] < a[j + 1]) {
                j++;
            }

            if (temp > a[j])    //������ڵ�>�����Һ����нϴ��㡱  a[i]>a[j]
                flag = 1;   //��ǽ���ɸѡ����
            else {
                //������ڵ�<�����Һ����нϴ��㡱,���ô�ĺ��ӽ���븸�ڵ㽻��λ��
                //�����a[j]����
                a[i] = a[j];
                i = j;
                j = 2 * i + 1;//���ղŽϴ��ӵ�����
            }
        }
        a[i] = temp;//������ڵ�<�����Һ����нϴ��㡱,���ô�ĺ��ӽ���븸�ڵ㽻��λ�ã��������a[i]��������a[j]
    }

    //��ʼ�������ѣ���ÿһ����Ҷ�ڵ㵽���ڵ���е�����
    public static void initCreateHeap(int[] a) {
        int n = a.length;
        for (int i = (n - 1) / 2; i >= 0; i--)
            createHeap(a, n, i);
    }

    //������

    /**
     * @param a ���������˼�룺ѭ��ִ�����¹���ֱ������Ϊ��
     *          1. �ѶѶ�a[0]Ԫ�أ����Ԫ�أ��͵�ǰ���ѵ����һ��Ԫ�ؽ���
     *          2. ����Ԫ�ظ�����1
     *          3. �������ڵ�ʹ֮�������ѵĶ���
     */
    public static void heapSort(int[] a) {
        int temp;
        int n = a.length;

        initCreateHeap(a);                //��ʼ����������

        for (int i = n - 1; i > 0; i--) {    //��ǰ���Ѹ���ÿ�εݼ�1
            //�ѶѶ�a[0]Ԫ�غ͵�ǰ���ѵ����һ��Ԫ�ؽ���
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            createHeap(a, i, 0);            //�����������������
        }
    }

    public static void main(String[] args) {
        int[] test = {10, 50, 32, 5, 76, 9, 40, 88};
        int n = test.length;

        heapSort(test);
        for (int j : test) {
            System.out.print(j + "  ");
        }
    }
}
