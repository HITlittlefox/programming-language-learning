package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        //Creating an image
        Image image = new Image(new FileInputStream("file path"));

        //Setting the image view 1
        ImageView imageView1 = new ImageView(image);

        //Setting the position of the image
        imageView1.setX(50);
        imageView1.setY(25);

        //setting the fit height and width of the image view
        imageView1.setFitHeight(300);
        imageView1.setFitWidth(250);

        //Setting the preserve ratio of the image view
        imageView1.setPreserveRatio(true);

        //Setting the image view 2
        ImageView imageView2 = new ImageView(image);

        //Setting the position of the image
        imageView2.setX(350);
        imageView2.setY(25);

        //setting the fit height and width of the image view
        imageView2.setFitHeight(150);
        imageView2.setFitWidth(250);

        //Setting the preserve ratio of the image view
        imageView2.setPreserveRatio(true);

        //Setting the image view 3
        ImageView imageView3 = new ImageView(image);

        //Setting the position of the image
        imageView3.setX(350);
        imageView3.setY(200);

        //setting the fit height and width of the image view
        imageView3.setFitHeight(100);
        imageView3.setFitWidth(100);

        //Setting the preserve ratio of the image view
        imageView3.setPreserveRatio(true);

        //Creating a Group object
        Group root = new Group(imageView1, imageView2, imageView3);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 400);

        //Setting title to the Stage
        stage.setTitle("Multiple views of an image");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}