package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App14_11 extends Application {
    final Label lab1 = new Label("用户名：");
    final Label lab2 = new Label("密    码：");
    final PasswordField pf = new PasswordField();
    final TextField tf = new TextField();
    final TextArea ta = new TextArea("你好，我是文本区");

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
        Button bt1 = new Button("确认密码");
        Button bt2 = new Button("编辑文本");
        rootPane.add(bt1, 0, 2);
        rootPane.add(bt2, 1, 2);
        final ScrollPane scro = new ScrollPane(ta);
        ta.setPrefColumnCount(12);
        ta.setEditable(false);
        rootPane.add(scro, 2, 0, 4, 3);

        Scene scene = new Scene(rootPane, 400, 120);
        primaryStage.setTitle("网络与文本控件");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}