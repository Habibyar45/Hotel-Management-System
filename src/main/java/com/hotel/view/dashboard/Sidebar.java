package com.hotel.view.dashboard;

import com.hotel.view.CheckInOutView;
import com.hotel.javafx.SceneManager;
import com.hotel.view.GuestView;
import com.hotel.view.RoomView;
import com.hotel.view.ReservationView;
import com.hotel.view.InvoiceView;
import com.hotel.javafx.LoginApplication;
import javafx.application.Platform;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;



public class Sidebar {


    private VBox root;

    public VBox create(){


        VBox box =
                new VBox(15);



        box.getStyleClass()
                .add("sidebar");



        Label user =
                new Label(
                        "Admin"
                );



        Button dashboard =
                new Button(
                        "Dashboard"
                );

        Button frontDesk =
                new Button(
                        "Check-in / Check-out"
                );
        frontDesk.setOnAction(e->{


            CheckInOutView view =
                    new CheckInOutView();


            Scene scene =
                    new Scene(

                            view.getRoot(),

                            1200,

                            800

                    );


            SceneManager.changeScene(
                    scene
            );


        });

        Button guests =
                new Button(
                        "Gäste"
                );



        Button rooms =
                new Button(
                        "Zimmer"
                );



        Button reservations =
                new Button(
                        "Reservierungen"
                );



        Button invoices =
                new Button(
                        "Rechnungen"
                );


        Button logout =
                new Button(
                        "Logout"
                );

        logout.setOnAction(e->{


            Platform.exit();


        });

        dashboard.setOnAction(e->{


        });



        guests.setOnAction(e->{


            GuestView view =
                    new GuestView();


            Scene scene =
                    new Scene(
                            view.getRoot(),
                            1200,
                            800
                    );


            SceneManager.changeScene(scene);


        });





        rooms.setOnAction(e->{


            RoomView view =
                    new RoomView();



            Scene scene =
                    new Scene(
                            view.getRoot(),
                            1200,
                            800
                    );



            SceneManager.changeScene(scene);


        });





        reservations.setOnAction(e->{


            ReservationView view =
                    new ReservationView();



            Scene scene =
                    new Scene(
                            view.getRoot(),
                            1200,
                            800
                    );



            SceneManager.changeScene(scene);


        });






        invoices.setOnAction(e->{


            InvoiceView view =
                    new InvoiceView();



            Scene scene =
                    new Scene(
                            view.getRoot(),
                            1200,
                            800
                    );



            SceneManager.changeScene(scene);


        });






        box.getChildren()
                .addAll(

                        dashboard,

                        guests,

                        rooms,

                        reservations,

                        frontDesk,

                        invoices,

                        logout

                );



        return box;


    }

    public VBox getRoot(){

        return root;

    }



}