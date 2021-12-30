package HanShunPing.sort;

/**
 * title: ������(�󶥶Ѱ���--800W���ݲ���
 *
 * @author ��K
 * 2021��1��2�� ����11:22:55
 */
public class HeapSort {

    public static void main(String[] args) {
        // Ҫ�����������������
//      int arr[] = {4, 6, 8, 5, 9};
//      heapSort(arr);
//      System.out.println(Arrays.toString(arr));

        // 800w ���ݲ���
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }
        long time1 = System.currentTimeMillis();
        heapSort(arr);
        long time2 = System.currentTimeMillis();
        System.out.println("������ʵ�ִ󶥶�����800W���ݣ�" + (time2 - time1) + "����");
    }

    /**
     * ����������(���յ���)
     *
     * @param arr ���������
     */
    public static void heapSort(int[] arr) {
        int temp = 0;

        // �ֲ�����
//      adjustHeap(arr, 1, arr.length);
//      System.out.println("��һ��" + Arrays.toString(arr)); // 4, 9, 8, 5, 6
//      adjustHeap(arr, 0, arr.length);
//      System.out.println("�ڶ���" + Arrays.toString(arr)); // 9, 6, 8, 5, 4

        // ��������
        // ���������й����ɵ�һ���ѣ�����������߽���ѡ��󶥶ѻ���С����
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // ���Ѷ�Ԫ����ĩβԪ�ؽ����������Ԫ�� "��"������ĩ��
        // ���µ����ṹ��ʹ������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ�������������ִ�� ������ -> ��������ֱ��������������
        // ʱ�临�Ӷ� Ϊ���� O(nlogn)
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * ��һ�����飨����������������һ���󶥶�
     * ���ܣ���ɽ� �� i ��Ӧ�ķ�Ҷ�ӽڵ���������ɴ󶥶�
     * eg����һ�Σ�int arr[] = {4, 6, 8, 5, 9}; => adjustHeap(i=1) => �õ� {4, 9, 8, 5, 6}
     * eg����һ�Σ�int arr[] = {4, 9, 8, 5, 6}; => adjustHeap(i=0) => �õ� {9, 6, 8, 5, 4}
     *
     * @param arr    ������������
     * @param i      ���Ҷ�ӽڵ��������е�����
     * @param length ��Զ��ٸ�Ԫ�ؽ��е�����length���𽥼��٣���Ϊ�������õ������ˣ�
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        // ��ȡ����ǰԪ�ص�ֵ����������ʱ������
        int temp = arr[i];

        // ��ʼ����
        // �ʣ�k = 2*i+1; ��ʾ k �� i�ڵ�����ӽڵ�
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {// k=2*k+1 ,k ���ӽڵ�����ӽڵ�
            if (k + 1 < length && arr[k] < arr[k + 1]) {// ˵�����ӽڵ��ֵ��С�����ӽڵ��ֵ
                k++;// k ָ�����ӽڵ�
            }
            if (arr[k] > temp) {// ���ӽڵ���ڸ��ڵ��ֵ
                arr[i] = arr[k]; // �ѽϴ��ֵ��ֵ����ǰ�ڵ�
                i = k;// ָ�� k,�����Ƚ�(�ƶ�)
            } else {
                break;
            }
        }
        // ��for ѭ��������,�Ѿ����� i Ϊ���ڵ���������ֵ���������(�ֲ�)
        arr[i] = temp;// �� temp�ŵ��������λ��
    }
}
