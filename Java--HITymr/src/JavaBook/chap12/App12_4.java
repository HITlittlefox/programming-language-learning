//package JavaBook.chap12;
//
////有限制的泛型类
//class GeneralType<T extends Number> {
//    T obj;
//
//    //构造方法
//    public GeneralType(T obj) {
//        this.obj = obj;
//    }
//
//    public T getObj() {
//        return obj;
//    }
//}
//
//public class App12_4 {
//    public static void main(String[] args) {
//        GeneralType<Integer> num = new GeneralType<Integer>(5);
//        System.out.println("given params: " + num.getObj());
////        not support
////        GeneralType<String> s =new GeneralType<String>("Hello");
////        System.out.println("given params: " + num.getObj());
//
//
//    }
//}
