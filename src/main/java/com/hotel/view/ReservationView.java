package com.hotel.view;


import com.hotel.model.Guest;
import com.hotel.model.Room;
import com.hotel.model.Reservation;
import com.hotel.model.ReservationStatus;

import com.hotel.repository.GuestRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.ReservationRepository;


import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.time.LocalDate;


public class ReservationView {


    private final GuestRepository guestRepository;

    private final RoomRepository roomRepository;

    private final ReservationRepository reservationRepository;


    private TableView<Reservation> table;


    public ReservationView() {

        guestRepository =
                new GuestRepository();

        roomRepository =
                new RoomRepository();

        reservationRepository =
                new ReservationRepository();


    }


    public VBox getRoot() {

        VBox root =
                new VBox(20);

        root.setStyle(
                "-fx-padding:30;"
        );

        Label title =
                new Label(
                        "Reservierungssystem"
                );

        title.setStyle(
                "-fx-font-size:25px;"
        );

        ComboBox<Guest> guests =
                new ComboBox<>();

        guests.setItems(

                FXCollections.observableArrayList(

                        guestRepository.findAll()

                )

        );

        guests.setPromptText(
                "Gast auswählen"
        );

        ComboBox<Room> rooms =
                new ComboBox<>();

        rooms.setItems(

                FXCollections.observableArrayList(

                        roomRepository.findAvailableRooms()

                )

        );

        rooms.setPromptText(
                "Zimmer auswählen"
        );

        DatePicker checkIn =
                new DatePicker();

        checkIn.setValue(
                LocalDate.now()
        );

        DatePicker checkOut =
                new DatePicker();

        checkOut.setValue(

                LocalDate.now()
                        .plusDays(1)

        );

        Button save =
                new Button(
                        "Reservierung erstellen"
                );

        save.setOnAction(e -> {

            Reservation reservation =
                    new Reservation();

            reservation.setGuest(

                    guests.getValue()

            );

            reservation.setRoom(

                    rooms.getValue()

            );

            reservation.setCheckIn(

                    checkIn.getValue()

            );

            reservation.setCheckOut(

                    checkOut.getValue()

            );

            reservation.setStatus(

                    ReservationStatus.CONFIRMED

            );

            reservationRepository.save(

                    reservation

            );

            loadTable();


        });

        table =
                new TableView<>();

        createColumns();

        loadTable();

        HBox form =
                new HBox(10);

        form.getChildren()
                .addAll(

                        guests,

                        rooms,

                        checkIn,

                        checkOut,

                        save

                );

        root.getChildren()
                .addAll(

                        title,

                        form,

                        table

                );

        return root;


    }


    private void createColumns() {

        TableColumn<Reservation, String> guest =
                new TableColumn<>(
                        "Gast"
                );

        guest.setCellValueFactory(

                c ->

                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getGuest()
                                        .getFirstName()

                                        + " "

                                        +

                                        c.getValue()
                                                .getGuest()
                                                .getLastName()

                        )

        );

        TableColumn<Reservation, String> room =
                new TableColumn<>(
                        "Zimmer"
                );

        room.setCellValueFactory(

                c ->

                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getRoom()
                                        .getRoomNumber()

                        )

        );

        TableColumn<Reservation, String> from =
                new TableColumn<>(
                        "Check-In"
                );

        from.setCellValueFactory(

                c ->

                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getCheckIn()
                                        .toString()

                        )

        );

        TableColumn<Reservation, String> to =
                new TableColumn<>(
                        "Check-Out"
                );

        to.setCellValueFactory(

                c ->

                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getCheckOut()
                                        .toString()

                        )

        );

        TableColumn<Reservation, String> status =
                new TableColumn<>(
                        "Status"
                );

        status.setCellValueFactory(

                c ->

                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getStatus()
                                        .name()

                        )

        );

        table.getColumns()
                .addAll(

                        guest,

                        room,

                        from,

                        to,

                        status

                );


    }


    private void loadTable() {

        table.getItems()
                .clear();

        table.getItems()
                .addAll(

                        reservationRepository.findAll()

                );


    }


}