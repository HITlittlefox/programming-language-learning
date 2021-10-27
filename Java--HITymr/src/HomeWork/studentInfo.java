package HomeWork;

import java.io.*;
import java.io.Serializable;


class Student implements Serializable {
    private String id;    //学号
    private String name;    //姓名
    private int eng;    //英语成绩
    private int math; //数学成绩
    private int comp; //计算机成绩
    private int sum;  //总成绩

    //学生基本信息
    public Student(String id, String name, int eng, int math, int comp) {
        this.id = id;
        this.name = name;
        this.eng = eng;
        this.math = math;
        this.comp = comp;
        sum();   //计算总成绩
    }

    public Student(Student s) {
        this.id = s.id;
        this.name = new String(s.name);
        this.eng = s.eng;
        this.math = s.math;
        this.comp = s.comp;
        sum();            //计算总成绩
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEng(int eng) {
        this.eng = eng;
        sum();            //计算总成绩
    }

    public void setMath(int math) {
        this.math = math;
        sum();            //计算总成绩
    }


    public void setComp(int comp) {
        this.comp = comp;
        sum();            //计算总成绩
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public int getComp() {
        return comp;
    }

    public int getSum() {
        return sum;
    }

    final void sum() {
        sum = eng + math + comp;
    }

    public String toString() {
        return getId() + "\t" + getName() + "\t" + getEng() + "\t" + getMath() + "\t" + getComp() + "\t" + getSum();
    }

    public boolean equals(Object x) {
        if (this.getClass() != x.getClass()) return false;
        Student b = (Student) x;
        return (this.getId().equals(b.getId()));
    }

    //比较成绩大小,当前对象成绩比参数对象成绩大时返回1,相等时返回0,其它返回-1.
    public int compare(Student A) {
        if (this.getSum() > A.getSum()) return 1;
        else if (this.getSum() == A.getSum()) return 0;
        else return -1;
    }
}

class StudentClass {
    private String name;             //班级名称
    static int capacity = 40;        //最大容量
    private Student students[];      //学生
    private int size;                //实际人数

    //班级名，班级容量
    public StudentClass(String name, int size) {
        this.name = name;
        this.size = size;
        students = new Student[capacity];
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //有几个学生set几个，在main中会有数值
    public void setStudents(Student[] students) {
        for (int i = 0; i < size; i++)
            this.students[i] = new Student(students[i]);
    }

    //把信息展示出来
    public String toString() {
        String s;
        s = " 班级:" + name + "\t" + "容量:" + capacity + "\t" + "实际人数:" + size + "\n\n";
        s = s + "学号" + "\t" + "姓名" + "\t" + "英语" + "\t" + "数学" + "\t" + "计算机" + "\t" + "总成绩\n";
        for (int i = 0; i < size; i++)
            s = s + students[i].getId() + "\t" + students[i].getName() + "\t" + students[i].getEng() + "\t" + students[i].getMath() + "\t" +
                    students[i].getComp() + "\t" + students[i].getSum() + "\n";
        return s;
    }
}

public class studentInfo {
    //Keyboard类的声明
    //keyboard获得键盘输入的东西
    static class Keyboard {
        static BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));

        //输入数字
        //逐行、删除字符串的头尾空白符
        public static int getInteger() {
            try {
                return (Integer.valueOf(inputStream.readLine().trim()).intValue());
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        //输入字符串
        public static String getString() {
            try {
                return (inputStream.readLine());
            } catch (IOException e) {
                return "0";
            }
        }
    }

    public static Student getAStudent(int i) {
        Student studenti;
        System.out.println("输入第" + i + "个学生的信息:");
        System.out.print("学号:");
        String id = Keyboard.getString();
        System.out.print("姓名:");
        String name = Keyboard.getString();
        System.out.print("英语成绩:");
        int eng = Keyboard.getInteger();
        System.out.print("数学成绩:");
        int math = Keyboard.getInteger();
        System.out.print("计算机成绩:");
        int comp = Keyboard.getInteger();
        studenti = new Student(id, name, eng, math, comp);
        return studenti;
    }

    public static void main(String args[]) {

        StudentClass aClass = new StudentClass("信管", 5);
        Student students[] = new Student[5];

        //循环输入内容
        for (int i = 0; i < 5; i++)
            students[i] = new Student(getAStudent(i + 1));
        aClass.setStudents(students);
        System.out.println(aClass);


        //将学生信息保存到文件stu.ser中。（这里采用绝对路径）
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\96361\\下载\\stu.ser"));
            for (int i = 0; i < 2; i++)
                oos.writeObject(students[i]);
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
