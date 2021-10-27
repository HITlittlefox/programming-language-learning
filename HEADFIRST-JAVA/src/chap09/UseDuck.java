package chap09;

//构造方法
public class UseDuck {
    public static void main(String[] args) {
        Duck d = new Duck(42);
        Duck e = new Duck();

    }
}


class Duck {
    int size;

    public Duck() {
        this.size = 27;
        System.out.println("默认值" + this.size);
    }


    public Duck(int duckSize) {
        System.out.println("Quack");
        this.size = duckSize;
        System.out.println("单参数值" + size);
    }
}
