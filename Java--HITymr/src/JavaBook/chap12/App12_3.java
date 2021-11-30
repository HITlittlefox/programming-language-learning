package JavaBook.chap12;

//在泛型类中定义泛型方法，分别输出泛型类的类型参数和泛型方法的类型参数所属的类。
//说明类的类型参数与泛型方法的类型参数是不同的。

//泛型类
class GenMet<T> {
    //泛型变量
    private T t;

    //泛型类的方法
    public void setObj(T t) {
        this.t = t;
    }

    //泛型类的方法
    public T getT() {
        return t;
    }

    //泛型方法
    public <U> void display(U u) {
        //打印类的类型参数T的类型
        System.out.println("Generic class T: " + t.getClass().getName());
        //打印泛型方法的参数U的类型
        System.out.println("Generic method U: " + u.getClass().getName());
        System.out.println("t: " + t);
        System.out.println("u: " + u);
    }
}

public class App12_3 {
    public static void main(String[] args) {
        //实例化一个Integer的T的对象
        GenMet<Integer> gen = new GenMet<>();
        //把T赋值为5
        gen.setObj(5);
        //获得T值
        System.out.println("gen.getT()" + gen.getT());

//---
        System.out.println("first output: ");
        //调用泛型方法，接收字符串型的量
        //没有显式的传入实参的类型，java编译器会类型参数推断。
        gen.display("I'm the text");
//        System.out.println("second output: ");
//        //调用泛型方法，接收Double型的量
//        gen.display(8.0);


//        //Java三元表达式有字符强转的功能，返回值类型为两个返回值中类型精度更高的那个类型。
//        int x = 2;
//        double y = (x < 1) ? 2.2 : 2;
//        System.out.println("value is " + y);
    }
}

