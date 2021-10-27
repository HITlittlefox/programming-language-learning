package chap12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//实现此接口
public class SimpleGui1B implements ActionListener {
    JButton button;

    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        //向按钮注册
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }

    //实现interface上的方法，是真正处理事件的方法；按钮会以ActionEvent对象作为参数来调用此方法
    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked!");

    }
}
