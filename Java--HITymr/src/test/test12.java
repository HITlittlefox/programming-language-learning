package test;

//public class test12 {
//    static int a[] = new a[10];

//    public static void main(String[] args) {

//        for (String arg : args) {
//            System.out.println(arg);
//
//        }
//        int i = (int) 78.67;
//        System.out.println(i);
//        int x = 2;
//        System.out.println("value is " + ((x < 1) ? 22 : 2));
//
//        int y = 15;
//        int b = y++ / 4;
//        System.out.println(b);

//        System.out.println((34 <= 25) && (68 != 90) || (48 * 2 < 100));

//        byte a=0,b=3;byte c=a+b;
//        short t=12;
//        short s=23;s=s+t;
//
//        short s=23;s+=12;


//        int i, j;
//        outer:
//        for (i = 1; i < 4; i++) {
//            inner:
//            for (j = 1; j < 4; j++) {
//                if (j == 2) {
//                    continue outer;
//                }
//                System.out.println("i=" + i + ",j=" + j);
//            }
//        }

//
//        int m = 1, n = 1;
//        System.out.print(m + " ");
//        for (int i = 2; i <= 10; i++) {
//            System.out.print(n + " ");
//            if (i % 5 == 0)
//                System.out.print("\n");
//            n = n + 1;
//            m = n - m;
//        }


//        int a[];
//        short[] b;
//        float[] c={1.0,2.0};
//        double d[]={1,2};


//        public class Person{

//    int[][] arr = new int[10][];
//
//    public static void main(String args[]) {
//
//        arr[1] = new int[10];
//
//        System.out.println(arr[1][0]);
//
//    }
//
//}

//
//    }
//            }

//public class test12 {
//    public static void main(String[] args) {
//        int x = 1, y = 2, z = 3;
//        y += z-- / ++x;
//        System.out.println(y);
//        int[] MyIntArray = {10, 20, 30, 40, 50, 60, 70};
//        System.out.println(MyIntArray.length);
//        long c = 100;
//        a a1 = new a("123");
//
//    }
//}
//
//class a {
//    public a() {
//        System.out.println("aaa");
//    }
//
//    public a(String b) {
//        System.out.println("bbb" + b);
//    }
//}
public class test12 {
    public static void main(String args[]) {
        new Student1("Tom", 'm', 90, 88);
        new Student1("Jack", 'm', 66, 89);
        new Student1("Mary", 'f', 76, 86);
        System.out.println("name\tsex\tchinese\tenglish");
        Student1.print();
    }
}

class Student1 {
    protected String name;
    protected char sex;
    protected int chinese;
    protected int english;

    protected Student1 next;
    static Student1 list;

    Student1(String name, char sex, int chinese, int english) {
        this.name = name;
        this.sex = sex;
        this.chinese = chinese;
        this.english = english;
        this.next = list;
        list = this;
    }

    static void print() {
            Student1 friend = list;
        if (friend == null) System.out.println("The list is empty.");
        else {
            do {
                System.out.println(friend.toString());
                friend = friend.next;
            } while (friend != null);
        }
    }

    public String toString() {
        return new String(name + "\t" + sex + "\t" + chinese + "\t" + english);
    }
}
