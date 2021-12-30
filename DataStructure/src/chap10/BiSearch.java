package chap10;

//���ֲ���
public class BiSearch {
    public static int biSearch(int[] a, int elem) {
        int n = a.length;
        int low = 0, high = n - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == elem) return mid;
            else if (a[mid] < elem) low = mid + 1;//���Ҳ���
            else high = mid - 1;//�������
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 5, 7, 9, 11, 13, 15, 17, 20};
        //elem:������Ԫ��
        int n = 10, elem = 11, i;

        if ((i = biSearch(test, elem)) != -1)
            System.out.println("���ҳɹ�! �ö���Ϊ��" + i + "������");
        else System.out.println("����ʧ��! �ö����ڶ��󼯺��в�����");
    }
}
