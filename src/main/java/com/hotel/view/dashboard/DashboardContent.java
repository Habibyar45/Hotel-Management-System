package com.hotel.view.dashboard;

import com.hotel.service.DashboardService;

import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class DashboardContent {

    private final DashboardService service;

    private VBox root;

    public DashboardContent() {

        service = new DashboardService();

    }

    public VBox create() {

        VBox root = new VBox(20);

        DashboardRefresh refresh =
                new DashboardRefresh();

        Button refreshButton =
                refresh.create(() -> {

                    root.getChildren()
                            .clear();

                    root.getChildren()
                            .addAll(
                                    create()
                            );

                });

        root.setPadding(
                new Insets(
                        20,
                        30,
                        30,
                        30
                )
        );

        root.getStyleClass().add("content");

        //--------------------------------------------------
        // Statistik-Karten
        //--------------------------------------------------

        FlowPane cards = new FlowPane();

        cards.setHgap(20);

        cards.setVgap(20);

        StatCard card = new StatCard();

        cards.getChildren().addAll(

                card.create(
                        "Gäste",
                        String.valueOf(
                                service.getGuestCount()
                        )
                ),

                card.create(
                        "Zimmer",
                        String.valueOf(
                                service.getRoomCount()
                        )
                ),

                card.create(
                        "Reservierungen",
                        String.valueOf(
                                service.getReservationCount()
                        )
                ),

                card.create(
                        "Rechnungen",
                        String.valueOf(
                                service.getInvoiceCount()
                        )
                )

        );

        //--------------------------------------------------
        // Reservierungen
        //--------------------------------------------------

        Label reservationTitle =
                new Label(
                        "Aktuelle Reservierungen"
                );

        reservationTitle.setStyle(
                "-fx-font-size:18;" +
                        "-fx-font-weight:bold;"
        );

        ReservationTable reservationTable =
                new ReservationTable();

        //--------------------------------------------------
        // Zimmer
        //--------------------------------------------------

        Label roomTitle =
                new Label(
                        "Zimmerstatus"
                );

        roomTitle.setStyle(
                "-fx-font-size:18;" +
                        "-fx-font-weight:bold;"
        );

        RoomTable roomTable =
                new RoomTable();

        //--------------------------------------------------
        // Alles hinzufügen
        //--------------------------------------------------

        root.getChildren().addAll(

                refreshButton,

                cards,

                reservationTitle,

                reservationTable.create(),

                roomTitle,

                roomTable.create()

        );

        return root;

    }

    public VBox getRoot() {

        return root;

    }

}