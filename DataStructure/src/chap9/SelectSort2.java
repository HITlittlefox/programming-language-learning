package chap9;

public class SelectSort2{
public static void selectSort2(int a[]){
	int i,j,small;
	int temp;
	int n = a.length;

	for(i = 0; i < n-1; i++){
		small = i;
		for(j = i+1; j < n; j++){				//Ѱ����С������Ԫ��
			if(a[j] < a[small]) small = j; 		//��ס��СԪ�ص��±�
		}

		if(small != i){
			temp = a[small];
			for(j = small; j > i; j--) 			//�Ѹ�������δ����Ԫ�����κ���
				a[j] = a[j-1];
			a[i] = temp;						//�����ҳ�����СԪ��
		}
	}
}

	public static void main(String[] args){
		int[] test = {64,5,7,89,6,24, 5};
		int n = test.length;

		selectSort2(test);

		for(int i = 0; i < n; i++)
			System.out.print(test[i] + "  ");
	}
}
