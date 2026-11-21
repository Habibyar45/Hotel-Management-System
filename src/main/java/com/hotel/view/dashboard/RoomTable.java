package com.hotel.view.dashboard;


import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;

import javafx.geometry.Insets;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class RoomTable {


    public TableView<Room> create() {

        TableView<Room> table =
                new TableView<>();

        table.setPrefHeight(250);

        table.setPadding(
                new Insets(10)
        );


        /*
         *
         * Zimmernummer
         *
         */

        TableColumn<Room, String> numberColumn =
                new TableColumn<>("Zimmer");

        numberColumn.setCellValueFactory(cell ->

                new SimpleStringProperty(

                        cell.getValue()
                                .getRoomNumber()

                )

        );

        numberColumn.setPrefWidth(100);





        /*
         *
         * Zimmer Typ
         *
         */

        TableColumn<Room, String> typeColumn =
                new TableColumn<>("Typ");

        typeColumn.setCellValueFactory(cell ->

                new SimpleStringProperty(

                        cell.getValue()
                                .getRoomType()
                                .name()

                )

        );

        typeColumn.setPrefWidth(120);







        /*
         *
         * Preis
         *
         */

        TableColumn<Room, String> priceColumn =
                new TableColumn<>("Preis");

        priceColumn.setCellValueFactory(cell ->

                new SimpleStringProperty(

                        String.format(

                                "%.2f €",

                                cell.getValue()
                                        .getPrice()

                        )

                )

        );

        priceColumn.setPrefWidth(120);








        /*
         *
         * Status
         *
         */

        TableColumn<Room, String> statusColumn =
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

                        numberColumn,

                        typeColumn,

                        priceColumn,

                        statusColumn

                );






        /*
         *
         * Daten laden
         *
         */

        RoomRepository repository =
                new RoomRepository();

        table.getItems()
                .addAll(

                        repository.findAll()

                );

        return table;


    }


}