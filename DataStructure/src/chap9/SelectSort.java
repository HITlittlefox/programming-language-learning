package chap9;

public class SelectSort{
public static void selectSort(int[] a){
	int i, j, small;
	int temp;
	int n = a.length;

	for(i = 0; i < n - 1; i ++){
		small = i; 							//设第i个数据元素最小
		for(j = i + 1; j < n; j ++)				//寻找最小的数据元素
			if(a[j] < a[small]) small = j; 		//记住最小元素的下标

		if(small != i){ 				//当最小元素的下标不为i时交换位置
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
