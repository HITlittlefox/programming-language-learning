package JavaBook.chap12;

//����һ�������࣬���ڸ������������Ͳ�����������
public class App12_6<T> {

    //�����Ͳ���T�������飬�����巺������
    private T[] array;

    //�����Ĳ������յ����� �� ���Ͳ���T������
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
