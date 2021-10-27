import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

public class App15_7 extends Application{  
  final PasswordField pf=new PasswordField();
  final TextField tf=new TextField();
  final TextArea ta=new TextArea("我现在不可编辑");
  @Override
  public void start(Stage stage){
      GridPane rootGP=new GridPane();
      final Label lab1=new Label("用户名：");
      final Label lab2=new Label("密    码：");
      tf.setPromptText("输入用户名");
      pf.setPromptText("输入密码");
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
            ta.setText("恭喜你！！\n哈哈，可以编辑我了");
         }
      });
      rootGP.add(scro,0,3,4,3);
      Scene scene=new Scene(rootGP,190,120);
      stage.setTitle("文本控件应用");
      stage.setScene(scene);
      stage.show();
  }
}