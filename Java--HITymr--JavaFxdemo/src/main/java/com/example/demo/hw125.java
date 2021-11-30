package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.geometry.HPos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.scene.media.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

//菜单 工具打开 新窗口--双选项卡
public class hw125 extends Application {
    String NowTime;
    //    String eURL = "file:///C:/Users/96361/Desktop/IELTS/test.mp4";
//    String eURL = "file:///C:/Users/96361/Desktop/programming-language-learning/Java--HITymr--JavaFxdemo/src/main/java/com/example/demo/mp4/test.mp4";
//        String eURL = "com/example/demo/mp4/test.mp4";
//    String eURL = "https://www.runoob.com/try/demo_source/mov_bbb.mp4";
    final Label lab1 = new Label("用户名：");
    final Label lab2 = new Label("密    码：");
    final TextField tf = new TextField();
    final PasswordField pf = new PasswordField();
//    final TextArea ta = new TextArea("你好，我是文本区；如果您登陆成功，则可以编辑此处。");

    private TextField num1 = new TextField();
    private TextField num2 = new TextField();
    private TextField res = new TextField();

    private Button btAdd = new Button("Add");
    private Button btSub = new Button("Subtract");
    private Button btMul = new Button("Multiply");
    private Button btDiv = new Button("Divide");

    private void Add() {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        res.setText(String.format("%.2f", n1 + n2));
    }

    private void Sub() {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        res.setText(String.format("%.2f", n1 - n2));
    }

    private void Mul() {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        res.setText(String.format("%.2f", n1 * n2));
    }

    private void Div() {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        res.setText(String.format("%.2f", n1 / n2));
    }

    @Override
    public void start(Stage stage) {

        //第0个舞台，登录
//        Tab tab0 = new Tab();
//        BorderPane loginPane = new BorderPane();
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
//        loginPane.setCenter(rootPane);
//        final ScrollPane scro = new ScrollPane(ta);
//        ta.setPrefColumnCount(12);
//        ta.setEditable(false);
//        rootPane.add(scro, 2, 0, 4, 3);
        Stage stage0 = new Stage();
        Scene scene0 = new Scene(rootPane, 280, 150);
        stage0.setTitle("登录窗口！");
        stage0.setScene(scene0);
        stage0.show();
        //重置按钮点击事件

        clear.setOnAction(e -> {
            tf.setText("");
            pf.setText("");
        });
        //登录按钮点击事件
        System.out.println("账号是user，密码是admin");

        login.setOnAction(e -> {
            String name = tf.getText();
            String pasword = pf.getText();
            if ("user".equals(name) && "admin".equals(pasword)) {
                System.out.println("登录成功");
//                ta.setEditable(true);
//                ta.setText("您现在登录成功，可以编辑此处！");
                stage0.close();
                stage.show();
            } else {
                System.out.println("登录失败");
            }

        });
//        tab0.setText("第3个选项卡");
//        tab0.setClosable(false);
//        tab0.setContent(new Label("", rootPane));


        //第2个窗口
//        Stage stage2 = new Stage();
        TabPane tabPane = new TabPane();
        //1工具有两个选项卡：01计算器、02日历
        //第4个tab,显示了计算器
        Tab tab4 = new Tab();
        tab4.setText("计算器");
        tab4.setClosable(false);
        //计算器
        HBox top = new HBox();
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(5, 10, 5, 10));
        top.setSpacing(10);

        top.getChildren().addAll(
                new Label("Number1"),
                num1,
                new Label("Number2"),
                num2,
                new Label("Result"),
                res);

        HBox bottom = new HBox();
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(5, 10, 5, 10));
        bottom.setSpacing(10);

        bottom.getChildren().addAll(btAdd, btSub, btMul, btDiv);

        BorderPane pane = new BorderPane();
        pane.setTop(top);
        pane.setBottom(bottom);

        btAdd.setOnAction(e -> Add());
        btSub.setOnAction(e -> Sub());
        btMul.setOnAction(e -> Mul());
        btDiv.setOnAction(e -> Div());

//        Scene scene21 = new Scene(pane, 900, 80);
//        stage2.setResizable(false);
//        stage2.setScene(scene21);
//        stage2.setTitle("Calculator");
//        stage2.show();
        tab4.setContent(new Label("", pane));


        //第5个tab,显示了日历
        Tab tab5 = new Tab();
        tab5.setText("日历");
        tab5.setClosable(false);
        //日历
        ClockEdge ce = new ClockEdge();
        ClockPointer cp = new ClockPointer();
        StackPane sp = new StackPane(ce, cp);
        StackPane nt = new StackPane();
        CalendarPanel caPa = new CalendarPanel();
        BorderPane bp = new BorderPane();
        bp.setLeft(sp);
        bp.setRight(caPa);
        bp.setBottom(nt);
        Scene scene22 = new Scene(bp, 420, 200);
        EventHandler<ActionEvent> eventHandler = e -> {
            nt.getChildren().clear();
            NowTime = (String) cp.setCurrentTime();
            Text tt = new Text(NowTime);
            tt.setFont(Font.font("Times New Roman", 20));
            nt.getChildren().add(tt);
        };
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
//        stage2.setTitle("Perpetual calendar");
//        stage2.setScene(scene22);
//        stage2.show();
        tab5.setContent(new Label("", bp));

        //把多个选项卡挨个插入tabPane
        tabPane.getTabs().addAll(tab4, tab5);
//        Scene scene2 = new Scene(tabPane, 700, 300);
//        stage2.setTitle("工具");
//        stage2.setScene(scene2);
//        stage2.show();

        //第3个窗口--联系人
//        Stage stage3 = new Stage();
        Text contact1 = new Text("姓名：Tom 手机号：178********\n" +
                "姓名：Jerry 手机号：178********\n" +
                "姓名：Amy 手机号：178********\n" +
                "姓名：Sam 手机号：178********\n" +
                "姓名：Bob 手机号：178********\n");
        BorderPane contactBP = new BorderPane();
        contactBP.setCenter(contact1);
//        Scene scene3 = new Scene(contactBP, 300, 300);
//        stage3.setTitle("联系人");
//        stage3.setScene(scene3);
//        stage3.show();

        //第4个窗口--相册
        //TODO:一页页显示
//        Stage stage4 = new Stage();
//

        TabPane tabPane4 = new TabPane();
        //1工具有两个选项卡：01计算器、02日历
        //第4个tab,显示了计算器
        Tab tab41 = new Tab();
        tab41.setText("出行");
        tab41.setClosable(false);

        Image im1 = new Image("https://p9.toutiaoimg.com/origin/pgc-image/91dcece36a00466e9a5083ae404de925");
        ImageView iv1 = new ImageView(im1);
        iv1.setFitHeight(300);
        iv1.setFitWidth(300);
        iv1.setImage(im1);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
        tab41.setContent(new Label("", iv1));


        Tab tab42 = new Tab();
        tab42.setText("笔记本");
        tab42.setClosable(false);

        Image im2 = new Image("https://p9.toutiaoimg.com/origin/pgc-image/a7fe9b00c97644739c13f01f3c75a97b");
        ImageView iv2 = new ImageView(im2);
        iv2.setFitHeight(300);
        iv2.setFitWidth(300);
        iv2.setImage(im2);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);
        tab42.setContent(new Label("", iv2));

        Tab tab43 = new Tab();
        tab43.setText("陆家嘴");
        tab43.setClosable(false);

        Image im3 = new Image("https://p9.toutiaoimg.com/img/tos-cn-i-siecs4i2o7/034706529b274aad9d6f90b5ca005ac5~noop.image");
        ImageView iv3 = new ImageView(im3);
        iv3.setFitHeight(300);
        iv3.setFitWidth(300);
        iv3.setImage(im3);
        iv3.setPreserveRatio(true);
        iv3.setCache(true);
        iv3.setSmooth(true);
        tab43.setContent(new Label("", iv3));
//        Button bt1 = new Button("出行", iv1);
//        Button bt2 = new Button("笔记本", iv2);
//        Button bt3 = new Button("陆家嘴", iv3);
//        HBox box = new HBox();
//        box.getChildren().addAll(bt1, bt2, bt3);
//        box.setAlignment(Pos.CENTER);
//        BorderPane photoBP = new BorderPane();
//        photoBP.setCenter(box);
//        Scene scene4 = new Scene(photoBP, 1200, 400);
//        stage4.setTitle("相册");
//        stage4.setScene(scene4);
//        stage4.show();

        //多个图片插入
        tabPane4.getTabs().addAll(tab41, tab42, tab43);
//        Scene scene41 = new Scene(tabPane4, 700, 300);
//        stage4.setTitle("相册");
//        stage4.setScene(scene41);
//        stage2.show();

        //TODO:播放器
//        Stage stage5 = new Stage();
//        String eURL = "https://www.runoob.com/try/demo_source/mov_bbb.mp4";
//
//        System.out.println(eURL);
//        if (eURL != null) {
        Media media;

        try {
            media = new Media("file:///com/example/demo/mp4/test2.mp4");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("如果您能看到这条语句，代表播放器的视频的本地路径因为“盘符不一样”进行了异常处理，\n我采用了tryCatch把视频地址改为了互联网视频，\n如果您的网络畅通，则可以正常播放。");
            media = new Media("https://www.runoob.com/try/demo_source/mov_bbb.mp4");
        }


        MediaPlayer mPlayer = new MediaPlayer(media);
        MediaView mView = new MediaView(mPlayer);
        mView.setFitWidth(800);
        mView.setFitHeight(600);

        Button pBut = new Button(">");
        pBut.setOnAction(e -> {
            if (pBut.getText().equals(">")) {
                mPlayer.play();
                pBut.setText("||");
            } else {
                mPlayer.pause();
                pBut.setText(">");
            }
        });

        Button rBut = new Button("<<");
        rBut.setOnAction(e -> mPlayer.seek(Duration.ZERO));
        Slider sVol = new Slider();
        sVol.setMinWidth(30);
        sVol.setPrefWidth(150);
        sVol.setValue(50);
        mPlayer.volumeProperty().bind(sVol.valueProperty().divide(100));
        HBox hB = new HBox(10);
        hB.setAlignment(Pos.CENTER);
        Label vol = new Label("音量");
        hB.getChildren().addAll(pBut, rBut, vol, sVol);
        BorderPane bPane = new BorderPane();
        bPane.setCenter(mView);
        bPane.setBottom(hB);
//        Scene scene5 = new Scene(bPane);
//        stage5.setTitle("视频播放器");
//        stage5.setScene(scene5);
//        stage5.show();

        //主窗口
        MenuBar menuB = new MenuBar();
        Text t = new Text("我是一个程序员，\n我喜欢用JavaFX编程");
        BorderPane rootBP = new BorderPane();
        rootBP.setTop(menuB);
        rootBP.setCenter(t);
        Menu fileM = new Menu("菜单");
        fileM.setMnemonicParsing(true);
        //TODO: 菜单中，有 1工具、2联系人、3相册、4播放器
        MenuItem tools = new MenuItem("工具");
        MenuItem contact = new MenuItem("联系人");
        MenuItem photo = new MenuItem("相册");
        MenuItem player = new MenuItem("播放器");
//        openMI.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
//        exitMI.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

        //如果菜单中的“工具”被选中，新打开窗口，显示两个标签页
        EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                String name = ((MenuItem) ae.getTarget()).getText();
                if (name.equals("工具")) {
//                    t.setText(name + "：被选中");
//                    rootBP.setTop(menuB);
                    rootBP.setCenter(tabPane);
//                    Scene scenetest = new Scene(rootBP, 230, 100);
//                    stage.setScene(scenetest);

//                    stage2.show();
//                    stage2.setScene(scene2);
                }
                if (name.equals("联系人")) {
//                    t.setText(name + "：被选中");
                    rootBP.setCenter(contactBP);

//                    stage3.show();
//                    stage3.setScene(scene3);
                }
                if (name.equals("相册")) {
//                    t.setText(name + "：被选中");
                    rootBP.setCenter(tabPane4);
//                    stage4.show();
//                    stage2.setScene(scene2);
                }
                if (name.equals("播放器")) {
//                    t.setText(name + "：被选中");
                    rootBP.setCenter(bPane);
//                    stage5.show();
//                    stage2.setScene(scene2);
                }
            }

        };


        tools.setOnAction(MEHandler);
        contact.setOnAction(MEHandler);
        photo.setOnAction(MEHandler);
        player.setOnAction(MEHandler);
        fileM.getItems().addAll(tools, contact, photo, player);

        menuB.getMenus().addAll(fileM);

        Scene scene = new Scene(rootBP, 1080, 720);
        stage.setTitle("菜单应用程序");
        stage.setScene(scene);
//        stage.show();


    }
}

class ClockEdge extends Pane {
    private double w, h;

    public ClockEdge() {
        this(200, 200);
        paint();
    }

    public ClockEdge(double w, double h) {
        this.w = w;
        this.h = h;
        paint();
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
        paint();
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
        paint();
    }

    public void paint() {
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        //假设一个字符宽7.6个像素，高8.8个像素
        Text text1 = new Text(centerX + clockRadius * Math.sin(1 * Math.PI / 6) - 7.6 + 1.7 * (1 + Math.cos(2 * Math.PI / 6)) - 2.2 * Math.sin(2 * Math.PI / 6),
                centerY - clockRadius * Math.cos(1 * Math.PI / 6) + 8.8 + 1.7 * Math.sin(2 * Math.PI / 6) - 2.2 * (1 - Math.cos(2 * Math.PI / 6)), "1");
        Text text2 = new Text(centerX + clockRadius * Math.sin(2 * Math.PI / 6) - 7.6 + 1.7 * (1 + Math.cos(4 * Math.PI / 6)) - 2.2 * Math.sin(4 * Math.PI / 6),
                centerY - clockRadius * Math.cos(2 * Math.PI / 6) + 8.8 + 1.7 * Math.sin(4 * Math.PI / 6) - 2.2 * (1 - Math.cos(4 * Math.PI / 6)), "2");
        Text text3 = new Text(centerX + clockRadius * Math.sin(3 * Math.PI / 6) - 7.6 + 1.7 * (1 + Math.cos(6 * Math.PI / 6)) - 2.2 * Math.sin(6 * Math.PI / 6),
                centerY - clockRadius * Math.cos(3 * Math.PI / 6) + 8.8 + 1.7 * Math.sin(6 * Math.PI / 6) - 2.2 * (1 - Math.cos(6 * Math.PI / 6)), "3");
        Text text4 = new Text(centerX + clockRadius * Math.sin(4 * Math.PI / 6) - 7.6 + 1.7 * (1 + Math.cos(8 * Math.PI / 6)) + 2.2 * Math.sin(8 * Math.PI / 6),
                centerY - clockRadius * Math.cos(4 * Math.PI / 6) + 1.7 * Math.sin(8 * Math.PI / 6) + 2.2 * (1 - Math.cos(8 * Math.PI / 6)), "4");
        Text text5 = new Text(centerX + clockRadius * Math.sin(5 * Math.PI / 6) - 7.6 + 1.7 * (1 + Math.cos(10 * Math.PI / 6)) + 2.2 * Math.sin(10 * Math.PI / 6),
                centerY - clockRadius * Math.cos(5 * Math.PI / 6) + 1.7 * Math.sin(10 * Math.PI / 6) + 2.2 * (1 - Math.cos(10 * Math.PI / 6)), "5");
        Text text6 = new Text(centerX + clockRadius * Math.sin(6 * Math.PI / 6) - 7.6 + 1.7 * (1 + Math.cos(12 * Math.PI / 6)) + 2.2 * Math.sin(12 * Math.PI / 6),
                centerY - clockRadius * Math.cos(6 * Math.PI / 6) + 1.7 * Math.sin(12 * Math.PI / 6) + 2.2 * (1 - Math.cos(12 * Math.PI / 6)), "6");
        Text text7 = new Text(centerX + clockRadius * Math.sin(7 * Math.PI / 6) - 1.7 * (1 + Math.cos(14 * Math.PI / 6)) + 2.2 * Math.sin(14 * Math.PI / 6),
                centerY - clockRadius * Math.cos(7 * Math.PI / 6) - 1.7 * Math.sin(14 * Math.PI / 6) + 2.2 * (1 - Math.cos(14 * Math.PI / 6)), "7");
        Text text8 = new Text(centerX + clockRadius * Math.sin(8 * Math.PI / 6) - 1.7 * (1 + Math.cos(16 * Math.PI / 6)) + 2.2 * Math.sin(16 * Math.PI / 6),
                centerY - clockRadius * Math.cos(8 * Math.PI / 6) - 1.7 * Math.sin(16 * Math.PI / 6) + 2.2 * (1 - Math.cos(16 * Math.PI / 6)), "8");
        Text text9 = new Text(centerX + clockRadius * Math.sin(9 * Math.PI / 6) - 1.7 * (1 + Math.cos(18 * Math.PI / 6)) + 2.2 * Math.sin(18 * Math.PI / 6),
                centerY - clockRadius * Math.cos(9 * Math.PI / 6) - 1.7 * Math.sin(18 * Math.PI / 6) + 2.2 * (1 - Math.cos(18 * Math.PI / 6)), "9");
        Text text10 = new Text(centerX + clockRadius * Math.sin(10 * Math.PI / 6) - 3.8 * (1 + Math.cos(20 * Math.PI / 6)) - 2.2 * Math.sin(20 * Math.PI / 6),
                centerY - clockRadius * Math.cos(10 * Math.PI / 6) + 8.8 - 3.8 * Math.sin(20 * Math.PI / 6) - 2.2 * (1 - Math.cos(20 * Math.PI / 6)), "10");
        Text text11 = new Text(centerX + clockRadius * Math.sin(11 * Math.PI / 6) - 3.8 * (1 + Math.cos(22 * Math.PI / 6)) - 2.2 * Math.sin(22 * Math.PI / 6),
                centerY - clockRadius * Math.cos(11 * Math.PI / 6) + 8.8 - 3.8 * Math.sin(22 * Math.PI / 6) - 2.2 * (1 - Math.cos(22 * Math.PI / 6)), "11");
        Text text12 = new Text(centerX + clockRadius * Math.sin(12 * Math.PI / 6) - 3.8 * (1 + Math.cos(24 * Math.PI / 6)) - 2.2 * Math.sin(24 * Math.PI / 6),
                centerY - clockRadius * Math.cos(12 * Math.PI / 6) + 8.8 - 3.8 * Math.sin(24 * Math.PI / 6) - 2.2 * (1 - Math.cos(24 * Math.PI / 6)), "12");
        getChildren().addAll(circle, text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12);
        for (int i = 1; i <= 60; i++) {
            double pointX1 = centerX + clockRadius * 0.95 * Math.sin(i * (2 * Math.PI) / 60);
            double pointY1 = centerY - clockRadius * 0.95 * Math.cos(i * (2 * Math.PI) / 60);
            double pointX2 = centerX + clockRadius * 1.0 * Math.sin(i * (2 * Math.PI) / 60);
            double pointY2 = centerY - clockRadius * 1.0 * Math.cos(i * (2 * Math.PI) / 60);
            if (i % 5 == 0) continue;
            else {
                Line point = new Line(pointX1, pointY1, pointX2, pointY2);
                getChildren().add(point);
            }
        }
    }

}

class ClockPointer extends Pane {
    private int hour;
    private int minute;
    private int second;
    private double w = 200, h = 200;

    public ClockPointer() {
        setCurrentTime();
    }

    public ClockPointer(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paint();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        paint();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        paint();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        paint();
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
        paint();
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
        paint();
    }

    public String setCurrentTime() {
        String str1, str2, str3;
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        str1 = String.valueOf(hour);
        str2 = String.valueOf(minute);
        str3 = String.valueOf(second);
        if (hour < 10) {
            str1 = "0" + hour;
        }
        if (minute < 10) {
            str2 = "0" + minute;
        }
        if (second < 10) {
            str3 = "0" + second;
        }
        paint();
        return str1 + " : " + str2 + " : " + str3;
    }

    protected void paint() {
        getChildren().clear();
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI) / 60);
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI) / 60);
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
        double mLength = clockRadius * 0.65;
        double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI) / 60);
        double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI) / 60);
        Line mLine = new Line(centerX, centerY, minuteX, minuteY);
        mLine.setStroke(Color.BLUE);
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength * Math.sin(hour * (2 * Math.PI) / 12);
        double hourY = centerY - hLength * Math.cos(hour * (2 * Math.PI) / 12);
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        mLine.setStroke(Color.GREEN);
        getChildren().addAll(sLine, mLine, hLine);
    }
}

class CalendarPanel extends Pane {
    private int year;
    private int month;
    private int day;
    private int firstDayOfWeek;
    private int totalDayOfMonth;

    public CalendarPanel() {

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        totalDayOfMonth = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        paint();
    }

    public void paint() {
        GridPane cp = new GridPane();
        String[] week = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        cp.setPadding(new Insets(30, 30, 10, 10));
        Text text1 = new Text(year + "年" + month + "月");
        text1.setStroke(Color.GREEN);
        cp.setAlignment(Pos.CENTER);
        cp.add(text1, 0, 0);
        GridPane.setColumnSpan(text1, 7);
        GridPane.setHalignment(text1, HPos.CENTER);
        for (int i = 0; i < 7; i++) {
            Label label = new Label(week[i]);
            if (i == 0 || i == 6) label.setTextFill(Color.RED);
            cp.add(label, i, 1);
            cp.getColumnConstraints().add(new ColumnConstraints(30));
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int j = 0; j < totalDayOfMonth; j++) {
            Label label = new Label(j + 1 + "");
            if (j + 1 == day) label.setFont(Font.font("Cooper Black", FontWeight.BOLD, 20));
            int k = firstDayOfWeek + j;
            if ((k % 7 == 0) || (k % 7 == 6)) label.setTextFill(Color.RED);
            cp.add(label, k % 7, 2 + k / 7);
            GridPane.setHalignment(label, HPos.RIGHT);
        }
        getChildren().add(cp);
    }

}
