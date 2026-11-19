package com.hotel.util;


import com.hotel.model.Reservation;


import java.time.temporal.ChronoUnit;



public class InvoiceCalculator {



    public static double calculate(
            Reservation reservation
    ){



        long nights =
                ChronoUnit.DAYS.between(

                        reservation.getCheckIn(),

                        reservation.getCheckOut()

                );



        if(nights <= 0){

            nights = 1;

        }



        return nights *

                reservation
                        .getRoom()
                        .getPrice();


    }


}