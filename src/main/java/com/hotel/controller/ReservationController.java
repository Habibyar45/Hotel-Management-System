package com.hotel.controller;


import com.hotel.model.Reservation;
import com.hotel.service.ReservationService;


import java.util.List;


public class ReservationController {


    private final ReservationService service;


    public ReservationController() {

        service =
                new ReservationService();

    }


    public void create(
            Reservation reservation
    ) {

        service.createReservation(
                reservation
        );


    }


    public List<Reservation> getAll() {

        return service.getReservations();


    }


    public void cancel(
            int reservationId,
            int roomId
    ) {

        service.cancelReservation(
                reservationId,
                roomId
        );


    }


}