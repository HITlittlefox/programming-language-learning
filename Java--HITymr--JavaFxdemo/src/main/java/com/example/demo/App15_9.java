import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.beans.InvalidationListener;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
import javafx.beans.Observable;
import javafx.scene.layout.*;
import java.io.*;

public class App15_9 extends Application{  
  private String[] my={"扁鹊","华佗","孙思邈","李时珍","张仲景","葛洪"};
  private ImageView[] iv={new ImageView("images/扁鹊.jpg"),new ImageView("images/华佗.jpg"),
                                          new ImageView("images/孙思邈.jpg"),new ImageView("images/李时珍.jpg"),
                                          new ImageView("images/张仲景.jpg"),new ImageView("images/葛洪.jpg")};
  private ObservableList<String> items=FXCollections.observableArrayList(my);
  private ListView<String> lv=new ListView<String>(items);
  private FlowPane fp=new FlowPane(5,5);

  @Override
  public void start(Stage primaryStage){
      lv.setPrefSize(80,100);
      lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      BorderPane bp=new BorderPane();
      bp.setLeft(new ScrollPane(lv));
      bp.setCenter(fp);
      lv.getSelectionModel().selectedItemProperty().addListener(new IListener());
     /* lv.getSelectionModel().selectedItemProperty().addListener(
      new ChangeListener<String>(){
          public void changed(ObservableValue<? extends String> ov,String oldVal,String newVal){
              fp.getChildren().clear();
             System.out.println(lv.getSelectionModel().getSelectedIndices());
             for(Integer i:lv.getSelectionModel().getSelectedIndices()){
                fp.getChildren().add(iv[i]);
             }
          }
      } );*/
      Scene scene=new Scene(bp,360,130);
      primaryStage.setTitle("列表视图的应用");
      primaryStage.setScene(scene);
      primaryStage.show();
  }

 class IListener implements InvalidationListener{
      @Override
      public void invalidated(Observable ov){
          fp.getChildren().clear();
          System.out.println(lv.getSelectionModel().getSelectedIndices());
          for(Integer i:lv.getSelectionModel().getSelectedIndices()){
              fp.getChildren().add(iv[i]);
              //System.out.println(i);
          }
      }
  }
}