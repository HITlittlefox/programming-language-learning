public class CompressMatrix{
	public static void add(int a[],int b[],int c[],int n){
		int i;
		for(i=0;i<=n*(n+1)/2-1;i++){
			c[i]=b[i]+c[i];
		}
	}
	
	public static void print(int a[],int n){
		int i,j,k;
		for(i=1;i<=n;i++){
			for(j=1;j<=n;j++){
				if(i>=j){
					k=i*(i-1)/2+j-1;
				}
				else {
					k=j*(j-1)/2+i-1;
				}
				System.out.print(a[k]+"  ");
			}
			System.out.println();
		}
	}
	
	
	//5-14
	public static void product(int a[],int b[],int c[],int n){
		int i,j,k,v,p,q,sum;
		for(i=1;i<=n;i++){
			for(j=i;j<=n;j++){
				if(i>=j){
					v=i*(i-1)/2+j-1;
					sum=0;
					for(k=1;k<=n;k++){
						if(i>=k) p=i*(i-1)/2+k-1;
						else p=k*(k-1)/2+i-1;
						
						if(j>=k) q=j*(j-1)/2+k-1;
						else q=k*(k-1)/2+j-1;
						
						sum=sum+a[p]*b[q];
					}
					c[v]=sum;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int a[]={1,2,3,4,5,6},b[]={10,20,40,30,50,60};
		int c[]=new int[6];
		int n=3;
		add(a,b,c,n);
		print(c,n);
		
		product(a,b,c,n);
		print(c,n);
	}
}