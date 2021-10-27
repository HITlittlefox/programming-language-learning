package JavaBook.chap9;

//计算圆面积，自定义异常类CircleException，如果半径是负数，就抛出异常，并捕获处理。
//App9_8.java
class CircleException extends Exception  //自定义异常类，继承自Exception
{
    double radius;

    CircleException(double r) {
        radius = r;
    }

    public String toString() {
        return "radius = " + radius + " ,which is not a positive number";
    }
}

class Circle    //定义Circle类
{
    private double radius;

    public void setRadius(double r) throws CircleException   //由方法抛出自定义异常
    {
        if (r < 0)
            throw new CircleException(r);   //抛出异常
        else
            radius = r;
    }

    public void show() {
        System.out.println("Circle area=" + 3.14 * radius * radius);
    }
}

public class App9_8 {
    public static void main(String[] args) {
        Circle cir = new Circle();
        try {
            cir.setRadius(-2.0);  //捕获由setRadius()方法抛出的异常
        } catch (CircleException e) {
            System.out.println("Custom exception:" + e + "");
        }
        cir.show();
    }
}
