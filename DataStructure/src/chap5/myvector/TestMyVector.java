package chap5.myvector;

public class TestMyVector {
	public static void main(String[] args) {
		int i;
		Integer t;
		MyVector mv = new MyVector(10);
		for (i = 0; i < 10; i++)
			mv.add(new Integer(i + 1));

		mv.add(new Integer(11));

		System.out.println("size = " + mv.size());
		for (i = 0; i < mv.size(); i++) {
			t = (Integer) mv.get(i);
			System.out.print(t + "   ");
		}
	}
}