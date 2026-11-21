package com.hotel.view;


import com.hotel.model.Reservation;
import com.hotel.model.ReservationStatus;
import com.hotel.model.RoomStatus;

import com.hotel.repository.ReservationRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.service.CheckOutService;


import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class CheckInOutView {


    private final ReservationRepository reservationRepository;

    private final RoomRepository roomRepository;

    private final CheckOutService checkOutService;


    private TableView<Reservation> table;


    public CheckInOutView() {

        reservationRepository =
                new ReservationRepository();

        roomRepository =
                new RoomRepository();

        checkOutService =
                new CheckOutService();


    }


    public VBox getRoot() {

        VBox root =
                new VBox(20);

        root.setStyle(
                "-fx-padding:30;"
        );

        Label title =
                new Label(
                        "Check-in / Check-out"
                );

        title.setStyle(
                "-fx-font-size:25px;"
        );

        table =
                new TableView<>();

        createColumns();

        loadData();

        Button checkIn =
                new Button(
                        "Check-In"
                );

        checkIn.setOnAction(e -> {

            Reservation selected =
                    table.getSelectionModel()
                            .getSelectedItem();

            if (selected != null) {

                reservationRepository.updateStatus(

                        selected.getReservationId(),

                        ReservationStatus.CHECKED_IN

                );

                roomRepository.updateStatus(

                        selected.getRoom()
                                .getRoomId(),

                        RoomStatus.OCCUPIED

                );

                loadData();


            }


        });

        Button checkOut =
                new Button(
                        "Check-Out"
                );

        checkOut.setOnAction(e -> {

            Reservation selected =
                    table.getSelectionModel()
                            .getSelectedItem();

            if (selected != null) {

                checkOutService.checkOut(

                        selected.getReservationId(),

                        selected.getRoom()
                                .getRoomId()

                );

                loadData();


            }


        });

        HBox buttons =
                new HBox(15);

        buttons.getChildren()
                .addAll(

                        checkIn,

                        checkOut

                );

        root.getChildren()
                .addAll(

                        title,

                        table,

                        buttons

                );

        return root;


    }


    private void createColumns() {

        TableColumn<Reservation, String> guest =
                new TableColumn<>(
                        "Gast"
                );

        guest.setCellValueFactory(

                cell ->

                        new javafx.beans.property.SimpleStringProperty(

                                cell.getValue()
                                        .getGuest()
                                        .getFirstName()

                                        + " " +

                                        cell.getValue()
                                                .getGuest()
                                                .getLastName()

                        )

        );

        TableColumn<Reservation, String> room =
                new TableColumn<>(
                        "Zimmer"
                );

        room.setCellValueFactory(

                cell ->

                        new javafx.beans.property.SimpleStringProperty(

                                cell.getValue()
                                        .getRoom()
                                        .getRoomNumber()

                        )

        );

        TableColumn<Reservation, String> status =
                new TableColumn<>(
                        "Status"
                );

        status.setCellValueFactory(

                cell ->

                        new javafx.beans.property.SimpleStringProperty(

                                cell.getValue()
                                        .getStatus()
                                        .name()

                        )

        );

        table.getColumns()
                .addAll(

                        guest,

                        room,

                        status

                );


    }


    private void loadData() {

        table.setItems(

                FXCollections.observableArrayList(

                        reservationRepository.findAll()

                )

        );


    }


}