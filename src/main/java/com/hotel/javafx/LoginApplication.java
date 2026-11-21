package com.hotel.javafx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.hotel.view.LoginView;


public class LoginApplication extends Application {


    @Override
    public void start(Stage stage) {

        LoginView view =
                new LoginView(stage);

        Scene scene =
                new Scene(
                        view.getRoot(),
                        400,
                        300
                );

        scene.getStylesheets()
                .add(
                        getClass()
                                .getResource(
                                        "/style.css"
                                )
                                .toExternalForm()
                );

        stage.setTitle(
                "Hotel Management System"
        );

        stage.setScene(scene);

        stage.show();


    }


}