public class Exec69{
	int maxsize=10;
	int a[]=new int[maxsize];
	
	Exec69(){
		for(int i=0;i<a.length;i++){
			a[i]=(int)(Math.random()*10);			
			System.out.print(a[i]+" ");
			
		}
	}
	
	public  int sum(int a[],int n){
		if(n==1) return a[n-1];
		else return a[n-1]+sum(a,n-1);
	}
	
	
	//6-11
	public int max(int a[],int n){
		int x;
		if(n<=0) return -1;
		if(n==1) return a[n-1];
		else{
			x=max(a,n-1);
			if(x>a[n-1]) return x;
			else return a[n-1];
		}
	}
	
	//9-16
	public void selesort2(int a[]){
		int i,j,k;
		int temp;
		int n=a.length;
		
		for(i = 0; i < n-1; i++){
			k = i;
			for(j = i+1; j < n; j++){
				if(a[j] < a[k]) k = j;
			}
			
			if(k != i){
				temp = a[k];
				for(j = k; j > i; j--)
					a[j] = a[j-1];
				a[i] = temp;
			}
		}
	}
	
	public static void main(String[] args){
		Exec69 e=new Exec69();
		System.out.println();
		System.out.println("sum= "+e.sum(e.a,e.maxsize));
		System.out.println("max= "+e.max(e.a,e.maxsize));
		e.selesort2(e.a);
		for(int i=0;i<e.maxsize;i++){
			System.out.print(e.a[i]+" ");
		}
	}
}