package JavaBook.chap12;

//类型通配符“？”的使用方法
//class GeneralType<T>{
class GeneralType<T> {
    //T obj;
    T obj;

    //public void setObj(T obj){this.obj=obj;}
    public void setObj(T obj) {
        this.obj = obj;
    }

    //public T getObj(){return obj;}
    public T getObj() {
        return obj;
    }

    //下面的方法接收的泛型类对象参数中的类型参数只能是GeneralType实例出来的String或String的子类
    //public static void showObj(GeneralType<? extends String> o){
    public static void showObj(GeneralType<? extends String> o) {
        //System.out.println("given value is = " + o.getObj());
        System.out.println("given value is = " + o.getObj());
        //}
    }
    //}
}

public class App12_5 {
    public static void main(String[] args) {

        //实例化String的T的对象
        GeneralType<String> n = new GeneralType<>();
        //赋值obj
        n.setObj("fox");
        //n is String, so n can activate showObj()
        GeneralType.showObj(n);

        //and n can also getObj
        System.out.println("value type = " + n.getObj());

        //实例化Double的T的对象
        GeneralType<Double> num = new GeneralType<>();
        num.setObj(25.0);
        //num is not String, so num can not activate showObj()
        System.out.println("value type = " + num.getObj());

    }
}
