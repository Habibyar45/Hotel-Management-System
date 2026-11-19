package com.hotel.service;


import com.hotel.model.ReservationStatus;
import com.hotel.repository.CheckInRepository;



public class CheckInService {



    private final CheckInRepository repository;



    public CheckInService(){


        repository =
                new CheckInRepository();


    }







    public void checkIn(
            int reservationId
    ){



        repository.updateReservationStatus(

                reservationId,

                ReservationStatus.CHECKED_IN

        );


    }



}