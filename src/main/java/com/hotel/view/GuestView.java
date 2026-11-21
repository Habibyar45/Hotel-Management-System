package com.hotel.view;


import com.hotel.model.Guest;
import com.hotel.repository.GuestRepository;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.*;
import javafx.scene.layout.*;


public class GuestView {


    private final GuestRepository repository;


    private TableView<Guest> table;


    private ObservableList<Guest> data;


    public GuestView() {

        repository =
                new GuestRepository();


    }


    public VBox getRoot() {

        VBox root =
                new VBox(20);

        root.setStyle(
                "-fx-padding:30;"
        );

        Label title =
                new Label(
                        "Gästeverwaltung"
                );

        title.setStyle(
                "-fx-font-size:25px;"
        );

        table =
                new TableView<>();

        createColumns();

        loadData();

        TextField firstName =
                new TextField();

        firstName.setPromptText(
                "Vorname"
        );

        TextField lastName =
                new TextField();

        lastName.setPromptText(
                "Nachname"
        );

        TextField email =
                new TextField();

        email.setPromptText(
                "Email"
        );

        Button save =
                new Button(
                        "Gast speichern"
                );

        save.setOnAction(e -> {

            Guest guest =
                    new Guest();

            guest.setFirstName(
                    firstName.getText()
            );

            guest.setLastName(
                    lastName.getText()
            );

            guest.setEmail(
                    email.getText()
            );

            guest.setPhone(
                    ""
            );

            guest.setAddress(
                    ""
            );

            repository.save(
                    guest
            );

            loadData();


        });

        Button delete =
                new Button(
                        "Gast löschen"
                );

        delete.setOnAction(e -> {

            Guest selected =
                    table.getSelectionModel()
                            .getSelectedItem();

            if (selected != null) {

                repository.delete(
                        selected.getGuestId()
                );

                loadData();

            }


        });

        HBox form =
                new HBox(10);

        form.getChildren()
                .addAll(

                        firstName,

                        lastName,

                        email,

                        save,

                        delete

                );

        root.getChildren()
                .addAll(

                        title,

                        table,

                        form

                );

        return root;


    }


    private void createColumns() {

        TableColumn<Guest, String> first =
                new TableColumn<>(
                        "Vorname"
                );

        first.setCellValueFactory(
                c ->
                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getFirstName()

                        )
        );

        TableColumn<Guest, String> last =
                new TableColumn<>(
                        "Nachname"
                );

        last.setCellValueFactory(
                c ->
                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getLastName()

                        )
        );

        TableColumn<Guest, String> email =
                new TableColumn<>(
                        "Email"
                );

        email.setCellValueFactory(
                c ->
                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getEmail()

                        )
        );

        table.getColumns()
                .addAll(

                        first,

                        last,

                        email

                );


    }


    private void loadData() {

        data =
                FXCollections.observableArrayList(

                        repository.findAll()

                );

        table.setItems(
                data
        );


    }


}