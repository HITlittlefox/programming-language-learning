package JavaBook.chap12;

//泛型类的应用
//filename:App12_1.java          泛型类的应用
public class App12_1<T>         //定义泛型类，T是类型参数
{
    private T obj;            //定义泛型类的成员变量

    public T getObj()         //定义泛型类的方法getObj()
    {
        return obj;
    }

    public void setObj(T obj)   //定义泛型类的方法setObj()
    {
        this.obj = obj;
    }

    public static void main(String[] args) {

        //泛型实例化
        App12_1<String> name = new App12_1<>();  //创建App12_1<String>型对象
        App12_1<Integer> age = new App12_1<>();  //创建App12_1<Integer>型对象

        //泛型类的实例化对象name 调用 泛型方法setObj()
        name.setObj("Zhang San");
        //newName是String的实例化对象，把泛型对象调用getObj()的值给newName
        String newName = name.getObj();
        System.out.println("newName: " + newName);


        age.setObj(25);                //Java自动将25包装为new Integer(25)
        int newAge = age.getObj();       //Java将Integer类型自动解包成int类型
        System.out.println("newAge: " + newAge);
    }
}
