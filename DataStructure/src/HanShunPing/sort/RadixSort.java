package HanShunPing.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * title: ��������
 *
 * @author ��K
 * 2020��12��17�� ����12:02:16
 */
public class RadixSort {

    public static void main(String[] args) {

//      int arr[] = { 53, 3, 542, 748, 14, 214 };
//      radixSort2(arr);
//      System.out.println("��������� " + Arrays.toString(arr));

        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); // ����һ��[0, 8000000) ��
        }

        // new RadixSort(arr);
        // new MergeSort(arr);
        new QuickSort(arr);
    }

    public RadixSort(int arr[]) {
        long time = new Date().getTime();
        radixSort2(arr);
        long time2 = new Date().getTime();
        System.out.println("�������� ��" + (arr.length) + "�����ݣ�ʹ��" + (time2 - time) + "����");
    }

    // �������� Api
    public static void radixSort2(int[] arr) {
        // ����ǰ����Ƶ����̣����ǿ��Եõ����յĻ����������

        // �õ�����������������λ��
        int max = arr[0];// �ٶ���һ��Ϊ���
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // �õ��������λ��
        int maxLength = (max + "").length();

        // ����һ����ά�����ʾ 10 ��Ͱ��0-9����ÿ��Ͱ��һ��һά����
        // ��֪��
        // 1����ά�����а��� 10 ��һά����
        // 2��Ϊ��ֹ������ֵ��ʱ�������������ÿ��һά����(Ͱ) �Ĵ�С����Ϊ arr.length(Ҫ���������)
        // 3���� ��������Ϊ���͵Ŀռ任ʱ�� �㷨
        int[][] bucket = new int[10][arr.length];

        // Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʴ�����ݵĸ��������Ƕ�����һ����ά����������¼ÿ��Ͱ��ÿ�δ�����ݵĸ���
        // �ڼ���Ͱ bucketElementCounts[0] --- ��һ��
        int[] bucketElementCounts = new int[10];

        // ����ʹ��ѭ��������δ֪�����������봦��
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // ���ÿ��Ԫ�ض�Ӧ��λ�����д�����һ���Ǹ�λ���ڶ�����ʮλ������������λ.....
            for (int j = 0; j < arr.length; j++) {
                // ȡ��ÿ��Ԫ�ظ�λ����ֵ
                int digitOfElement = arr[j] / n % 10;
                // ���뵽��Ӧ��Ͱ��
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            // �������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�������飩
            int index = 0;
            // ����ÿһ��Ͱ������Ͱ�����飬���뵽ԭ������
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // ��Ͱ�������ݣ�����뵽ԭ������
                if (bucketElementCounts[k] != 0) {
                    // ѭ����Ͱ�ĵ� J ��Ԫ�أ��� �� j ��һά����
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // ȡ��Ԫ�ط���
                        arr[index++] = bucket[k][l];
                    }
                }
                // �� i+1 �ִ�����轫ÿ��Ͱ ��� bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
        }
    }

    // �������� ���� Api
    public static void radixSort1(int[] arr) {

        // ����һ����ά�����ʾ 10 ��Ͱ��0-9����ÿ��Ͱ��һ��һά����
        // ��֪��
        // 1����ά�����а��� 10 ��һά����
        // 2��Ϊ��ֹ������ֵ��ʱ�������������ÿ��һά����(Ͱ) �Ĵ�С����Ϊ arr.length(Ҫ���������)
        // 3���� ��������Ϊ���͵Ŀռ任ʱ�� �㷨
        int[][] bucket = new int[10][arr.length];

        // Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʴ�����ݵĸ��������Ƕ�����һ����ά����������¼ÿ��Ͱ��ÿ�δ�����ݵĸ���
        // �ڼ���Ͱ bucketElementCounts[0] --- ��һ��
        int[] bucketElementCounts = new int[10];

        // һ���������� ��һ��(���ÿ�����ĸ�λ��������)
        for (int i = 0; i < arr.length; i++) {
            // ȡ��ÿ��Ԫ�ظ�λ����ֵ
            int digitOfElement = arr[i] / 1 % 10;
            // ���뵽��Ӧ��Ͱ��
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        // �������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�������飩
        int index = 0;
        // ����ÿһ��Ͱ������Ͱ�����飬���뵽ԭ������
        for (int j = 0; j < bucketElementCounts.length; j++) {
            // ��Ͱ�������ݣ�����뵽ԭ������
            if (bucketElementCounts[j] != 0) {
                // ѭ����Ͱ�ĵ� J ��Ԫ�أ��� �� j ��һά����
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    // ȡ��Ԫ�ط���
                    arr[index++] = bucket[j][k];
                }
            }
            // ��һ�ִ�����轫ÿ��Ͱ ��� bucketElementCounts[j] = 0
            bucketElementCounts[j] = 0;
        }
        System.out.println("��1�֣��Ը�λ�������� arr =" + Arrays.toString(arr));

        // ������������ �ڶ���(���ÿ������ʮλ��������)
        for (int i = 0; i < arr.length; i++) {
            // ȡ��ÿ��Ԫ�ظ�λ����ֵ
            int digitOfElement = arr[i] / 1 / 10 % 10;// 748 / 10 => 74 % 10 => 4
            // ���뵽��Ӧ��Ͱ��
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        // �������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�������飩
        int index2 = 0;
        // ����ÿһ��Ͱ������Ͱ�����飬���뵽ԭ������
        for (int j = 0; j < bucketElementCounts.length; j++) {
            // ��Ͱ�������ݣ�����뵽ԭ������
            if (bucketElementCounts[j] != 0) {
                // ѭ����Ͱ�ĵ� J ��Ԫ�أ��� �� j ��һά����
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    // ȡ��Ԫ�ط���
                    arr[index2++] = bucket[j][k];
                }
            }
            // ��һ�ִ�����轫ÿ��Ͱ ��� bucketElementCounts[j] = 0
            bucketElementCounts[j] = 0;
        }
        System.out.println("��2�֣��Ը�λ�������� arr =" + Arrays.toString(arr));

        // ������������ ������(���ÿ�����İ�λ��������)
        for (int i = 0; i < arr.length; i++) {
            // ȡ��ÿ��Ԫ�ظ�λ����ֵ
            int digitOfElement = arr[i] / 1 / 10 / 10 % 10;// 748 / 10 /10 => 7 % 10 => 7
            // ���뵽��Ӧ��Ͱ��
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        // �������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�������飩
        int index3 = 0;
        // ����ÿһ��Ͱ������Ͱ�����飬���뵽ԭ������
        for (int j = 0; j < bucketElementCounts.length; j++) {
            // ��Ͱ�������ݣ�����뵽ԭ������
            if (bucketElementCounts[j] != 0) {
                // ѭ����Ͱ�ĵ� J ��Ԫ�أ��� �� j ��һά����
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    // ȡ��Ԫ�ط���
                    arr[index3++] = bucket[j][k];
                }
            }
            // ��һ�ִ�����轫ÿ��Ͱ ��� bucketElementCounts[j] = 0
            bucketElementCounts[j] = 0;
        }
        System.out.println("��3�֣��Ը�λ�������� arr =" + Arrays.toString(arr));

    }

}
