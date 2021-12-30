package chap10;

//��������ģ�˳�����
public class OrderSeqSearch {
    public static int orderSeqSearch(int[] a, int elem) {
        int n = a.length;
        int i = 0;
        while (i < n && a[i] < elem) i++;

        if (a[i] == elem) {
            return i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] test = {2, 4, 6, 8, 10};
        int n = 5, elem = 6, i;

        if ((i = orderSeqSearch(test, elem)) != -1) System.out.println("���ҳɹ�! �ö���Ϊ��" + i + "������");
        else System.out.println("����ʧ��! �ö����ڶ��󼯺��в�����");
    }
}
