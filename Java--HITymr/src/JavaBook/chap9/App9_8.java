package JavaBook.chap9;

//����Բ������Զ����쳣��CircleException������뾶�Ǹ��������׳��쳣����������
//App9_8.java
class CircleException extends Exception  //�Զ����쳣�࣬�̳���Exception
{
    double radius;

    CircleException(double r) {
        radius = r;
    }

    public String toString() {
        return "radius = " + radius + " ,which is not a positive number";
    }
}

class Circle    //����Circle��
{
    private double radius;

    public void setRadius(double r) throws CircleException   //�ɷ����׳��Զ����쳣
    {
        if (r < 0)
            throw new CircleException(r);   //�׳��쳣
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
            cir.setRadius(-2.0);  //������setRadius()�����׳����쳣
        } catch (CircleException e) {
            System.out.println("Custom exception:" + e + "");
        }
        cir.show();
    }
}
