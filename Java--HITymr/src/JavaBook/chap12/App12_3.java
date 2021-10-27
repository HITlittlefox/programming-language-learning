package JavaBook.chap12;

//�ڷ������ж��巺�ͷ������ֱ��������������Ͳ����ͷ��ͷ��������Ͳ����������ࡣ
//˵��������Ͳ����뷺�ͷ��������Ͳ����ǲ�ͬ�ġ�

//������
class GenMet<T> {
    //���ͱ���
    private T t;

    //    //������ķ���
//    public T getObj() {
//        return t;
//    }
    //������ķ���
    public void setObj(T t) {
        this.t = t;
    }

    //���ͷ���
    public <U> void display(U u) {
        //��ӡ������Ͳ���T������
        System.out.println("Generic class T: " + t.getClass().getName());
        //��ӡ���ͷ����Ĳ���U������
        System.out.println("Generic method U: " + u.getClass().getName());
        System.out.println("t: " + t);
        System.out.println("u: " + u);
    }
}

public class App12_3 {
    public static void main(String[] args) {
        GenMet<Integer> gen = new GenMet<Integer>();
        gen.setObj(5);
        System.out.println("first output: ");
        //���÷��ͷ����������ַ����͵���
        //û����ʽ�Ĵ���ʵ�ε����ͣ�java�����������Ͳ����ƶϡ�
        gen.display("I'm the text");
//        System.out.println("second output: ");
//        //���÷��ͷ���������Double�͵���
//        gen.display(8.0);
    }
}
