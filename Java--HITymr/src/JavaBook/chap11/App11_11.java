package JavaBook.chap11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TestThread extends Thread {
    private boolean flag = true;

    public void stopme() { //在此方法中控制循环条件
        flag = false;
    }

    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(i++);//如果flag为真则一直显示递增整数
        }
    }
}

public class App11_11 {
    public static void main(String[] args) throws IOException {
        TestThread t = new TestThread();
        t.start();
        //readLine会读取一行输入
        //readLine没读到输入的时候会卡住它所在的thread，不让它往下执行下面的语句
        //那你输入之后readLine一成功，后面t.stopme()就能执行了
        new BufferedReader(new InputStreamReader(System.in)).readLine();

        t.stopme();   //调用stopme方法结束t线程
    }
}
