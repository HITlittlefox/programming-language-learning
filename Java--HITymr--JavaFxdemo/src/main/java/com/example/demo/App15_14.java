//import javafx.application.Application;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.*;
//
//public class App15_14 extends Application{
//  private Button but1=new Button("��",new ImageView("images/open.png"));
//  private Button but2=new Button("����",new ImageView("images/save.png"));
//  private Button but3=new Button("����",new ImageView("images/help.png"));
//  private TextArea ta=new TextArea("�������ǽ���״̬");
//  @Override
//  public void start(Stage stage){
//      ta.setEditable(false);
//      but1.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//      but2.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//      but3.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//     /* Tooltip.install(but1,new Tooltip("��"));
//      Tooltip.install(but2,new Tooltip("����"));
//      Tooltip.install(but3,new Tooltip("��"));*/
//      but1.setTooltip(new Tooltip("����"));
//      but2.setTooltip(new Tooltip("����"));
//      but3.setTooltip(new Tooltip("����"));
//      but1.setOnAction(e->{
//         ta.setEditable(true);
//         ta.setText("��ϲ�㣡\n���������ڿ��Ա༭����");
//         ta.setStyle("-fx-text-fill:red");
//      });
//      ToolBar tB=new ToolBar(but1,but2,but3);
//      BorderPane rootBP=new BorderPane();
//      rootBP.setCenter(ta);
//      rootBP.setTop(tB);
//      Scene scene=new Scene(rootBP,230,100);
//      stage.setTitle("������Ӧ�ó���");
//      stage.setScene(scene);
//      stage.show();
//  }
//}
