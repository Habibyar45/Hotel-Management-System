package com.hotel;


import com.hotel.database.DatabaseInitializer;
import com.hotel.javafx.LoginApplication;

import javafx.application.Application;



public class Main {


    public static void main(String[] args){


        DatabaseInitializer.initialize();



        Application.launch(
                LoginApplication.class,
                args
        );


    }


}