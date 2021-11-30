package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.stage.WindowEvent;

public class hw12 extends Application {
    final Label lab1 = new Label("用户名：");
    final Label lab2 = new Label("密    码：");
    final TextField tf = new TextField();
    final PasswordField pf = new PasswordField();
    final TextArea ta = new TextArea("你好，我是文本区；如果您登陆成功，则可以编辑此处。");

    @Override
    public void start(Stage primaryStage) {
        GridPane rootPane = new GridPane();
        rootPane.setPadding(new Insets(10, 8, 10, 8));
        rootPane.setHgap(5);
        rootPane.setVgap(5);
        tf.setPromptText("输入用户名");
        rootPane.add(lab1, 0, 0);
        rootPane.add(tf, 1, 0);
        pf.setPromptText("输入密码");
        rootPane.add(lab2, 0, 1);
        rootPane.add(pf, 1, 1);
//        Button bt1 = new Button("确认密码");
//        Button bt2 = new Button("编辑文本");
//
//
        Button login = new Button("登录");
        Button clear = new Button("重置");


        rootPane.add(login, 0, 2);
        rootPane.add(clear, 1, 2);
        final ScrollPane scro = new ScrollPane(ta);
        ta.setPrefColumnCount(12);
        ta.setEditable(false);
        rootPane.add(scro, 2, 0, 4, 3);

        Scene scene = new Scene(rootPane, 400, 120);
        primaryStage.setTitle("网络与文本控件");
        primaryStage.setScene(scene);
        primaryStage.show();
        //重置按钮点击事件


        clear.setOnAction(e -> {
            tf.setText("");
            pf.setText("");
        });
        //登录按钮点击事件
        login.setOnAction(e -> {
            String name = tf.getText();
            String pasword = pf.getText();
            if ("admin".equals(name) && "666".equals(pasword)) {
                System.out.println("登录成功");
                ta.setEditable(true);
                ta.setText("您现在登录成功，可以编辑此处！");
            } else {
                System.out.println("登录失败");
            }

        });
    }
}
