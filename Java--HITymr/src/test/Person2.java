package test;

public class Person2 {
    String name;
    int age;

    public Person2() {
        System.out.println("空构造方法");
    }

    public Person2(String n, int a) {// 出入参数，方法重载
        System.out.println("重载构造方法");
        this.name = n;
        this.age = a;
    }

    public String getInfo() {// 方法
        return "姓名：" + name + "，年龄：" + age;
    }

    public void tell() {// 表示一个功能，说话
        System.out.println("姓名：" + name + "，年龄：" + age);
    }

    public static void main(String args[]) {
        // Person2 per = new Person2(); // 产生对象
        // per.name = "张三"; // 设置name属性的内容
        // per.age = 30; // 设置age属性的内容
        // per.tell(); // 调用方法输出
        Person2 per = new Person2("张三", 20);
        System.out.println(per.getInfo());
        // int[] arr = { 1, 2, 3, 4, 5 };
        // for (int i : arr)
        // System.out.println(i);

    }

}
