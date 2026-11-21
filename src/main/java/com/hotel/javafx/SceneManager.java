package com.hotel.javafx;


import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneManager {


    private static Stage stage;


    public static void setStage(
            Stage primaryStage
    ) {

        stage = primaryStage;

    }


    public static void changeScene(
            Scene scene
    ) {

        stage.setScene(scene);

        stage.show();

    }


}