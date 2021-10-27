package chap04;

public class calcAreaTest {
    int calcArea(int height, int width) {
        return height * width;
    }


    public static void main(String[] args) {
        calcAreaTest test = new calcAreaTest();
        int a = test.calcArea(7, 12);
        System.out.println(a);
        short c = 7;
        System.out.println(test.calcArea(c, 15));
//        int d = test.calcArea(57);
        System.out.println(test.calcArea(2, 3));
        long t = 42;
//        int f = test.calcArea(t, 17);
        int f = test.calcArea((int) t, 17);
//        int g = test.calcArea();
//        System.out.println(test.calcArea());
//        byte h =test.calcArea(4,20);
//        int j = test.calcArea(2, 3, 5);
    }
}
