package JavaBook.chap12;

//定义一个泛型类，并在该类中利用类型参数声明数组
public class App12_6<T> {

    //用类型参数T声明数组，即定义泛型数组
    private T[] array;

    //方法的参数接收的数组 是 类型参数T的类型
    public void setT(T[] array) {
        this.array = array;
    }

    public T[] getT() {
        return array;
    }

    public void showArray(T[] array) {
        for (T t : array) {
            System.out.println(t + " ");
        }
    }

    public static void main(String[] args) {

        App12_6<String> a = new App12_6<String>();
        String[] array = {"Red", "Yellow", "Green"};
        a.setT(array);
        a.showArray(array);
//        for (int i = 0; i < a.getT().length; i++) {
//            System.out.println(a.getT()[i] + " ");
//        }

    }
}
