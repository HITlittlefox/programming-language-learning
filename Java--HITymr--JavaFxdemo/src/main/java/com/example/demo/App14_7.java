package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App14_7 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Image imb = new Image("com/example/demo/images/�й�����.jpg");
        ImageView iv1 = new ImageView(imb);
        Button bt1 = new Button("����", iv1);
        Button bt2 = new Button("�й�", new ImageView("com/example/demo/images/�й���.jpg"));
        HBox box = new HBox(20);
        box.getChildren().addAll(bt1, bt2);
        box.setAlignment(Pos.CENTER);
        Image im = new Image("com/example/demo/images/����.jpg");
        ImageView iv2 = new ImageView();
        iv2.setImage(im);
        iv2.setFitWidth(80);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);
        ImageView iv3 = new ImageView();
        iv3.setImage(im);
        iv3.setRotate(90);
        iv3.setFitWidth(100);
        iv3.setPreserveRatio(true);
        BorderPane rootPane = new BorderPane();
        rootPane.setBottom(box);
        rootPane.setCenter(iv2);
        //rootPane.setAlignment(iv2,Pos.CENTER);
        rootPane.setRight(iv3);
        // rootPane.setAlignment(iv3,Pos.CENTER);s
        // rootPane.setTop(new ImageView(imb));
        // rootPane.setLeft(new ImageView(imb));
        Scene scene = new Scene(rootPane, 200, 150);
        primaryStage.setTitle("ͼ������ʾ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }  /* public static void main(String[] args){
      Application.launch(args);
   }*/
}