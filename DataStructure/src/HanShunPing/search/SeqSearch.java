package HanShunPing.search;

/**
 * title: ���Բ���
 *
 * @author ��K 2020��12��21�� ����10:40:24
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        int num = 8;
        if (orderFind(arr, num) == -1) {
            System.out.println("δ�ҵ�");
        } else {
            System.out.println(orderFind(arr, num));
        }

    }

    public static int orderFind(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
