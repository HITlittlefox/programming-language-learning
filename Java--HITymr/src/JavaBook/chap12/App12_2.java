package JavaBook.chap12;

//泛型方法的应用
//filename App12_2.java
public class App12_2             //定义一般类，即非泛型类
{
    //该方法的参数接收的是E类型的数组，而方法体则是输出参数list接收的数组的每个参数
    public static <E> void display(E[] list)  //定义泛型方法，E为类型参数
    {
        for (E e : list) {
            System.out.print(e + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] num = {1, 2, 3, 4, 5};                     //定义数组
        String[] str = {"red", "Orange", "Yellow", "Green", "Cyanogen", "Blue", "Purple"};
        App12_2.display(num);    //调用泛型方法
        App12_2.display(str);
    }

}
