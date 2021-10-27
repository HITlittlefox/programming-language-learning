package test;

public class Person {
	String name;
	int age;
	static String country = "A城"; // 改为static类型

	public Person(String n, int a) {
		name = n;
		age = a;
	}

	public String getInfo() {
		return name + age + country;
	}

	public static void main(String args[]) {
		Person per1 = new Person("张三", 20);
		Person per2 = new Person("李四", 21);
		Person per3 = new Person("王五", 22);
		System.out.println(per1.getInfo());
		System.out.println(per2.getInfo());
		System.out.println(per3.getInfo());
		System.out.println("---------------------");
		per1.country = "B城";
		System.out.println(per1.getInfo());
		System.out.println(per2.getInfo());
		System.out.println(per3.getInfo());

	}
}
