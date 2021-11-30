package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.image.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.geometry.Insets;

import java.util.Objects;

//8个选项卡
public class hw123 extends Application {
    final Label lab1 = new Label("用户名：");
    final Label lab2 = new Label("密    码：");
    final TextField tf = new TextField();
    final PasswordField pf = new PasswordField();
    final TextArea ta = new TextArea("你好，我是文本区；如果您登陆成功，则可以编辑此处。");


    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        //第1个tab,显示了一个圆
        Tab tab1 = new Tab();
        tab1.setText("第1个选项卡");
        tab1.setClosable(false);
        tab1.setContent(new Circle(200, 200, 30, Color.PINK));

        //第2个tab,显示了一个图片
        Tab tab2 = new Tab();
        tab2.setText("第2个选项卡");
        Image imb = new Image("https://pic.imgdb.cn/item/61867a2b2ab3f51d91344c2d.jpg");
        ImageView iv = new ImageView(imb);
        iv.setFitHeight(100);
        iv.setPreserveRatio(true);
        tab2.setContent(new Label("", iv));


        //第3个tab,显示了登录页面
        Tab tab3 = new Tab();

        GridPane rootPane = new GridPane();
        rootPane.setPadding(new Insets(10, 8, 10, 8));
        rootPane.setHgap(5);
        rootPane.setVgap(5);
        tf.setPromptText("输入用户名");
        rootPane.add(lab1, 0, 0);
        rootPane.add(tf, 1, 0);
        pf.setPromptText("输入密码");
        rootPane.add(lab2, 0, 1);
        rootPane.add(pf, 1, 1);

        Button login = new Button("登录");
        Button clear = new Button("重置");
        rootPane.add(login, 0, 2);
        rootPane.add(clear, 1, 2);
        final ScrollPane scro = new ScrollPane(ta);
        ta.setPrefColumnCount(12);
        ta.setEditable(false);
        rootPane.add(scro, 2, 0, 4, 3);

        Scene scene2 = new Scene(rootPane, 400, 120);
        primaryStage.setTitle("网络与文本控件");
        primaryStage.setScene(scene2);
        primaryStage.show();
        //重置按钮点击事件


        clear.setOnAction(e -> {
            tf.setText("");
            pf.setText("");
        });
        //登录按钮点击事件
        login.setOnAction(e -> {
            String name = tf.getText();
            String pasword = pf.getText();
            if ("user".equals(name) && "admin".equals(pasword)) {
                System.out.println("登录成功");
                ta.setEditable(true);
                ta.setText("您现在登录成功，可以编辑此处！");

            } else {
                System.out.println("登录失败");
            }

        });
        tab3.setText("第3个选项卡");
        tab3.setClosable(false);
        tab3.setContent(new Label("", rootPane));


        //TODO: 菜单中，有 1工具、2联系人、3相册、4播放器
        //1工具有两个选项卡：01计算器、02日历
        //第4个tab,显示了计算器
        Tab tab4 = new Tab();
        tab4.setText("第4个选项卡");
        tab4.setClosable(false);
//        tab4.setContent(new Circle(200, 200, 30, Color.PINK));
//        String[] strArray = {"1", "2", "3"};
//        if (Objects.equals(tab4.getText(), "第4个选项卡")) {
//            hw124.main();
//        }


        //第5个tab,显示了日历
        Tab tab5 = new Tab();
        tab5.setText("第5个选项卡");
        tab5.setClosable(false);
        //第6个tab,显示了联系人
        Tab tab6 = new Tab();
        tab6.setText("第6个选项卡");
        tab6.setClosable(false);
        //第7个tab,显示了相册
        Tab tab7 = new Tab();
        tab7.setText("第7个选项卡");
        tab7.setClosable(false);
        //第8个tab,显示了播放器
        Tab tab8 = new Tab();
        tab8.setText("第8个选项卡");
        tab8.setClosable(false);

        //把多个选项卡挨个插入tabPane
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8);
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("选项卡面板与选项卡");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
