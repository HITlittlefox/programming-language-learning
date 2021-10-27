package chap10;

public class TestBox {
    Integer i;
    int j;

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }

    public void go() {
        System.out.println(j);
        System.out.println(i);
        i = 1;
        j = i;//i:null,j:0 //空指针异常
        System.out.println(j);
        System.out.println(i);
    }
}
