package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.event.*;

public class App15_6 extends Application{
  Font fN=Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.REGULAR,16);
  Font fB=Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,16);
  Font fI=Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.ITALIC,16);
  Font fBI=Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,16);
  CheckBox chkB=new CheckBox("����");
  CheckBox chkI=new CheckBox("б��");
  RadioButton r=new RadioButton("��ɫ");
  RadioButton g=new RadioButton("��ɫ");
  RadioButton b=new RadioButton("��ɫ");
  Text t=new Text("��ϲ��JavaFX���");
//Text t=new Text("dfssffJ��avaFXdsfdsf");
  @Override
  public void start(Stage primaryStage){
      VBox vbL=new VBox(20);
      vbL.setStyle("-fx-border-color:green");
      vbL.getChildren().addAll(chkB,chkI);
      ToggleGroup gro=new ToggleGroup();
      r.setToggleGroup(gro);
      g.setToggleGroup(gro);
      b.setToggleGroup(gro);
      VBox vbR=new VBox();
      vbR.setStyle("-fx-border-color:blue");
      vbR.getChildren().addAll(r,g,b);
      BorderPane rootBP=new BorderPane();
      t.setFont(fN);
      rootBP.setLeft(vbL);
      rootBP.setRight(vbR);
      rootBP.setCenter(t);
      Han han=new Han();
      r.setOnAction(han);
      g.setOnAction(han);
      b.setOnAction(han);
      chkB.setOnAction(han);
      chkI.setOnAction(han);
      Scene scene=new Scene(rootBP,260,60);
      primaryStage.setTitle("��ѡ���뵥ѡ��ť");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
  class Han implements EventHandler<ActionEvent>{
      @Override
      public void handle(ActionEvent e){
          if(r.isSelected())  t.setFill(Color.RED);
          if(g.isSelected())  t.setFill(Color.GREEN);
          if(b.isSelected())  t.setFill(Color.BLUE);
          if(chkB.isSelected()&&chkI.isSelected())  t.setFont(fBI);
          else if(chkB.isSelected())  t.setFont(fB);
          else if(chkI.isSelected())  t.setFont(fI);
          else  t.setFont(fN);
      }
  }
}
