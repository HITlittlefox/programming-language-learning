package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App14_1 extends Application {
    public void start(Stage primaryStage) {
        Button bt = new Button("我是按钮");
        Scene scene = new Scene(bt, 210, 80);
        primaryStage.setTitle("我的JavaFX窗口");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
//        launch();

    }/**/
}