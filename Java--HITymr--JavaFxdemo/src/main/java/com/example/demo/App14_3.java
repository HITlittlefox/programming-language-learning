package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App14_3 extends Application {
    Button bt = new Button("ȷ��");

    @Override
    public void start(Stage primaryStage) {
        StackPane sPane = new StackPane();
        bt.setStyle("-fx-border-color:blue");
        Button bt1 = new Button("��Ҳ�ǰ�ť");
        bt1.setPrefSize(80, 50);
        bt1.setStyle("-fx-border-color:green");
        bt1.setRotate(-45);
        sPane.getChildren().addAll(bt1, bt);
        sPane.setRotate(45);
        sPane.setStyle("-fx-border-color:red;-fx-background-color:lightgray");
        Scene scene = new Scene(sPane, 180, 100);
        primaryStage.setTitle("ջ���");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}