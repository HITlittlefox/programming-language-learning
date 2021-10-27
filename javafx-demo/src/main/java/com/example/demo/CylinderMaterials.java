package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.stage.Stage;

public class CylinderMaterials extends Application {
    @Override
    public void start(Stage stage) {
        //Drawing Cylinder1
        Cylinder cylinder1 = new Cylinder();

        //Setting the properties of the Cylinder
        cylinder1.setHeight(130.0f);
        cylinder1.setRadius(30.0f);

        //Setting the position of the Cylinder
        cylinder1.setTranslateX(100);
        cylinder1.setTranslateY(75);

        //Preparing the phong material of type bump map
        PhongMaterial material1 = new PhongMaterial();
        material1.setBumpMap(new Image
                ("http://www.tutorialspoint.com/images/tplogo.gif"));

        //Setting the bump map material to Cylinder1
        cylinder1.setMaterial(material1);

        //Drawing Cylinder2
        Cylinder cylinder2 = new Cylinder();

        //Setting the properties of the Cylinder
        cylinder2.setHeight(130.0f);
        cylinder2.setRadius(30.0f);

        //Setting the position of the Cylinder
        cylinder2.setTranslateX(200);
        cylinder2.setTranslateY(75);

        //Preparing the phong material of type diffuse map
        PhongMaterial material2 = new PhongMaterial();
        material2.setDiffuseMap(new Image
                ("http://www.tutorialspoint.com/images/tp-logo.gif"));

        //Setting the diffuse map material to Cylinder2
        cylinder2.setMaterial(material2);

        //Drawing Cylinder3
        Cylinder cylinder3 = new Cylinder();

        //Setting the properties of the Cylinder
        cylinder3.setHeight(130.0f);
        cylinder3.setRadius(30.0f);

        //Setting the position of the Cylinder
        cylinder3.setTranslateX(300);
        cylinder3.setTranslateY(75);

        //Preparing the phong material of type Self Illumination Map
        PhongMaterial material3 = new PhongMaterial();
        material3.setSelfIlluminationMap(new Image
                ("http://www.tutorialspoint.com/images/tp-logo.gif"));

        //Setting the Self Illumination Map material to Cylinder3
        cylinder3.setMaterial(material3);

        //Drawing Cylinder4
        Cylinder cylinder4 = new Cylinder();

        //Setting the properties of the Cylinder
        cylinder4.setHeight(130.0f);
        cylinder4.setRadius(30.0f);

        //Setting the position of the Cylinder
        cylinder4.setTranslateX(400);
        cylinder4.setTranslateY(75);

        //Preparing the phong material of type Specular Map
        PhongMaterial material4 = new PhongMaterial();
        material4.setSpecularMap(new Image
                ("http://www.tutorialspoint.com/images/tp-logo.gif"));

        //Setting the Specular Map material to Cylinder4
        cylinder4.setMaterial(material4);

        //Drawing Cylinder5
        Cylinder cylinder5 = new Cylinder();

        //Setting the properties of the Cylinder
        cylinder5.setHeight(130.0f);
        cylinder5.setRadius(30.0f);

        //Setting the position of the Cylinder
        cylinder5.setTranslateX(100);
        cylinder5.setTranslateY(300);

        //Preparing the phong material of type diffuse color
        PhongMaterial material5 = new PhongMaterial();
        material5.setDiffuseColor(Color.BLANCHEDALMOND);

        //Setting the diffuse color material to Cylinder5
        cylinder5.setMaterial(material5);

        //Drawing Cylinder6
        Cylinder cylinder6 = new Cylinder();

        //Setting the properties of the Cylinder
        cylinder6.setHeight(130.0f);
        cylinder6.setRadius(30.0f);

        //Setting the position of the Cylinder
        cylinder6.setTranslateX(200);
        cylinder6.setTranslateY(300);

        //Preparing the phong material of type specular color
        PhongMaterial material6 = new PhongMaterial();

        //setting the specular color map to the material
        material6.setSpecularColor(Color.BLANCHEDALMOND);

        //Setting the specular color material to Cylinder6
        cylinder6.setMaterial(material6);

        //Drawing Cylinder7
        Cylinder cylinder7 = new Cylinder();

        //Setting the properties of the Cylinder
        cylinder7.setHeight(130.0f);
        cylinder7.setRadius(30.0f);

        //Setting the position of the Cylinder
        cylinder7.setTranslateX(300);
        cylinder7.setTranslateY(300);

        //Preparing the phong material of type Specular Power
        PhongMaterial material7 = new PhongMaterial();
        material7.setSpecularPower(0.1);

        //Setting the Specular Power material to the Cylinder
        cylinder7.setMaterial(material7);

        //Creating a Group object
        Group root = new Group(cylinder1, cylinder2, cylinder3,
                cylinder4, cylinder5, cylinder6, cylinder7);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 400);

        //Setting camera
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(-10);
        scene.setCamera(camera);

        //Setting title to the Stage
        stage.setTitle("Drawing a cylinder");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}