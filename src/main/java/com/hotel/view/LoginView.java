package com.hotel.view;

import com.hotel.view.dashboard.DashboardView;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;


import com.hotel.javafx.SceneManager;
import com.hotel.service.LoginService;



public class LoginView {



    private VBox root;



    private final LoginService loginService;





    public LoginView(Stage stage){


        SceneManager.setStage(stage);


        loginService =
                new LoginService();




        root =
                new VBox(15);



        root.setStyle(
                "-fx-padding:40;"
        );




        Label title =
                new Label(
                        "Hotel Login"
                );



        TextField username =
                new TextField();


        username.setPromptText(
                "Username"
        );




        PasswordField password =
                new PasswordField();


        password.setPromptText(
                "Password"
        );




        Button login =
                new Button(
                        "Login"
                );



        Label message =
                new Label();




        login.setOnAction(e->{



            boolean success =
                    loginService.login(

                            username.getText(),

                            password.getText()

                    );




            if(success){



                DashboardView dashboard =
                        new DashboardView();




                Scene scene =
                        new Scene(

                                dashboard.getRoot(),

                                1200,

                                800

                        );




                SceneManager.changeScene(
                        scene
                );



            }

            else{


                message.setText(
                        "Username oder Passwort falsch!"
                );


            }



        });






        root.getChildren()
                .addAll(

                        title,

                        username,

                        password,

                        login,

                        message

                );


    }






    public VBox getRoot(){

        return root;

    }


}