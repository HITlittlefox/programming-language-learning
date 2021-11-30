package JavaBook.chap12;

//����ͨ�����������ʹ�÷���
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

    //����ķ������յķ������������е����Ͳ���ֻ����GeneralTypeʵ��������String��String������
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

        //ʵ����String��T�Ķ���
        GeneralType<String> n = new GeneralType<>();
        //��ֵobj
        n.setObj("fox");
        //n is String, so n can activate showObj()
        GeneralType.showObj(n);

        //and n can also getObj
        System.out.println("value type = " + n.getObj());

        //ʵ����Double��T�Ķ���
        GeneralType<Double> num = new GeneralType<>();
        num.setObj(25.0);
        //num is not String, so num can not activate showObj()
        System.out.println("value type = " + num.getObj());

    }
}
