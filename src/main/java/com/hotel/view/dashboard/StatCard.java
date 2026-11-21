package com.hotel.view.dashboard;


import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class StatCard {


    public VBox create(
            String title,
            String value
    ) {

        VBox box =
                new VBox(10);

        box.getStyleClass()
                .add(
                        "stat-card"
                );

        Label titleLabel =
                new Label(title);

        titleLabel.getStyleClass()
                .add(
                        "stat-title"
                );

        Label valueLabel =
                new Label(value);

        valueLabel.getStyleClass()
                .add(
                        "stat-number"
                );

        box.getChildren()
                .addAll(

                        titleLabel,

                        valueLabel

                );

        return box;

    }


}