//package JavaBook.chap13;
////定义一个person类，
//// 其中定义了两个成员变量，一个带有两个参数的构造方法和两个方法，
//// 然后在主类App13_2中通过反射来获取Person类的构造方法、成员变量和成员方法等信息。
//
//import java.lang.reflect.Constructor;
//
//class Person {
//    private String name;
//    private int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public void info(String prof, int score) {
//        System.out.println("my major: " + prof + "; score: " + score);
//    }
//
//    @Override
//    public String toString() {
//        return "name: " + this.name + ", age: " + this.age;
//    }
//}
//
//public class App13_2 {
//    public static void main(String[] args) {
//        Class<Person> pc = Person.class;
//        Constructor con = pc.getConstructor(String.class, int.class);
//        System.out.println("Constructor: " + con.getName());
//        Class[] pt = con.getParameterTypes();
//        for (int i = 0; i < pt.length; i++) {
//            System.out.println(", params: " + pt[i].getName());
//        }
//    }
//}
