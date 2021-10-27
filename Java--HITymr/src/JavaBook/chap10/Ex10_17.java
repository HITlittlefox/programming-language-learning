package JavaBook.chap10;

//����һ����Ա�࣬�������������䡣����������8���ַ���������int���͡�ÿ����¼�̶�Ϊ20���ֽڡ�ʹ��RandomAccessFile���ļ���ӡ��޸ġ���ȡ��Ա��Ϣ

import java.io.RandomAccessFile;
import java.util.Arrays;

//����һ����Ա�࣬�������������䡣
class Employee {
    char[] name = {'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
    int age;

    public Employee(String name, int age) throws Exception {
        if (name.toCharArray().length > 8) {
            System.arraycopy(name.toCharArray(), 0, this.name, 0, 8);
        } else
            System.arraycopy(name.toCharArray(), 0, this.name,
                    0, name.toCharArray().length);
        this.age = age;
    }
}

public class Ex10_17 {
    String Filename;


    public Ex10_17(String Filename) {
        this.Filename = Filename;
    }

    //ʹ��RandomAccessFile���ļ���ӹ�Ա��Ϣ
    public void writeEmployee(Employee e, int n) throws Exception {
        RandomAccessFile ra = new RandomAccessFile(Filename, "rw");
        ra.seek(n * 20L); //��λ��ָʾ���Ƶ�ָ��λ����

        //���Ƴ���
        for (int I = 0; I < 8; I++)
            ra.writeChar(e.name[I]);

        ra.writeInt(e.age);
        ra.close();
    }

    //ʹ��RandomAccessFile���ļ���ȡ��Ա��Ϣ
    public void readEmployee(int n) throws Exception {
        char[] buf = new char[8];
        RandomAccessFile ra = new RandomAccessFile(Filename, "r");
        ra.seek(n * 20L);

        //���Ƴ���
        for (int I = 0; I < 8; I++)
            buf[I] = ra.readChar();

        System.out.print("name:" + Arrays.toString(buf));
        System.out.println("age:" + ra.readInt());
        ra.close();
    }

    public static void main(String[] args) throws Exception {
        Ex10_17 t = new Ex10_17("employee.txt");

        //��������Ա����
        Employee e1 = new Employee("ZhangSantt", 23);
        Employee e2 = new Employee("littlefox", 33);
        Employee e3 = new Employee("wang hua", 19);

        //���д��
        t.writeEmployee(e1, 0);
        t.writeEmployee(e3, 2);
        t.writeEmployee(e2, 1);

        //�����ȡ
        System.out.println("first employee");
        t.readEmployee(0);

        System.out.println("third employee");
        t.readEmployee(2);


        System.out.println("second employee");
        t.readEmployee(1);
    }
}

