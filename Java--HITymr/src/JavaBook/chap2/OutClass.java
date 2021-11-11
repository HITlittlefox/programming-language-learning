package JavaBook.chap2;

class OuterClass {


    public void foo() {

        InnerClass innerClass = new InnerClass();

        StaticInnerClass staticInnerClass = new StaticInnerClass();

    }

    public class InnerClass {

    }

    public static class StaticInnerClass {

    }

    public static void main(String[] args) {

        OuterClass outerClass = new OuterClass();

        //OuterClass类的内部类InnerClass
        InnerClass innerClass = outerClass.new InnerClass();
//        InnerClass innerClass = new InnerClass();


        StaticInnerClass staticInnerClass = new StaticInnerClass();

    }
}
