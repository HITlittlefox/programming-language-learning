package com.example.demo;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;


import javafx.scene.text.Text;

import java.io.*;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //原始字符串需要导入txt文件显示
        String fileName = "src/main/java/com/example/demo1/data.txt", line;
        StringBuilder input_string = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            line = in.readLine();   //读取一行内容
            while (line != null) {
                System.out.println(line);
                input_string.append(line);
                line = in.readLine();
            }
            System.out.println("您导入的data.txt文件中的字符串是:" + input_string);
            in.close();
        } catch (IOException iox) {
            System.out.println("Problem reading " + fileName);
        }
        //把文章的所有标点替换为空格！然后再用空格分割！



        HBox hBox = new HBox();    //设置水平根节点
        hBox.setPadding(new Insets(10, 10, 10, 10));//设置按钮与上右下左边缘留出10px距离
        //设置三个按钮
        Button b1 = new Button("单词替换");
        Button b2 = new Button("单词统计");
        Button b3 = new Button("文字逆向输出");


        Button b1right = new Button("yes");

        //被替换字符
        Label b1_input_char1 = new Label("被替换字符："); // 创建一个标签
        TextField b1_input1 = new TextField(); // 创建一个单行输入框
        b1_input1.setPrefSize(200, 50); // 设置单行输入框的推荐宽高
        b1_input1.setEditable(true); // 设置单行输入框能否编辑
        b1_input1.setPromptText("被替换字符"); // 设置单行输入框的提示语

        b1_input1.setPrefWidth(150);//设置输入框宽度

        b1_input1.setPrefHeight(20);
        b1right.setPrefWidth(100);//设置按钮宽度
        b1_input_char1.setPrefWidth(120);


        //替换字符
        Label b1_input_char2 = new Label("替换字符："); // 创建一个标签
        TextField b1_input2 = new TextField(); // 创建一个单行输入框
        b1_input2.setPrefSize(200, 50); // 设置单行输入框的推荐宽高
        b1_input2.setEditable(true); // 设置单行输入框能否编辑
        b1_input2.setPromptText("替换字符"); // 设置单行输入框的提示语
        HBox b1_input_in_one = new HBox();
        b1_input2.setPrefWidth(150);//设置输入框宽度
        b1_input2.setPrefHeight(20);
        b1_input_char2.setPrefWidth(120);

        b1_input_in_one.getChildren().addAll(b1_input_char1, b1_input1, b1_input_char2, b1_input2, b1right);//设置一个label、一个input、一个confirm


        Button b2right = new Button("yes");
        Label b2_input_char = new Label("请输入统计字符："); // 创建一个标签
        TextField b2_input = new TextField(); // 创建一个单行输入框
        b2_input.setPrefSize(200, 50); // 设置单行输入框的推荐宽高
        b2_input.setEditable(true); // 设置单行输入框能否编辑
        b2_input.setPromptText("请输入统计字符"); // 设置单行输入框的提示语
        HBox b2_input_in_one = new HBox();
        b2_input_char.setPrefWidth(120);
        b2_input.setPrefWidth(150);
        b2_input.setPrefHeight(20);
        b2right.setPrefWidth(100);//设置按钮宽度
//        b2_input_in_one.setPadding(new Insets(10, 10, 10, 10));//设置按钮与上右下左边缘留出10px距离
        b2_input_in_one.getChildren().addAll(b2_input_char, b2_input, b2right);//设置一个label、一个input、一个confirm

        Button b3right = new Button("点击此按钮，逆向输出原字段");

        TextField be_replaced = new TextField();
        //TextField.getText().trim();

        //Creating a Text object 为了存放初始值
        Text text = new Text();

        //Setting font to the text
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Setting the text to be added.
        text.setText(String.valueOf(input_string));


        //Creating a Group object
        Group root = new Group(text);

        //Creating second Text object 为了存放结果
        Text text_outup = new Text();

        //Setting font to the text
        text_outup.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Setting the text to be added.
        text_outup.setText(String.valueOf(input_string));


        //Creating a Group object
        Group root_outup = new Group(text_outup);


        //当点击按钮b1时，控制台做如下处理
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了Button1");

                //获得文本框中的字符串
                System.out.println("获得文本框中的原字符串" + text.getText());
                String text_string = text.getText();

                text_string = text_string.replaceAll("A", "B");
                System.out.println("修改后文本框中的字符串" + text_string);
                text_outup.setText(text_string);

            }
        });
        //当点击按钮b2时，控制台做如下处理
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了Button2");

                //获得文本框中的字符串
                System.out.println("获得文本框中的原字符串" + text.getText());
                String text_string = text.getText();

                char aim_string = 'A';
                int number_of_aim_string = 0;
                //todo:循环遍历整个字符串
                for (int i = 0; i < text_string.length(); i++) {
                    System.out.println(text_string.charAt(i) + " ");
                    if (text_string.charAt(i) == aim_string) {
                        number_of_aim_string++;
                    }
                }
                System.out.println("该字符" + aim_string + "出现的次数为：" + number_of_aim_string);
                text_outup.setText(String.valueOf(number_of_aim_string));


            }
        });
        //当点击按钮b3时，控制台做如下处理
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了Button3");

                //获得文本框中的字符串
                System.out.println("获得文本框中的原字符串" + text.getText());
                String text_string = text.getText();
                StringBuilder text_reverse = new StringBuilder();
                //todo:循环遍历整个字符串，从最大值反转
                for (int i = text_string.length() - 1; i >= 0; i--) {
                    //System.out.println(text_string.charAt(i));
                    text_reverse.append(text_string.charAt(i));

                }
                System.out.println("转换后的字符：" + text_reverse);
                System.out.println(String.valueOf(text_reverse));

                text_outup.setText(String.valueOf(text_reverse));
            }
        });

        //当点击按钮b1时，控制台做如下处理
        b1right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了Button1");

                //获得文本框中的字符串
                System.out.println("获得文本框中的原字符串" + text.getText());
                String text_string = text.getText();

                String be_replaced = b1_input1.getText();
                String replaced = b1_input2.getText();


                text_string = text_string.replaceAll(be_replaced, replaced);
                System.out.println("修改后文本框中的字符串" + text_string);
                text_outup.setText(text_string);

            }
        });
        //当点击按钮b2时，控制台做如下处理
        b2right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了Button2");

                //获得文本框中的字符串
                System.out.println("获得文本框中的原字符串" + text.getText());
                String text_string = text.getText();
                String temp = b2_input.getText();
                System.out.println("这是输入的内容！！：" + temp);
                char[] aim_string = temp.toCharArray();

                int number_of_aim_string = 0;
                //todo:循环遍历整个字符串
                for (int i = 0; i < text_string.length(); i++) {
                    System.out.println(text_string.charAt(i) + " ");
                    if (text_string.charAt(i) == aim_string[0]) {
                        number_of_aim_string++;
                    }
                }
                System.out.println("该字符" + aim_string + "出现的次数为：" + number_of_aim_string);
                text_outup.setText(String.valueOf(number_of_aim_string));


            }
        });
        //当点击按钮b3时，控制台做如下处理
        b3right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了Button3");

                //获得文本框中的字符串
                System.out.println("获得文本框中的原字符串" + text.getText());
                String text_string = text.getText();
                StringBuilder text_reverse = new StringBuilder();
                //todo:循环遍历整个字符串，从最大值反转
                for (int i = text_string.length() - 1; i >= 0; i--) {
                    //System.out.println(text_string.charAt(i));
                    text_reverse.append(text_string.charAt(i));

                }
                System.out.println("转换后的字符：" + text_reverse);
                System.out.println(String.valueOf(text_reverse));

                text_outup.setText(String.valueOf(text_reverse));
            }
        });
        hBox.getChildren().addAll(b1, b2, b3);//设置三个按钮和一个文本框水平呈现

        b1.setPrefWidth(200);//设置按钮b1宽度为100
        b2.setPrefWidth(200);//设置按钮b2宽度为100
        b3.setPrefWidth(200);//设置按钮b3宽度为100

        b3right.setPrefWidth(200);
        //Instantiating the VBox class
        VBox vBox = new VBox();

        //Setting the space between the nodes of a VBox pane
        vBox.setSpacing(10);

        //Setting the margin to the nodes
        vBox.setMargin(hBox, new Insets(20, 20, 20, 20));

        vBox.setMargin(b1_input_in_one, new Insets(20, 20, 20, 220));

        vBox.setMargin(b2_input_in_one, new Insets(20, 20, 20, 220));
        vBox.setMargin(b3right, new Insets(20, 20, 20, 220));
        vBox.setMargin(root, new Insets(100, 20, 20, 250));
        vBox.setMargin(root_outup, new Insets(100, 20, 20, 250));


        //retrieving the observable list of the VBox
        ObservableList list = vBox.getChildren();


        //横着三个，竖着两个。分别用hBox和vBox
        //Adding all the nodes to the observable list
        list.addAll(hBox, b1_input_in_one, b2_input_in_one, b3right, root, root_outup);


        //Setting title to the Stage
        stage.setTitle("Sample Application");

        //Adding scene to the stage
        stage.setScene(new Scene(vBox, 1280, 720));

        //Displaying the contents of the stage
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}