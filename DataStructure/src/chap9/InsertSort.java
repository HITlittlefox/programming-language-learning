package chap9;


//��������
//�㷨˼�룺
//1. ˳��İѴ����������Ԫ�ذ���ֵ�Ĵ�С���뵽����������Ԫ���Ӽ��ϵ��ʵ�λ�á�
//2. �Ӽ��ϵ�����Ԫ�ظ�����1����
//3. ���Ӽ��ϴ�С�뼯�ϴ�С��ͬʱ���������
public class InsertSort {
    public static void insertSort(int[] arr) {
        int i, j, temp;
        int n = arr.length;

        for (i = 0; i < n - 1; i++) {
            //temp�������Ԫ��
            temp = arr[i + 1];

            j = i;
            //���������,��û���ҵ�����λ��
            while (j > -1 && temp <= arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }


    public static void main(String[] args) {
        int[] test = {64, 5, 7, 89, 6, 24};
        int n = test.length;
//        InsertSortSpeedTest();
		insertSort(test);
		for(int i = 0; i < n; i ++)
			System.out.print(test[i] + "  ");
    }
}
