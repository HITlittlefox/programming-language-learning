package chap5;
public class TestSpaMatrix{
	public static void main(String[] args){
		SpaMatrix matrixA = new SpaMatrix(10);
		SpaMatrix matrixB;
		
		Three[] a = new Three[6];
		a[0] = new Three(1, 3, 11.0);
		a[1] = new Three(1, 5, 17.0);
		a[2] = new Three(2, 2, 25.0);
		a[3] = new Three(4, 1, 19.0);
		a[4] = new Three(5, 4, 37.0);
		a[5] = new Three(6, 7, 50.0);
		
		try{
			matrixA.evaluate(6, 7, 6, a);
			System.out.println("原矩阵：");
			matrixA.print();
			
			System.out.println("转置后的矩阵：");
			matrixB = matrixA.transpose();
			matrixB.print();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}