package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class App14_2 extends Application{  
  @Override
  public void start(Stage primaryStage){
      Button bt=new Button("���ǰ�ť");
      Scene scene=new Scene(bt,210,80);
      primaryStage.setTitle("��������̨");
      primaryStage.setScene(scene);
      primaryStage.show();
      Stage stage=new Stage();
      stage.setAlwaysOnTop(true);
      stage.setTitle("�ڶ���̨");
      Button bt1=new Button("��Ҳ�ǰ�ť");
      stage.setScene(new Scene(bt1,180,100));
      stage.show();
  }
  /* public static void main(String[] args){
      Application.launch(args);
   }*/
}