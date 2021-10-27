package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App14_8 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle c = new Circle();
        c.setCenterX(100);
        c.setCenterY(100);
         c.centerXProperty().bind(pane.widthProperty().divide(2));
         c.centerYProperty().bind(pane.heightProperty().divide(2));
        c.setRadius(50);
        c.setFill(Color.RED);
        pane.getChildren().add(c);
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("圆的绑定属性");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}