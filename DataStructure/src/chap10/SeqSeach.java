package chap10;

//�������в���ĳ��Ԫ���Ƿ���ڡ�˳�����
public class SeqSeach {
    public static int seqSeach(int[] a, int elem) {
        int n = a.length;
        int i = 0;
        while (i < n && a[i] != elem) i++;

        if (a[i] == elem) return i;
        else return -1;
    }

    public static void main(String[] args) {
        int[] test = {710, 342, 45, 686, 6, 841, 429, 134, 68, 264};
        int n = 10, elem = 686, i;

        if ((i = seqSeach(test, elem)) != -1)
            System.out.println("���ҳɹ�! �ö���Ϊ��" + i + "������");
        else System.out.println("����ʧ��! �ö����ڶ��󼯺��в�����");
    }
}
