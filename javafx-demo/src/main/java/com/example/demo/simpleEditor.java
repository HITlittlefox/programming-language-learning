package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;


public class simpleEditor extends Application {
    private Pagination pagination;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public int itemsPerPage() {
        return 3;
    }

    public VBox createPage(int pageIndex, StringBuilder input_string_raw, String[] input_string_array, String input_string) {

        //功能1：替换单词
        Button b1right = new Button("yes");

        //被替换字符
        Label b1_input_char1 = new Label("请输入被替换字符："); // 创建一个标签
        b1_input_char1.setStyle("-fx-font-size:16px;-fx-border-color:purple; -fx-padding:5px;-fx-border-width:thick");
        b1_input_char1.setPrefWidth(170);
        TextField b1_input1 = new TextField(); // 创建一个单行输入框
        b1_input1.setPrefSize(200, 50); // 设置单行输入框的推荐宽高
        b1_input1.setEditable(true); // 设置单行输入框能否编辑
        b1_input1.setPromptText("请输入被替换字符"); // 设置单行输入框的提示语

        b1_input1.setPrefWidth(150);//设置输入框宽度

        b1_input1.setPrefHeight(20);
        b1right.setPrefWidth(100);//设置按钮宽度
        b1_input_char1.setPrefHeight(60);
        b1_input1.setPrefHeight(60);

        //替换字符
        Label b1_input_char2 = new Label("请输入替换字符："); // 创建一个标签
        b1_input_char2.setStyle("-fx-font-size:16px;-fx-border-color:purple; -fx-padding:5px;-fx-border-width:thick");

        TextField b1_input2 = new TextField(); // 创建一个单行输入框
        b1_input2.setPrefSize(200, 50); // 设置单行输入框的推荐宽高
        b1_input2.setEditable(true); // 设置单行输入框能否编辑
        b1_input2.setPromptText("请输入替换字符"); // 设置单行输入框的提示语
        HBox b1_input_in_one = new HBox();
        b1_input2.setPrefWidth(150);//设置输入框宽度
        b1_input_char2.setPrefWidth(170);
        b1_input_char2.setPrefHeight(60);
        b1_input2.setPrefHeight(60);
        b1right.setPrefHeight(60);//设置按钮高度
        b1_input_in_one.getChildren().addAll(b1_input_char1, b1_input1, b1_input_char2, b1_input2, b1right);//设置一个label、一个input、一个confirm

        //两个框，一个初始值，一个结果框

        TextField be_replaced = new TextField();
        //Creating a Text object 为了存放初始值
        Text text = new Text();
        //Setting font to the text
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //这是第一个框，放着初始的文本（不会变）
        text.setText("导入的文本会出现在这里：" + input_string_raw);
        Group root = new Group(text);
        Text text_outup = new Text();
        text_outup.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //这是第二个框，放着处理后的文本（会变）
        //int pageIndex, StringBuilder input_string_raw, String[] input_string_array, String input_string

        //这一串代码可以把他们按照空格分隔打印出来，todo:改为一个string
        String init_input_string_array = new String();
        for (int i = 0; i < input_string_array.length; i++) {
            init_input_string_array = init_input_string_array + input_string_array[i] + " ";
            System.out.print(input_string_array[i] + " ");
        }


        //text_outup.setText("处理后的文本会出现在这里：" + input_string);
        text_outup.setText("处理后的文本会出现在这里：" + init_input_string_array);
        //Creating a Group object
        Group root_outup = new Group(text_outup);

        //当点击按钮b1时，控制台做如下处理
        b1right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了Button1");
                //获得输入框中的字符串
                String be_replaced = b1_input1.getText();
                String replaced = b1_input2.getText();
                String[] input_string_array_click1 = Arrays.copyOf(input_string_array, input_string_array.length);
                //按单词替换！
                for (int i = 0; i < input_string_array_click1.length; i++) {
                    if (Objects.equals(input_string_array_click1[i], be_replaced)) {
                        input_string_array_click1[i] = replaced;
                    }
                }
                StringBuilder input_string_replaced2 = new StringBuilder("");
                //把替换后的数组按顺序输出！
                System.out.println("单词替换后数组形态长度是:" + input_string_array_click1.length);
                for (int i = 0; i < input_string_array_click1.length; i++) {
                    input_string_replaced2.append(input_string_array_click1[i] + " ");
                }
                System.out.println("单词替换后的样子是：" + input_string_replaced2);
                text_outup.setText("单词替换后的样子是：" + input_string_replaced2);
            }
        });
        //一页中的行数
        VBox box = new VBox(5);
        VBox element = new VBox();
        Label text_in = new Label("功能1：替换单词！");
        text_in.setStyle("-fx-font-size:20px;-fx-border-color:red; -fx-padding:6px;-fx-border-width:thick");
        //内容拼接
        element.getChildren().addAll(text_in, b1_input_in_one, root, root_outup);
        box.getChildren().add(element);
        return box;
    }

    public VBox createPage2(int pageIndex, StringBuilder input_string_raw, String[] input_string_array, String input_string) {

        //功能2：统计某个单词的个数！
        Button b2right = new Button("yes");
        Label b2_input_char = new Label("请输入统计字符："); // 创建一个标签
        TextField b2_input = new TextField(); // 创建一个单行输入框
        b2_input.setPrefSize(200, 50); // 设置单行输入框的推荐宽高
        b2_input.setEditable(true); // 设置单行输入框能否编辑
        b2_input.setPromptText("请输入统计字符"); // 设置单行输入框的提示语

        b2_input_char.setStyle("-fx-font-size:16px;-fx-border-color:purple; -fx-padding:5px;-fx-border-width:thick");
        HBox b2_input_in_one = new HBox();
        b2_input_char.setPrefWidth(150);
        b2_input.setPrefWidth(150);
//        b2_input.setPrefHeight(20);
        b2right.setPrefWidth(100);//设置按钮宽度
        b2_input_char.setPrefHeight(60);
        b2_input.setPrefHeight(60);
        b2right.setPrefHeight(60);//设置按钮高度
//        b2_input_in_one.setPadding(new Insets(10, 10, 10, 10));//设置按钮与上右下左边缘留出10px距离
        b2_input_in_one.getChildren().addAll(b2_input_char, b2_input, b2right);//设置一个label、一个input、一个confirm

        //两个框，一个初始值，一个结果框

        TextField be_replaced = new TextField();
        //Creating a Text object 为了存放初始值
        Text text = new Text();
        //Setting font to the text
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //这是第一个框，放着初始的文本（不会变）
        text.setText("导入的文本会出现在这里：" + input_string_raw);
        Group root = new Group(text);
        Text text_outup = new Text();
        text_outup.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //这是第二个框，放着处理后的文本（会变）
        //int pageIndex, StringBuilder input_string_raw, String[] input_string_array, String input_string

        //这一串代码可以把他们按照空格分隔打印出来，todo:改为一个string
        String init_input_string_array = new String();
        for (int i = 0; i < input_string_array.length; i++) {
            init_input_string_array = init_input_string_array + input_string_array[i] + " ";
            System.out.print(input_string_array[i] + " ");
        }


        //text_outup.setText("处理后的文本会出现在这里：" + input_string);
        text_outup.setText("处理后的文本会出现在这里：" + init_input_string_array);
        //Creating a Group object
        Group root_outup = new Group(text_outup);
        //当点击按钮b2时，控制台做如下处理
        b2right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了Button2");
                String[] input_string_array_click2 = Arrays.copyOf(input_string_array, input_string_array.length);
                String temp = b2_input.getText();
                System.out.println("这是输入的内容！！：" + temp);
                char[] aim_string = temp.toCharArray();
                //按单词统计
                //把temp和数组每一项对比，如果相同，count+1
                int count = 0;
                for (String i : input_string_array_click2) {
                    if (Objects.equals(i, temp)) {
                        count++;
                    }
                }
                System.out.println(count);
                text_outup.setText("在原文本中， " + temp + " 出现的次数是：" + count);
            }
        });
        //一页中的行数
        VBox box = new VBox(5);
        VBox element = new VBox();
        Label text_in = new Label("功能2：统计某个单词的个数！");
        text_in.setStyle("-fx-font-size:20px;-fx-border-color:red; -fx-padding:6px;-fx-border-width:thick");
        //内容拼接
        element.getChildren().addAll(text_in, b2_input_in_one, root, root_outup);
        box.getChildren().add(element);
        return box;
    }

    public VBox createPage3(int pageIndex, StringBuilder input_string_raw, String[] input_string_array, String input_string) {

        //功能3：反向输出
        Button b3right = new Button("点击此按钮，按单词反向输出原字段");

        b3right.setPrefHeight(60);//设置按钮高度

        //两个框，一个初始值，一个结果框

        TextField be_replaced = new TextField();
        //Creating a Text object 为了存放初始值
        Text text = new Text();
        //Setting font to the text
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //这是第一个框，放着初始的文本（不会变）
        text.setText("导入的文本会出现在这里：" + input_string_raw);
        Group root = new Group(text);
        Text text_outup = new Text();
        text_outup.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //这是第二个框，放着处理后的文本（会变）
        //int pageIndex, StringBuilder input_string_raw, String[] input_string_array, String input_string

        //这一串代码可以把他们按照空格分隔打印出来，todo:改为一个string
        String init_input_string_array = new String();
        for (int i = 0; i < input_string_array.length; i++) {
            init_input_string_array = init_input_string_array + input_string_array[i] + " ";
            System.out.print(input_string_array[i] + " ");
        }


        //text_outup.setText("处理后的文本会出现在这里：" + input_string);
        text_outup.setText("处理后的文本会出现在这里：" + init_input_string_array);
        //Creating a Group object
        Group root_outup = new Group(text_outup);
        //当点击按钮b3right时，控制台做如下处理
        b3right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了Button3");
                StringBuilder input_string_reverse = new StringBuilder();
                String[] input_string_array_click3 = Arrays.copyOf(input_string_array, input_string_array.length);

                //按单词倒序输出！
                for (int i = input_string_array_click3.length - 1; i >= 0; i--) {
//                    System.out.println(input_string_array_click3[i]);
                    input_string_reverse.append(input_string_array_click3[i]).append(" ");

                }
                System.out.println(input_string_reverse);

//                //todo:循环遍历整个字符串，从最大值反转

                text_outup.setText("原文本按单词倒序输出：" + input_string_reverse);
            }
        });

        //一页中的行数
        VBox box = new VBox(5);
        VBox element = new VBox();
        Label text_in = new Label("功能3：按单词反向输出！");
        text_in.setStyle("-fx-font-size:20px;-fx-border-color:red; -fx-padding:6px;-fx-border-width:thick");
        //内容拼接
        element.getChildren().addAll(text_in, b3right, root, root_outup);
        box.getChildren().add(element);
        return box;
    }

    @Override
    public void start(final Stage stage) throws Exception {


        //获得文本 StringBuilder input_string_raw String[] input_string_array
        //原始字符串需要导入txt文件显示
        //可以从外部导入txt文本；也可以直接写出来。

        //这里直接把文本写出来了，防止出现导入路径错误的麻烦
        String data_in = "i love you. i know \"i love u and him\"...\n" +
                "\n" +
                "need some relax";
        //需要写绝对路径！
        String fileName = "C:\\Users\\96361\\Desktop\\javafx-demo\\src\\main\\java\\com\\example\\demo\\data.txt", line;

        StringBuilder input_string_raw = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
//            BufferedReader in = new BufferedReader(new FileReader(data_in));
            line = in.readLine();   //读取一行内容
            while (line != null) {
                //System.out.println(line);
                input_string_raw.append(line);
                line = in.readLine();
            }
            System.out.println("您导入的data.txt文件中的字符串是:" + input_string_raw);
            in.close();
        } catch (IOException iox) {
            System.out.println("Problem reading " + fileName);
        }


        //把文章的所有标点替换为空格！然后再用空格分割！
        String input_string = input_string_raw.toString();
        String str = "[`\\\\~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%…&*（）——+|{}【】‘；：”“’。，、？\"]";
        String input_string_replaced = data_in.replaceAll(str, " ");
        System.out.println("被替换符号后是:" + input_string_replaced);

        //用空格分割！
        //获得数组
        String[] input_string_array = input_string_replaced.split("\\s+");
        System.out.println("被分割后的数组形态是:" + input_string_array);
        System.out.println("数组形态长度是:" + input_string_array.length);


        ///至此，已经获得文本，下面开始操作。

        //总页数
        pagination = new Pagination(3, 0);
        pagination.setStyle("-fx-border-color:red;");
        //pagination.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
        //用一个判断带着三个页面的填充，分别对应着三个方法
        pagination.setPageFactory((Integer pageIndex) -> {
            if (pageIndex > 0 & pageIndex < 2) {
                return createPage2(pageIndex, input_string_raw, input_string_array, input_string);
            } else if (pageIndex > 1) {
                return createPage3(pageIndex, input_string_raw, input_string_array, input_string);
            }
            return createPage(pageIndex, input_string_raw, input_string_array, input_string);
        });


        AnchorPane anchor = new AnchorPane();
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().addAll(pagination);
        Scene scene = new Scene(anchor);
        stage.setScene(scene);
        stage.setTitle("PaginationSample");
        stage.show();
    }


}