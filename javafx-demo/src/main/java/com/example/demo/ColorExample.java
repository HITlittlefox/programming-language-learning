package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ColorExample extends Application {
    @Override
    public void start(Stage stage) {
        //Drawing a Circle
        Circle circle = new Circle();

        //Setting the properties of the circle
        circle.setCenterX(300.0f);
        circle.setCenterY(180.0f);
        circle.setRadius(90.0f);

        //Setting color to the circle
        circle.setFill(Color.DARKRED);

        //Setting the stroke width
        circle.setStrokeWidth(3);

        //Setting color to the stroke
        circle.setStroke(Color.DARKSLATEBLUE);

        //Drawing a text
        Text text = new Text("This is a colored circle");

        //Setting the font of the text
        text.setFont(Font.font("Edwardian Script ITC", 50));

        //Setting the position of the text
        text.setX(155);
        text.setY(50);

        //Setting color to the text
        text.setFill(Color.BEIGE);
        text.setStrokeWidth(2);
        text.setStroke(Color.DARKSLATEBLUE);

        //Creating a Group object
        Group root = new Group(circle, text);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        //Setting title to the Stage
        stage.setTitle("Color Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}