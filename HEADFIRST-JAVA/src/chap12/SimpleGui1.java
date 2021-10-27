package chap12;

import javax.swing.*;

public class SimpleGui1 {
    public static void main(String[] args) {
        //创建frame和button
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        //window关闭时把程序结束掉
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //把button加到frame的pane上
        frame.getContentPane().add(button);
        //设定frame的大小
        frame.setSize(300, 300);
        //最后把frame显示出来
        frame.setVisible(true);
    }
}
