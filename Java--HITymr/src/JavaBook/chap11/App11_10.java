package JavaBook.chap11;

class Balls {  //球类
    boolean flag0 = false;  //0号球的标志变量，true表示已被人拿，false表示未被任何人拿
    boolean flag1 = false;  //1号球的标志变量
    boolean flag2 = false;  //2号球的标志变量
}

class Player0 extends Thread {  //0号游戏者的类
    private Balls ball;

    public Player0(Balls b) {
        this.ball = b;
    }

    public void run() {
        while (true) {
            while (ball.flag1 == true) {
            }
            ; //如果1号球已被拿走，则等待
            ball.flag1 = true;  //拿起1号球
            while (ball.flag0 == true) {
            }
            ; //如果0号球已被拿走，则等待
            if (ball.flag1 == true && ball.flag0 == false) {
                ball.flag0 = true;  //拿起0号球
                System.out.println("Player0 has got two balls!");
                ball.flag1 = false;  //放下1号球
                ball.flag0 = false;  //放下0号球
                try {
                    sleep(1);
                } catch (Exception e) {
                }
                ; //放下后休息1ms
            }
        }
    }
}

class Player1 extends Thread {  //1号游戏者的类
    private Balls ball;

    public Player1(Balls b) {
        this.ball = b;
    }

    public void run() {
        while (true) {
            while (ball.flag0 == true) {
            }
            ; //如果0号球已被拿走，则等待
            ball.flag0 = true;  //拿起0号球
            while (ball.flag2 == true) {
            }
            ; //如果2号球已被拿走，则等待
            if (ball.flag0 == true && ball.flag2 == false) {
                ball.flag2 = true;  //拿起2号球
                System.out.println("Player1 has got two balls!");
                ball.flag0 = false;  //放下0号球
                ball.flag2 = false;  //放下2号球
                try {
                    sleep(1);
                } catch (Exception e) {
                }
                ; //放下后休息1ms
            }
        }
    }
}

class Player2 extends Thread {  //2号游戏者的类
    private Balls ball;

    public Player2(Balls b) {
        this.ball = b;
    }

    public void run() {
        while (true) {
            while (ball.flag2 == true) {
            }
            ; //如果2号球已被拿走，则等待
            ball.flag2 = true;  //拿起2号球
            while (ball.flag1 == true) {
            }
            ; //如果1号球已被拿走，则等待
            if (ball.flag2 == true && ball.flag1 == false) {
                ball.flag1 = true;  //拿起1号球
                System.out.println("Player2 has got two balls!");
                ball.flag1 = false;  //放下1号球
                ball.flag2 = false;  //放下2号球
                try {
                    sleep(1);
                } catch (Exception e) {
                }
                ; //放下后休息1ms
            }
        }
    }
}

public class App11_10 {
    public static void main(String[] args) {
        Balls ball = new Balls();     //新建一个球类对象
        Player0 p0 = new Player0(ball);  //创建0号游戏者
        Player1 p1 = new Player1(ball);  //创建1号游戏者
        Player2 p2 = new Player2(ball);  //创建2号游戏者
        p0.start();   //启动0号游戏者
        p1.start();  //启动1号游戏者
        p2.start();  //启动2号游戏者
    }
}