package com.hotel.view;


import com.hotel.model.Room;
import com.hotel.model.RoomType;
import com.hotel.model.RoomStatus;
import com.hotel.repository.RoomRepository;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.*;
import javafx.scene.layout.*;



public class RoomView {



    private final RoomRepository repository;


    private TableView<Room> table;


    private ObservableList<Room> data;



    public RoomView(){


        repository =
                new RoomRepository();


    }





    public VBox getRoot(){


        VBox root =
                new VBox(20);



        root.setStyle(
                "-fx-padding:30;"
        );



        Label title =
                new Label(
                        "Zimmerverwaltung"
                );


        title.setStyle(
                "-fx-font-size:25px;"
        );




        table =
                new TableView<>();


        createColumns();


        loadData();





        TextField roomNumber =
                new TextField();


        roomNumber.setPromptText(
                "Zimmernummer"
        );





        ComboBox<RoomType> type =
                new ComboBox<>();


        type.getItems()
                .addAll(

                        RoomType.values()

                );


        type.setValue(
                RoomType.SINGLE
        );







        TextField price =
                new TextField();


        price.setPromptText(
                "Preis"
        );







        Button save =
                new Button(
                        "Zimmer speichern"
                );



        save.setOnAction(e->{


            Room room =
                    new Room();



            room.setRoomNumber(
                    roomNumber.getText()
            );



            room.setRoomType(
                    type.getValue()
            );



            room.setPrice(

                    Double.parseDouble(
                            price.getText()
                    )

            );



            room.setStatus(
                    RoomStatus.AVAILABLE
            );



            repository.save(
                    room
            );



            loadData();



        });








        Button status =
                new Button(
                        "Status ändern"
                );



        status.setOnAction(e->{


            Room selected =
                    table.getSelectionModel()
                            .getSelectedItem();



            if(selected != null){



                RoomStatus newStatus;



                if(
                        selected.getStatus()
                                ==
                                RoomStatus.AVAILABLE
                ){


                    newStatus =
                            RoomStatus.OCCUPIED;


                }
                else{


                    newStatus =
                            RoomStatus.AVAILABLE;


                }




                repository.updateStatus(

                        selected.getRoomId(),

                        newStatus

                );



                loadData();


            }


        });







        Button delete =
                new Button(
                        "Zimmer löschen"
                );



        delete.setOnAction(e->{



            Room selected =
                    table.getSelectionModel()
                            .getSelectedItem();



            if(selected != null){


                repository.delete(

                        selected.getRoomId()

                );


                loadData();


            }



        });






        HBox form =
                new HBox(10);



        form.getChildren()
                .addAll(

                        roomNumber,

                        type,

                        price,

                        save,

                        status,

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








    private void createColumns(){



        TableColumn<Room,String> number =
                new TableColumn<>(
                        "Zimmer"
                );


        number.setCellValueFactory(

                c ->

                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getRoomNumber()

                        )

        );







        TableColumn<Room,String> roomType =
                new TableColumn<>(
                        "Typ"
                );


        roomType.setCellValueFactory(

                c ->

                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getRoomType()
                                        .name()

                        )

        );








        TableColumn<Room,String> price =
                new TableColumn<>(
                        "Preis"
                );


        price.setCellValueFactory(

                c ->

                        new javafx.beans.property.SimpleStringProperty(

                                c.getValue()
                                        .getPrice()
                                        +" €"

                        )

        );







        TableColumn<Room,String> status =
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

                        number,

                        roomType,

                        price,

                        status

                );


    }







    private void loadData(){


        data =
                FXCollections.observableArrayList(

                        repository.findAll()

                );



        table.setItems(
                data
        );


    }



}