import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class App15_16 extends Application{  
  @Override
  public void start(Stage stage){
      HBox hB=new HBox();
      final ColorPicker cP=new ColorPicker(Color.RED);
      final Text t=new Text("请选择颜色来设置我");
      //t.setStyle("-fx-font-size:20");
      hB.getChildren().addAll(cP,t);
      t.setFill(cP.getValue());
      cP.setOnAction(e->t.setFill(cP.getValue()));
      Scene scene=new Scene(hB,260,100);
      stage.setTitle("颜色选择器应用");
      stage.setScene(scene);
      stage.show();
  }
}