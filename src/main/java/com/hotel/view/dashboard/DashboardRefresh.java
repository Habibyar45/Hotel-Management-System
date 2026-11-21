package com.hotel.view.dashboard;


import javafx.scene.control.Button;


public class DashboardRefresh {


    public Button create(
            Runnable action
    ) {

        Button button =
                new Button(
                        "Refresh"
                );

        button.setOnAction(e ->
                action.run()
        );

        return button;


    }


}