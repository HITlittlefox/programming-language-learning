//package JavaBook.chap13;
////����һ��person�࣬
//// ���ж�����������Ա������һ���������������Ĺ��췽��������������
//// Ȼ��������App13_2��ͨ����������ȡPerson��Ĺ��췽������Ա�����ͳ�Ա��������Ϣ��
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
