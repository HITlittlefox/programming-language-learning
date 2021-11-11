package JavaBook.chap12;

//有限制的泛型类
class GeneralType1<T extends Number> {
    T obj;

    //构造方法
    public GeneralType1(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}

public class App12_4 {
    public static void main(String[] args) {
        //实例化Integer的T的对象，走无参构造方法，obj=5
        GeneralType1<Integer> num = new GeneralType1<>(666);
        System.out.println("given params: " + num.getObj());
//        not support
//        GeneralType<String> s =new GeneralType<String>("Hello");
//        System.out.println("given params: " + num.getObj());
    }
}
