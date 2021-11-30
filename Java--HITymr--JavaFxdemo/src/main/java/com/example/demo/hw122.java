package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.shape.Circle;
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

public class hw122 extends Application {
    @Override
    public void start(Stage stage) {
        MenuBar menuB = new MenuBar();
        Text t = new Text("我是一个程序员，\n我喜欢用JavaFX编程");
        BorderPane rootBP = new BorderPane();
        rootBP.setTop(menuB);
        rootBP.setCenter(t);
        Menu fileM = new Menu("(_F)文件");
        fileM.setMnemonicParsing(true);
//        Image inew = new Image("https://pic.imgdb.cn/item/615f1d362ab3f51d91a5af57.jpg");
//        ImageView ivnew = new ImageView(inew);
        MenuItem newMI = new MenuItem("新建");
        MenuItem openMI = new MenuItem("打开");
        openMI.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
//        openMI.setGraphic(new ImageView(new Image("https://pic.imgdb.cn/item/615f1d362ab3f51d91a5af57.jpg")));
        MenuItem saveMI = new MenuItem("保存");
        MenuItem exitMI = new MenuItem("退出");
        exitMI.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                String name = ((MenuItem) ae.getTarget()).getText();
                if (name.equals("退出")) Platform.exit();
                t.setText(name + "：被选中");
            }
        };
        exitMI.setOnAction(MEHandler);
        saveMI.setOnAction(MEHandler);
        newMI.setOnAction(MEHandler);
        openMI.setOnAction(MEHandler);
        fileM.getItems().addAll(newMI, openMI, saveMI, exitMI);

        Menu styleM = new Menu("格式");
        Menu fontM = new Menu("字体");
        CheckMenuItem boldMI = new CheckMenuItem("粗体");
//        boldMI.setGraphic(new ImageView(new Image("https://pic.imgdb.cn/item/615f1d362ab3f51d91a5af57.jpg")));
        boldMI.setSelected(true);
        CheckMenuItem italicMI = new CheckMenuItem("斜体");
//        italicMI.setGraphic(new ImageView(new Image("https://pic.imgdb.cn/item/615f1d362ab3f51d91a5af57.jpg")));
        boldMI.setOnAction(e -> t.setFill(Color.RED));

        fontM.getItems().addAll(boldMI, italicMI);
        Menu rgbM = new Menu("颜色");
        RadioMenuItem rMI = new RadioMenuItem("红色");
        RadioMenuItem gMI = new RadioMenuItem("绿色");
        RadioMenuItem bMI = new RadioMenuItem("蓝色");
        rMI.setOnAction(e -> t.setFill(Color.RED));
        gMI.setOnAction(e -> t.setFill(Color.GREEN));
        bMI.setOnAction(e -> t.setFill(Color.BLUE));
        bMI.setSelected(true);
        ToggleGroup rgbG = new ToggleGroup();
        rMI.setToggleGroup(rgbG);
        gMI.setToggleGroup(rgbG);
        bMI.setToggleGroup(rgbG);
        rgbM.getItems().addAll(rMI, gMI, bMI);
        styleM.getItems().addAll(fontM, new SeparatorMenuItem(), rgbM);

        menuB.getMenus().addAll(fileM, styleM);

        Scene scene = new Scene(rootBP, 230, 100);
        stage.setTitle("菜单应用程序");
        stage.setScene(scene);
        stage.show();


        TabPane tabPane = new TabPane();
        //第1个tab,显示了一个圆
        Tab tab1 = new Tab();
        tab1.setText("第1个选项卡");
        tab1.setClosable(false);
        tab1.setContent(new Circle(200, 200, 30, Color.PINK));

        //把多个选项卡挨个插入tabPane
        tabPane.getTabs().addAll(tab1);
        Scene scene2 = new Scene(tabPane);
//        primaryStage.setTitle("选项卡面板与选项卡");
//        primaryStage.setScene(scene);
//        primaryStage.show();


    }
}
