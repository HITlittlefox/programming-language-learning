package JavaBook.chap6;

//filename��App6_1.java
class Cylinder
{
  double radius;
  int height;
  double pi=3.14;
  void area()
  {
    System.out.println("�����="+pi* radius* radius);
  }
  double volume()
  {
    return (pi* radius* radius)*height;
  }
}
public class App6_1
{
  public static void main(String[] args)
  {
    Cylinder volu;
    volu=new Cylinder();
    volu.radius=2.8;
    volu.height=5;
    System.out.println("��Բ�뾶="+volu.radius);
    System.out.println("Բ���ĸ�="+volu.height);
    System.out.print("Բ��");
    volu.area();
    System.out.println("Բ�������="+volu.volume());
  }
}
