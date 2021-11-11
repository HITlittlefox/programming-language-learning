package JavaBook.chap12;

//�������Ӧ��
//filename:App12_1.java          �������Ӧ��
public class App12_1<T>         //���巺���࣬T�����Ͳ���
{
    private T obj;            //���巺����ĳ�Ա����

    public T getObj()         //���巺����ķ���getObj()
    {
        return obj;
    }

    public void setObj(T obj)   //���巺����ķ���setObj()
    {
        this.obj = obj;
    }

    public static void main(String[] args) {

        //����ʵ����
        App12_1<String> name = new App12_1<>();  //����App12_1<String>�Ͷ���
        App12_1<Integer> age = new App12_1<>();  //����App12_1<Integer>�Ͷ���

        //�������ʵ��������name ���� ���ͷ���setObj()
        name.setObj("Zhang San");
        //newName��String��ʵ�������󣬰ѷ��Ͷ������getObj()��ֵ��newName
        String newName = name.getObj();
        System.out.println("newName: " + newName);


        age.setObj(25);                //Java�Զ���25��װΪnew Integer(25)
        int newAge = age.getObj();       //Java��Integer�����Զ������int����
        System.out.println("newAge: " + newAge);
    }
}
