package com.hotel.controller;


import com.hotel.service.CheckOutService;


public class CheckOutController {


    private final CheckOutService service;


    public CheckOutController() {

        service =
                new CheckOutService();


    }


    public void checkOut(

            int reservationId,

            int roomId

    ) {

        service.checkOut(

                reservationId,

                roomId

        );


    }


}