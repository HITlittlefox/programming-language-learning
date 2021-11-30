package chap5;

public class Exam5_4 {
	public static void main(String[] args) {
		SynmeMatrix matrixA = new SynmeMatrix(3);
		SynmeMatrix matrixB = new SynmeMatrix(3);
		SynmeMatrix matrixC;

		double[][] a = { { 1, 2, 3 }, { 2, 3, 4 }, { 4, 5, 6 } };
		double[] b = { 1, 2, 3, 4, 5, 6 };

		matrixA.evaluateMatrix(a);
		matrixB.evaluateMatrix(b);

		System.out.println("matrixA矩阵为");
		matrixA.print();
		System.out.println("matrixB矩阵为");
		matrixB.print();
		matrixC = matrixA.add(matrixB);
		System.out.println("matrixC矩阵为");
		matrixC.print();
	}
}