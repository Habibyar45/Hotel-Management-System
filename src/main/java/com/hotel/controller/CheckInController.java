package com.hotel.controller;


import com.hotel.service.CheckInService;


public class CheckInController {


    private final CheckInService service;


    public CheckInController() {

        service =
                new CheckInService();


    }


    public void checkIn(
            int reservationId
    ) {

        service.checkIn(
                reservationId
        );


    }


}