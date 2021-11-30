package chap5;

public class TestMySet {
	public static void main(String[] args) {
		MySet os1 = new MySet();
		MySet os2 = new MySet();
		MySet os3 = new MySet();

		os1.add(new Integer(0));
		os1.add(new Integer(2));
		os1.add(new Integer(5));

		os2.add(new Integer(5));
		os2.add(new Integer(0));
		os2.add(new Integer(2));
		os2.add(new Integer(5)); // 测试重复添加的情况

		os3.add(new Integer(7));
		os3.remove(new Integer(7));

		System.out.print("Set of os1 is: { ");
		MyIterator it1 = os1.iterator();
		while (it1.hasNext()) {
			System.out.print(it1.next() + "  ");
		}
		System.out.println("}");

		System.out.print("Set of os2 is: { ");
		MyIterator it2 = os2.iterator();
		while (it2.hasNext()) {
			System.out.print(it2.next() + "  ");
		}
		System.out.println("}");

		System.out.print("Set of os3 is: { ");
		MyIterator it3 = os3.iterator();
		while (it3.hasNext()) {
			System.out.print(it3.next() + "  ");
		}
		System.out.println("}");

		if (os1.include(os3))
			System.out.println("os1 including os3");
		else
			System.out.println("os1 does not including os3");

		if (os1.include(os2))
			System.out.println("os1 including os2");
		else
			System.out.println("os1 does not including os2");

		if (os1.eqauls(os2))
			System.out.println("os1 is eqaul with os2");
		else
			System.out.println("os1 is not eqaul with os2");
	}
}
