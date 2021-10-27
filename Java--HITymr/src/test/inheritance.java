package test;

class Person4 {
    private String name;
    private int age;

    public Person4(String name, int age) {
        System.out.println("** 父类的有参构造！");
    }
}

class Student extends Person4 { //
    private String school; // 扩充的属性

    public Student(String name, int age, String school) {
        super(name, age); // 调用父类中的构造
        System.out.println("** 子类的无参构造！");
    }
}

public class inheritance {
    public static void main(String args[]) {
        Student stu = new Student("张三", 30, "清华");
    }
}
