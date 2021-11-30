package chap5.myvector;
public class TestMatrix{
	public static void main(String[] args){
		Matrix mt = new Matrix(3,4);
		for(int i = 0;i < mt.height(); i++){
			for(int j = 0;j < mt.width();j ++){
				mt.set(i,j,new Integer(i+j));
			}			
		}
		
		Matrix mt1 = new Matrix(3,4);
		for(int i = 0;i < mt1.height(); i++){
			for(int j = 0;j < mt1.width();j ++){						
				mt1.set(i,j,new Integer((int)(Math.random() * 10)));
			}			
		}
		
		System.out.println("Matrix 1:");
		mt.print();
		System.out.println("Matrix 2:");
		mt1.print();
		Matrix mt2 = mt1.matrixAdd(mt);
		System.out.println("add result:");
		mt2.print();
		
//		System.out.println("removed col is "+mt.removeCol(1));
		System.out.println("after removed col 1 Matrix 1:");
		mt.removeCol(1);
		mt.print();
//		System.out.println("sfter removed row 1  Matrix 1:"+mt.removeRow(1));
		System.out.println("sfter removed row 1  Matrix 1:");
		mt.removeRow(1);
		mt.print();
	}
}