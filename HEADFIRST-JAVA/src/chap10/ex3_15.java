package chap10;

class Window {
    int doornum;

    //无参构造函数
    public Window() {
        this(0);
        System.out.println("Window()");
    }

    //单参构造函数
    public Window(int doornum) {
        this.doornum = doornum;
        System.out.println("Window(" + doornum + ")");
    }
}

class Car {
    Window w1 = new Window(1);
    String color;

    //无参构造函数
    public Car() {
        this("White");//跳到第35行单参构造函数
        System.out.println("Car()");
        w3 = new Window();
    }

    //单参构造函数
    public Car(String color) {
        System.out.println("Car(" + color + ")");
    }

    public void Speedup() {
        System.out.println("Car:Speedup()");
    }

    Window w2 = new Window(2);
    Window w3 = new Window(3);
}

public class ex3_15 {
    public static void main(String[] args) {
        Car c = new Car();
        c.Speedup();
    }

}