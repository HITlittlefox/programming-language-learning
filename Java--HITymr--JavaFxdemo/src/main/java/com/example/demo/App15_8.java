package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class App15_8 extends Application{
  private ComboBox<String> cbo=new ComboBox<String>();
  private String[] color={"��ɫ","��ɫ","��ɫ"};
  private TextArea ta=new TextArea("��ϲ����JavaFX���");
  @Override
  public void start(Stage primaryStage){
      ObservableList<String> items=FXCollections.observableArrayList(color);
      cbo.getItems().addAll(items);
      cbo.setPrefWidth(180);
      cbo.setValue("��ɫ");
      BorderPane bPane=new BorderPane();
      ta.setPrefColumnCount(10);
      bPane.setTop(cbo);
      bPane.setCenter(ta);
      cbo.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent e){
              if(cbo.getValue().equals("��ɫ"))  ta.setStyle("-fx-text-fill:red");
              if(cbo.getValue().equals("��ɫ"))  ta.setStyle("-fx-text-fill:green");
              if(cbo.getValue().equals("��ɫ"))  ta.setStyle("-fx-text-fill:blue");
          }
      });
      Scene scene=new Scene(bPane,185,100);
      primaryStage.setTitle("��Ͽ�Ӧ��");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
}
