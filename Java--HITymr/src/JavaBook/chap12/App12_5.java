package JavaBook.chap12;

//����ͨ�����������ʹ�÷���
class GeneralType<T> {
    T obj;

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    //����ķ������յķ������������е����Ͳ���ֻ����String��String������
    public static void showObj(GeneralType<? extends String> o) {
        System.out.println("given value is = " + o.getObj());
    }
}

public class App12_5 {
    public static void main(String[] args) {


        GeneralType<String> n = new GeneralType<>();
        n.setObj("fox");
        //n is String, so n can activate showObj()
        GeneralType.showObj(n);


        GeneralType<Double> num = new GeneralType<>();
        num.setObj(25.0);
        //num is not String, so num can not  activate showObj()
        System.out.println("value type = " + num.getObj());

    }
}
