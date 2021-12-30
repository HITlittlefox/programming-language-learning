package HanShunPing.search;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};

        int findVal = 1000;
        System.out.println(binarySearch(arr, 0, arr.length - 1, findVal));
    }

    /**
     * ���ֲ���(������)
     *
     * @param arr     ԭʼ����
     * @param left    �������
     * @param right   �ұ�����
     * @param findVal ���ҵ�ֵ
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        // �� left > right ʱ��˵���Ѿ��ݹ���ϣ���û���ҵ�
        if (left > right) {
            return -1;
        }

        // �۰룬ȡֵ
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {// ���ҵݹ�
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {// ����ݹ�
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
