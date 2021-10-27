package chap04;

//回文数
public class Puzzle4 {
    public static void main(String[] args) {

        Puzzle4b[] obs = new Puzzle4b[8];
        int y = 1;
        int x = 0;
        int result = 0;
        while (x < 4) {
            obs[x] = new Puzzle4b();
            obs[x].ivar = y;
            y = y * 10;
            x = x + 1;
            System.out.println(x + " " + y);

        }
        x = 4;
        while (x > 0) {
            x = x - 1;
            result = result + obs[x].doStuff(x);
            System.out.println(x + " " + result);
        }
        System.out.println("result " + result);
    }
}

class Puzzle4b {
    int ivar;

    public int doStuff(int factor) {

        if (ivar > 10) {
            return ivar * factor;
        } else {
            return ivar * (3 - factor);
        }
    }
}