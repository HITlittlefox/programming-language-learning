package chap9;

public class SelectSort2{
public static void selectSort2(int a[]){
	int i,j,small;
	int temp;
	int n = a.length;

	for(i = 0; i < n-1; i++){
		small = i;
		for(j = i+1; j < n; j++){				//寻找最小的数据元素
			if(a[j] < a[small]) small = j; 		//记住最小元素的下标
		}

		if(small != i){
			temp = a[small];
			for(j = small; j > i; j--) 			//把该区段尚未排序元素依次后移
				a[j] = a[j-1];
			a[i] = temp;						//插入找出的最小元素
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
