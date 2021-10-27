package chap09;

public class MakeHippo {
    public static void main(String[] args) {
        Hippo h = new Hippo("Buffy");
        System.out.println(h.getName());
    }
}

abstract class Animal {
    private String name;

    public String getName() {
        return name;

    }

    public Animal(String theName) {
        name = theName;
    }
}

class Hippo extends Animal {
    public Hippo(String name) {
        super(name);//调用父类的方法
    }
}