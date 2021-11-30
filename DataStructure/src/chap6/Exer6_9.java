package chap6;
public class Exer6_9{
public static int sum(int a[],int n){
	if(n==1) return a[n-1];
	else return a[n-1] + sum(a,n-1);
}

	public static void main(String[] args){
		int[] a = {1, 3, 4, 33, 5, 17, 18, 31};
		int x = 17;
		int bn;
		
		bn = sum(a, 8);
		System.out.println(bn);		
	}
}