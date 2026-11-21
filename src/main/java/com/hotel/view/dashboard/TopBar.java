package com.hotel.view.dashboard;

import javafx.scene.layout.Priority;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class TopBar {


    public HBox create() {

        HBox top =
                new HBox(20);

        top.setPadding(
                new Insets(15)
        );

        top.getStyleClass()
                .add(
                        "topbar"
                );

        Label title =
                new Label(
                        "Hotel Management System"
                );

        title.getStyleClass()
                .add(
                        "top-title"
                );

        Button logout =
                new Button(
                        "Logout"
                );

        logout.getStyleClass()
                .add(
                        "logout-button"
                );

        HBox spacer =
                new HBox();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        top.getChildren()
                .addAll(

                        title,
                        spacer,
                        logout

                );

        return top;


    }


}