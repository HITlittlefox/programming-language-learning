package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App14_11 extends Application {
    final Label lab1 = new Label("�û�����");
    final Label lab2 = new Label("��    �룺");
    final PasswordField pf = new PasswordField();
    final TextField tf = new TextField();
    final TextArea ta = new TextArea("��ã������ı���");

    @Override
    public void start(Stage primaryStage) {
        GridPane rootPane = new GridPane();
        rootPane.setPadding(new Insets(10, 8, 10, 8));
        rootPane.setHgap(5);
        rootPane.setVgap(5);
        tf.setPromptText("�����û���");
        rootPane.add(lab1, 0, 0);
        rootPane.add(tf, 1, 0);
        pf.setPromptText("��������");
        rootPane.add(lab2, 0, 1);
        rootPane.add(pf, 1, 1);
        Button bt1 = new Button("ȷ������");
        Button bt2 = new Button("�༭�ı�");
        rootPane.add(bt1, 0, 2);
        rootPane.add(bt2, 1, 2);
        final ScrollPane scro = new ScrollPane(ta);
        ta.setPrefColumnCount(12);
        ta.setEditable(false);
        rootPane.add(scro, 2, 0, 4, 3);

        Scene scene = new Scene(rootPane, 400, 120);
        primaryStage.setTitle("�������ı��ؼ�");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}