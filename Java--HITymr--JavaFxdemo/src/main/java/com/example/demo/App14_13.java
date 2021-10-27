package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App14_13 extends Application {
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab();
        tab1.setText("��һ��ѡ�");
        tab1.setClosable(false);
        tab1.setContent(new Circle(200, 200, 30, Color.PINK));
        Tab tab2 = new Tab();
        tab2.setText("�ڶ���ѡ�");
        Image imb = new Image("images/�й�����.jpg");
        ImageView iv = new ImageView(imb);
        iv.setFitHeight(100);
        iv.setPreserveRatio(true);
        tab2.setContent(new Label("", iv));
        tabPane.getTabs().addAll(tab1, tab2);
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("ѡ������ѡ�");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}