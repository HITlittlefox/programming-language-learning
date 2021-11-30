package chap6;
public class Fib{
	public static long fib(int n){
		if(n == 0 || n == 1) 
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}
	
	public static long fib2(int n){
		long oneBack, twoBack, current = 0;
		int i;
		
		if(n == 0 || n == 1)
			return n;
		else{
			oneBack = 1;
			twoBack = 0;
			for(i = 2; i <= n; i ++){
				current = oneBack + twoBack;
				twoBack = oneBack;
				oneBack = current;
			}
			return current;
		}
	}
	
	public static void main(String[] args){
		int n = 9;
		System.out.println("fib(n) = " + fib(n) + " fib1(n) = " + fib(n));
	}
}