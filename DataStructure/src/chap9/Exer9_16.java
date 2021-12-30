//package chap9;
//
//public class Exer9_16{
//public static void selectSort2(int a[]){
//	int i,j,k;
//	int temp;
//	int n=a.length;
//
//	for(i = 0; i < n-1; i++){
//		k = i;
//		for(j = i+1; j < n; j++){
//			if(a[j] < a[k]) k = j;
//		}
//
//		if(k != i){
//			temp = a[k];
//			for(j = k; j > i; j--) a[j] = a[j-1];
//			a[i] = temp;
//		}
//	}
//}
//
//	public static void main(String[] args){
//		int[] test = {64,5,7,89,6,24, 5};
//		int n = test.length;
//
//		selectSort2(test);
//
//		for(int i = 0; i < n; i++)
//			System.out.print(test[i] + "  ");
//	}
//}
