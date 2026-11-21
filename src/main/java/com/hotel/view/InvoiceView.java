package com.hotel.view;


import com.hotel.model.Invoice;
import com.hotel.model.PaymentStatus;
import com.hotel.repository.InvoiceRepository;


import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class InvoiceView {


    private final InvoiceRepository repository;


    private TableView<Invoice> table;


    public InvoiceView() {

        repository =
                new InvoiceRepository();


    }


    public VBox getRoot() {

        VBox root =
                new VBox(20);

        root.setStyle(
                "-fx-padding:30;"
        );

        Label title =
                new Label(
                        "Rechnungs- und Zahlungssystem"
                );

        title.setStyle(
                "-fx-font-size:25px;"
        );

        table =
                new TableView<>();

        createColumns();

        loadData();

        Button paid =
                new Button(
                        "Als bezahlt markieren"
                );

        paid.setOnAction(e -> {

            Invoice selected =
                    table.getSelectionModel()
                            .getSelectedItem();

            if (selected != null) {

                repository.updatePaymentStatus(

                        selected.getInvoiceId(),

                        PaymentStatus.PAID

                );

                loadData();


            }


        });

        Button refresh =
                new Button(
                        "Aktualisieren"
                );

        refresh.setOnAction(e -> {

            loadData();


        });

        HBox buttons =
                new HBox(15);

        buttons.getChildren()
                .addAll(

                        paid,

                        refresh

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

        TableColumn<Invoice, String> guest =
                new TableColumn<>(
                        "Gast"
                );

        guest.setCellValueFactory(

                cell ->

                        new javafx.beans.property.SimpleStringProperty(

                                cell.getValue()
                                        .getReservation()
                                        .getGuest()
                                        .getFirstName()

                                        + " " +

                                        cell.getValue()
                                                .getReservation()
                                                .getGuest()
                                                .getLastName()

                        )

        );

        TableColumn<Invoice, String> room =
                new TableColumn<>(
                        "Zimmer"
                );

        room.setCellValueFactory(

                cell ->

                        new javafx.beans.property.SimpleStringProperty(

                                cell.getValue()
                                        .getReservation()
                                        .getRoom()
                                        .getRoomNumber()

                        )

        );

        TableColumn<Invoice, String> amount =
                new TableColumn<>(
                        "Betrag"
                );

        amount.setCellValueFactory(

                cell ->

                        new javafx.beans.property.SimpleStringProperty(

                                cell.getValue()
                                        .getAmount()
                                        + " €"

                        )

        );

        TableColumn<Invoice, String> status =
                new TableColumn<>(
                        "Status"
                );

        status.setCellValueFactory(

                cell ->

                        new javafx.beans.property.SimpleStringProperty(

                                cell.getValue()
                                        .getPaymentStatus()
                                        .name()

                        )

        );

        table.getColumns()
                .addAll(

                        guest,

                        room,

                        amount,

                        status

                );


    }


    private void loadData() {

        table.setItems(

                FXCollections.observableArrayList(

                        repository.findAll()

                )

        );


    }


}