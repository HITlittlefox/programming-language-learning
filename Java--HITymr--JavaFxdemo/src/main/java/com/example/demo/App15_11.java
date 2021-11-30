//package com.example.demo;
//
//import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.geometry.Pos;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//
//public class App15_11 extends Application{
//  @Override
//  public void start(Stage stage){
//      final Slider slider=new Slider();
//      slider.setMin(0);
//      slider.setMax(50);
//      slider.setShowTickLabels(true);
//      slider.setShowTickMarks(true);
//      final ProgressBar pb=new ProgressBar();
//      final ProgressIndicator pi=new ProgressIndicator();
//      ChangeListener<Number> cListener=new ChangeListener<Number>(){
//          public void changed(ObservableValue<? extends Number> ov,Number oldVal,Number newVal){
//              pb.setProgress(newVal.doubleValue()/50);
//              pi.setProgress(newVal.doubleValue()/50);
//          }
//      };
//      slider.valueProperty().addListener(cListener);
//      final HBox hb=new HBox();
//      hb.setSpacing(5);
//      hb.setAlignment(Pos.CENTER);
//      hb.getChildren().addAll(slider,pb,pi);
//      Scene scene=new Scene(hb,360,200);
//      stage.setTitle("������Ӧ�ó���");
//      stage.setScene(scene);
//      stage.show();
//  }
//}
