package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class App15_1 extends Application{  
  Button bt=new Button("����������ɫ");
  TextArea ta=new TextArea("������ɫ");
  @Override
  public void start(Stage primaryStage){
      BorderPane bPane=new BorderPane();
      bPane.setCenter(ta);
      bPane.setBottom(bt);
      bPane.setAlignment(bt,Pos.CENTER);
      Han eh=new Han();
      bt.setOnAction(eh);
      Scene scene=new Scene(bPane,180,100);
      primaryStage.setTitle("�����¼�");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
  class Han implements EventHandler<ActionEvent>{
      @Override
      public void handle(ActionEvent e){
          ta.setStyle("-fx-text-fill:red");  
      }
  }
}