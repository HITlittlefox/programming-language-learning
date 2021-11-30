package chap5;
public class Exam5_3{
	
	public static void main(String[] args){
		SeqSynmeMatrix matrixA = new SeqSynmeMatrix(10);
		SeqSynmeMatrix matrixB = new SeqSynmeMatrix(10);
		Object[] oa = new Object[9];
		Object[] ob = new Object[9];
		int[] a = {1, 4, 7, 4, 5, 8, 7, 8, 9};
		int[] b = {2, 4, 3, 4, 5, 6, 3, 6, 9}; 
		int n = 3;
		
		for(int i = 0; i < 9; i ++){
			oa[i] = new Integer(a[i]);
			ob[i] = new Integer(b[i]);
		}
		try{
			matrixA.createMatrix(n,oa);
			matrixA.print();
			matrixB.createMatrix(n,ob);
			matrixB.print();
			matrixA.add(matrixB);
			matrixA.print();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}