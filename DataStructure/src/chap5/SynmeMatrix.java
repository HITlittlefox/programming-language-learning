package chap5;
public class SynmeMatrix {
	double a[];
	int n;
	int m;
	
	SynmeMatrix(int n){
		m = n * (n + 1) / 2;
		a = new double[m];
		this.n = n;
	}
	
	public void evaluateMatrix(double[][] b){
		int k = 0;
		int i, j;
		for(i = 0; i < n; i ++)
			for(j = 0; j < n; j ++)
				if(i >= j) a[k++] = b[i][j];
	}
	
	public void evaluateMatrix(double[] b){
		for(int k = 0; k < m; k ++)
			a[k] = b[k];
	}
	
	public SynmeMatrix add(SynmeMatrix myB){
		SynmeMatrix t = new SynmeMatrix(n);
		int i, j, k;
		for(i = 1; i <= n; i ++){
			for(j =1; j <= n; j++){
				if(i >= j)
					k = i * (i - 1) / 2 + j - 1;
				else
					k = j * (j - 1) / 2 + i - 1;
				t.a[k] = a[k] + myB.a[k];
			}
		}
		return t;
	}
	
	public void print(){
		int i, j, k;
		for(i = 1; i <= n; i ++){
			for(j =1; j <= n; j++){
				if(i >= j)
					k = i * (i - 1) / 2 + j - 1;
				else
					k = j * (j - 1) / 2 + i - 1;
				System.out.print("     " + a[k]);
			}
			System.out.println();
		}
	}
}