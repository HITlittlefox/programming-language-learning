package chap9;

public class SelectSort{
public static void selectSort(int[] a){
	int i, j, small;
	int temp;
	int n = a.length;

	for(i = 0; i < n - 1; i ++){
		small = i; 							//���i������Ԫ����С
		for(j = i + 1; j < n; j ++)				//Ѱ����С������Ԫ��
			if(a[j] < a[small]) small = j; 		//��ס��СԪ�ص��±�

		if(small != i){ 				//����СԪ�ص��±겻Ϊiʱ����λ��
			temp = a[i];
			a[i] = a[small];
			a[small] = temp;
		}
	}
}
	public static void main(String[] args){
		int[] test = {64,5,7,89,6,24};
		int n = test.length;

		selectSort(test);
		for(int i = 0; i < n; i++)
			System.out.print(test[i] + "  ");
	}
}
