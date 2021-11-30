package chap6;
public class Exer6_11{
	public static int max(int a[], int n){
	int x;
	if(n <= 0) return -1;
	if(n == 1) return a[n-1];
	else{
		x = max(a, n-1);
		if(x > a[n-1]) return x;
		else return a[n-1];
	}
}

	public static void main(String[] args){
		int[] a = {1, 3, 4, 33, 5, 17, 18, 31};
		int x = 17;
		int bn;
		
		bn = max(a, 8);
		System.out.println(bn);		
	}
}