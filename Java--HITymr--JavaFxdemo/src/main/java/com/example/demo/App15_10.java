//package com.example.demo;
//
//import javafx.application.Application;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.control.Slider;
//import javafx.geometry.Orientation;
//import javafx.beans.InvalidationListener;
//import javafx.beans.Observable;
//import javafx.scene.text.Text;
//import javafx.scene.text.Font;
//import javafx.scene.paint.Color;
//import javafx.scene.layout.*;
//
//public class App15_10 extends Application{
//  private Slider s1=new Slider();
//  private Slider rs1=new Slider(0.0,1.0,0.5);
//  private Slider gs1=new Slider(0.0,1.0,0.5);
//  private Slider bs1=new Slider(0.0,1.0,0.5);
//  private Text t=new Text("JavaFX���");
//  @Override
//  public void start(Stage primaryStage){
//      s1.setShowTickLabels(true);
//      s1.setShowTickMarks(true);
//      s1.setValue(t.getFont().getSize());
//      rs1.setOrientation(Orientation.VERTICAL);
//      bs1.setOrientation(Orientation.VERTICAL);
//      rs1.setShowTickLabels(true);
//      gs1.setShowTickLabels(true);
//      bs1.setShowTickLabels(true);
//      IListener Fc=new IListener();
//      rs1.valueProperty().addListener(Fc);
//      gs1.valueProperty().addListener(Fc);
//      bs1.valueProperty().addListener(Fc);
//      StackPane sPane=new StackPane();
//      sPane.getChildren().add(t);
//      s1.valueProperty().addListener(ov->{
//         double size=s1.getValue();
//         Font font=new Font(size);
//         t.setFont(font);
//      });
//      BorderPane rootBP=new BorderPane();
//      rootBP.setLeft(rs1);
//      rootBP.setTop(gs1);
//      rootBP.setRight(bs1);
//      rootBP.setBottom(s1);
//      rootBP.setCenter(sPane);
//      Scene scene=new Scene(rootBP,360,200);
//      primaryStage.setTitle("��������Ӧ��");
//      primaryStage.setScene(scene);
//      primaryStage.show();
//  }
//  class IListener implements InvalidationListener{
//      @Override
//      public void invalidated(Observable ov){
//          double r=rs1.getValue();
//          double g=gs1.getValue();
//          double b=bs1.getValue();
//          Color c=Color.color(r,g,b);
//          //Color c=new Color(r,g,b,1);
//         //System.out.println(r+"  "+g+"  "+b);
//          t.setFill(c);
//      }
//  }
//}
