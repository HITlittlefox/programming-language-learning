import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract double size();
}

class Square extends Shape {
    private double width, height;

    public Square(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double size() {
        return this.width * this.height;
    }
}

class Fan extends Shape {
    private double radius, degree;

    public Fan(double radius, double degree) {
        this.radius = radius;
        this.degree = degree;
    }

    @Override
    public double size() {
        return (this.degree / 360.0) * Math.PI * radius * radius;
    }
}

public class MainClass {
    static double totalSize(List<Shape> shapes) {
        return shapes.stream().map(Shape::size).reduce(0.0, Double::sum);
    }

    public int a = 0;

    public static void main(String[] args) {
        Square s1 = new Square(2, 4);
        Fan s2 = new Fan(1, 360);
        //System.out.println(this.a);

        System.err.println("s1.size() = " + s1.size() + ", s2.size() = " + s2.size());

        List<Shape> shapes = new ArrayList<>();
        shapes.add(s1);
        shapes.add(s2);

        System.err.println("totalSize(shapes) = " + totalSize(shapes));
    }
}
