package chap04;

//想告诉我pass by value 不会对原值有影响
public class XCopy {
    public static void main(String[] args) {
        int orig = 42;
        System.out.println("方法前：" + orig);
        XCopy x = new XCopy();
        int y = x.go(orig);
        System.out.println("方法后：" + y);
        System.out.println("方法后：" + orig);

    }

    int go(int arg) {
        arg = arg * 2;
        System.out.println("方法中：" + arg);
        return arg;
    }
}
