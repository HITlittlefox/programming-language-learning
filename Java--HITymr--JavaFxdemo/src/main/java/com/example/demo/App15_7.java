package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

public class App15_7 extends Application{
  final PasswordField pf=new PasswordField();
  final TextField tf=new TextField();
  final TextArea ta=new TextArea("�����ڲ��ɱ༭");
  @Override
  public void start(Stage stage){
      GridPane rootGP=new GridPane();
      final Label lab1=new Label("�û�����");
      final Label lab2=new Label("��    �룺");
      tf.setPromptText("�����û���");
      pf.setPromptText("��������");
      rootGP.add(lab1,0,0);
      rootGP.add(tf,1,0);
      rootGP.add(lab2,0,1);
      rootGP.add(pf,1,1);
      final ScrollPane scro=new ScrollPane(ta);
      ta.setPrefColumnCount(15);
      ta.setEditable(false);
      pf.setOnAction(e->{
         if(tf.getText().equals("abc")&&pf.getText().equals("123")){
            ta.setEditable(true);
            ta.setWrapText(true);
            ta.setStyle("-fx-text-fill:red");
            ta.setText("��ϲ�㣡��\n���������Ա༭����");
         }
      });
      rootGP.add(scro,0,3,4,3);
      Scene scene=new Scene(rootGP,190,120);
      stage.setTitle("�ı��ؼ�Ӧ��");
      stage.setScene(scene);
      stage.show();
  }
}
