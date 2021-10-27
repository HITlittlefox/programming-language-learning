import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class App15_14 extends Application{  
  private Button but1=new Button("打开",new ImageView("images/open.png"));
  private Button but2=new Button("保存",new ImageView("images/save.png"));
  private Button but3=new Button("帮助",new ImageView("images/help.png"));
  private TextArea ta=new TextArea("我现在是禁用状态");
  @Override
  public void start(Stage stage){
      ta.setEditable(false);
      but1.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      but2.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      but3.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
     /* Tooltip.install(but1,new Tooltip("打开"));
      Tooltip.install(but2,new Tooltip("保存"));
      Tooltip.install(but3,new Tooltip("打开"));*/
      but1.setTooltip(new Tooltip("帮助"));
      but2.setTooltip(new Tooltip("保存"));
      but3.setTooltip(new Tooltip("帮助"));
      but1.setOnAction(e->{
         ta.setEditable(true);
         ta.setText("恭喜你！\n哈哈，现在可以编辑我了");
         ta.setStyle("-fx-text-fill:red");
      });
      ToolBar tB=new ToolBar(but1,but2,but3);
      BorderPane rootBP=new BorderPane();
      rootBP.setCenter(ta);
      rootBP.setTop(tB);
      Scene scene=new Scene(rootBP,230,100);
      stage.setTitle("工具栏应用程序");
      stage.setScene(scene);
      stage.show();
  }
}