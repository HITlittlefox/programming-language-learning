package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;

public class App15_12 extends Application{
  @Override
  public void start(Stage stage){
      MenuBar menuB=new MenuBar();
      Text t=new Text("����һ������Ա��\n��ϲ����JavaFX���");
      BorderPane rootBP=new BorderPane();
      rootBP.setTop(menuB);
      rootBP.setCenter(t);
      Menu fileM=new Menu("(_F)�ļ�");
      fileM.setMnemonicParsing(true);
      Image inew=new Image("images/new.png");
      ImageView ivnew=new ImageView(inew);
      MenuItem newMI=new MenuItem("�½�",ivnew);
      MenuItem openMI=new MenuItem("��");
      openMI.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
      openMI.setGraphic(new ImageView(new Image("images/open.png")));
      MenuItem saveMI=new MenuItem("����");
      MenuItem exitMI=new MenuItem("�˳�");
      exitMI.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
      EventHandler<ActionEvent> MEHandler=new EventHandler<ActionEvent>(){
         public void handle(ActionEvent ae){
             String name=((MenuItem)ae.getTarget()).getText();
             if(name.equals("�˳�")) Platform.exit();
             t.setText(name+"����ѡ��");
         }
      };
      exitMI.setOnAction(MEHandler);
      saveMI.setOnAction(MEHandler);
      newMI.setOnAction(MEHandler);
      openMI.setOnAction(MEHandler);
      fileM.getItems().addAll(newMI,openMI,saveMI,exitMI);

      Menu styleM=new Menu("��ʽ");
      Menu fontM=new Menu("����");
      CheckMenuItem boldMI=new CheckMenuItem("����");
      boldMI.setGraphic(new ImageView(new Image("images/bold.png")));
      boldMI.setSelected(true);
      CheckMenuItem italicMI=new CheckMenuItem("б��");
      italicMI.setGraphic(new ImageView(new Image("images/italic.png")));
      boldMI.setOnAction(e->t.setFill(Color.RED));

      fontM.getItems().addAll(boldMI,italicMI);
      Menu rgbM=new Menu("��ɫ");
      RadioMenuItem rMI=new RadioMenuItem("��ɫ");
      RadioMenuItem gMI=new RadioMenuItem("��ɫ");
      RadioMenuItem bMI=new RadioMenuItem("��ɫ");
      rMI.setOnAction(e->t.setFill(Color.RED));
      gMI.setOnAction(e->t.setFill(Color.GREEN));
      bMI.setOnAction(e->t.setFill(Color.BLUE));
      bMI.setSelected(true);
      ToggleGroup rgbG=new ToggleGroup();
      rMI.setToggleGroup(rgbG);
      gMI.setToggleGroup(rgbG);
      bMI.setToggleGroup(rgbG);
      rgbM.getItems().addAll(rMI,gMI,bMI);
      styleM.getItems().addAll(fontM,new SeparatorMenuItem(),rgbM);

      menuB.getMenus().addAll(fileM,styleM);

      Scene scene=new Scene(rootBP,230,100);
      stage.setTitle("�˵�Ӧ�ó���");
      stage.setScene(scene);
      stage.show();
  }
}
