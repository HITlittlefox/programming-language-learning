package JavaBook.chap10;

//创建一个雇员类，包括姓名、年龄。姓名不超过8个字符，年龄是int类型。每条记录固定为20个字节。使用RandomAccessFile向文件添加、修改、读取雇员信息

import java.io.RandomAccessFile;
import java.util.Arrays;

//创建一个雇员类，包括姓名、年龄。
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

    //使用RandomAccessFile向文件添加雇员信息
    public void writeEmployee(Employee e, int n) throws Exception {
        RandomAccessFile ra = new RandomAccessFile(Filename, "rw");
        ra.seek(n * 20L); //将位置指示器移到指定位置上

        //限制长度
        for (int I = 0; I < 8; I++)
            ra.writeChar(e.name[I]);

        ra.writeInt(e.age);
        ra.close();
    }

    //使用RandomAccessFile向文件读取雇员信息
    public void readEmployee(int n) throws Exception {
        char[] buf = new char[8];
        RandomAccessFile ra = new RandomAccessFile(Filename, "r");
        ra.seek(n * 20L);

        //限制长度
        for (int I = 0; I < 8; I++)
            buf[I] = ra.readChar();

        System.out.print("name:" + Arrays.toString(buf));
        System.out.println("age:" + ra.readInt());
        ra.close();
    }

    public static void main(String[] args) throws Exception {
        Ex10_17 t = new Ex10_17("employee.txt");

        //建三个雇员对象
        Employee e1 = new Employee("ZhangSantt", 23);
        Employee e2 = new Employee("littlefox", 33);
        Employee e3 = new Employee("wang hua", 19);

        //随机写入
        t.writeEmployee(e1, 0);
        t.writeEmployee(e3, 2);
        t.writeEmployee(e2, 1);

        //随机读取
        System.out.println("first employee");
        t.readEmployee(0);

        System.out.println("third employee");
        t.readEmployee(2);


        System.out.println("second employee");
        t.readEmployee(1);
    }
}

