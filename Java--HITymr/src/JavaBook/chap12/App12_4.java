package JavaBook.chap12;

//�����Ƶķ�����
class GeneralType1<T extends Number> {
    T obj;

    //���췽��
    public GeneralType1(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}

public class App12_4 {
    public static void main(String[] args) {
        //ʵ����Integer��T�Ķ������޲ι��췽����obj=5
        GeneralType1<Integer> num = new GeneralType1<>(666);
        System.out.println("given params: " + num.getObj());
//        not support
//        GeneralType<String> s =new GeneralType<String>("Hello");
//        System.out.println("given params: " + num.getObj());
    }
}
