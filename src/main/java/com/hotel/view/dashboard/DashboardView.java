package com.hotel.view.dashboard;


import javafx.scene.layout.*;


public class DashboardView {


    private BorderPane root;



    public DashboardView(){


        createUI();


    }





    private void createUI(){


        root =
                new BorderPane();



        /*
         * Linke Navigation
         */

        Sidebar sidebar =
                new Sidebar();



        root.setLeft(
                sidebar.getRoot()
        );




        /*
         * Hauptinhalt
         */

        DashboardContent content =
                new DashboardContent();



        root.setCenter(
                content.getRoot()
        );



    }







    public BorderPane getRoot(){


        return root;


    }


}