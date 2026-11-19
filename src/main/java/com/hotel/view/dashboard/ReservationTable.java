package com.hotel.view.dashboard;


import com.hotel.model.Reservation;
import com.hotel.repository.ReservationRepository;

import javafx.geometry.Insets;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



public class ReservationTable {



    public TableView<Reservation> create(){



        TableView<Reservation> table =
                new TableView<>();


        table.setPrefHeight(250);

        table.setPadding(
                new Insets(10)
        );




        TableColumn<Reservation,String> guestColumn =
                new TableColumn<>("Gast");



        guestColumn.setCellValueFactory(cell ->


                new SimpleStringProperty(

                        cell.getValue()
                                .getGuest()
                                .getFirstName()

                                + " "

                                +

                                cell.getValue()
                                        .getGuest()
                                        .getLastName()

                )

        );


        guestColumn.setPrefWidth(180);






        TableColumn<Reservation,String> roomColumn =
                new TableColumn<>("Zimmer");



        roomColumn.setCellValueFactory(cell ->


                new SimpleStringProperty(

                        cell.getValue()
                                .getRoom()
                                .getRoomNumber()

                )

        );


        roomColumn.setPrefWidth(100);








        TableColumn<Reservation,String> checkInColumn =
                new TableColumn<>("Check-In");



        checkInColumn.setCellValueFactory(cell ->


                new SimpleStringProperty(

                        cell.getValue()
                                .getCheckIn()
                                .toString()

                )

        );


        checkInColumn.setPrefWidth(130);








        TableColumn<Reservation,String> checkOutColumn =
                new TableColumn<>("Check-Out");



        checkOutColumn.setCellValueFactory(cell ->


                new SimpleStringProperty(

                        cell.getValue()
                                .getCheckOut()
                                .toString()

                )

        );


        checkOutColumn.setPrefWidth(130);







        TableColumn<Reservation,String> statusColumn =
                new TableColumn<>("Status");



        statusColumn.setCellValueFactory(cell ->


                new SimpleStringProperty(

                        cell.getValue()
                                .getStatus()
                                .name()

                )

        );


        statusColumn.setPrefWidth(150);






        table.getColumns()
                .addAll(

                        guestColumn,

                        roomColumn,

                        checkInColumn,

                        checkOutColumn,

                        statusColumn

                );






        ReservationRepository repository =
                new ReservationRepository();




        table.getItems()
                .addAll(

                        repository.findAll()

                );





        return table;


    }


}