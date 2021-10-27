package chap10;


class StaticSuper {
    //先父类static，后子类static
    static {
        System.out.println("super static block");
    }


    StaticSuper() {
        System.out.println("super constructor");
    }
}

public class StaticTests extends StaticSuper {
    static int rand;

    static {
        rand = (int) (Math.random() * 6);
        System.out.println("static block " + rand);
    }

    StaticTests() {
        System.out.println("constructor");

    }

    //在这里启动！
    public static void main(String[] args) {
        System.out.println("in main");
        //在调用子类方法前，会先去把父类无参构造函数走一遍，但是static优先级比无参构造函数更高。所以先去第6行，又因为父类比子类优先级高，所以先父类static，后子类static，再父类无参构造函数，再子类无参构造函数。
        StaticTests st = new StaticTests();
    }
}
