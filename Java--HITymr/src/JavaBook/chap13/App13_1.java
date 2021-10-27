package JavaBook.chap13;

public class App13_1 {
    public String name;
    public int age;

    @Deprecated
    public void show(String name) {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "name: " + name + " age: " + age;
    }

    public static void main(String[] args) {
        App13_1 p = new App13_1();
        p.show("zhang san");
    }
}
