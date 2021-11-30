package chap5;
public class SeqSynmeMatrix extends SeqList{
	int n;
	
	SeqSynmeMatrix(){
		super();
	}
	SeqSynmeMatrix(int max){
		super(max);
	}
	
	public void createMatrix(int nn, Object[] item) throws Exception{
		n = nn;
		int k = 0;
		
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < n; j ++){
				if(i >= j){
				insert(k, item[i * n + j]);
				k ++;
				}
			}
		}
	}
	
	public void add(SeqSynmeMatrix a){
		for(int i = 0; i < size; i ++){
			int temp = ((Integer)listArray[i]).intValue() + ((Integer)a.listArray[i]).intValue();
			listArray[i] = new Integer(temp);
		}
	}
	
	public void print(){
		System.out.println("对称矩阵阶数为："+n);
		System.out.println("矩阵元素为：");
		
		int k = 0;
		for(int i = 1; i <= n; i ++){
			for(int j =1; j <= n; j++){
				if(i >= j){
					k = i * (i - 1) / 2 + j - 1;
					System.out.print("     " + listArray[k]);
				}
				else{
					k = j * (j - 1) / 2 + i - 1;
					System.out.print("     " + listArray[k]);
				}
			}
			System.out.println();
		}
	}
}