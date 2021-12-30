package chap9;

public class BubbleSort{
	public static void bubbleSort(int[] a){
		int i, j, flag=1;
		int temp;
		int n = a.length;

		for(i = 1; i < n && flag == 1; i++){
			flag = 0;
			for(j = 0; j < n-i; j++){
				if(a[j] > a[j+1]){
					flag = 1;
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

	public static void main(String[] args){
		int[] test = {64,5,7,89,6,24};
		int n = test.length;

		bubbleSort(test);
		for(int i = 0; i < n; i++)
			System.out.print(test[i] + "  ");
	}
}
