package com.hotel.model;


import java.time.LocalDate;


public class Reservation {


    private int reservationId;

    private Guest guest;

    private Room room;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private ReservationStatus status;



    public int getReservationId(){

        return reservationId;

    }


    public void setReservationId(int reservationId){

        this.reservationId = reservationId;

    }



    public Guest getGuest(){

        return guest;

    }


    public void setGuest(Guest guest){

        this.guest = guest;

    }



    public Room getRoom(){

        return room;

    }


    public void setRoom(Room room){

        this.room = room;

    }



    public LocalDate getCheckIn(){

        return checkIn;

    }


    public void setCheckIn(LocalDate checkIn){

        this.checkIn = checkIn;

    }



    public LocalDate getCheckOut(){

        return checkOut;

    }


    public void setCheckOut(LocalDate checkOut){

        this.checkOut = checkOut;

    }



    public ReservationStatus getStatus(){

        return status;

    }


    public void setStatus(
            ReservationStatus status
    ){

        this.status = status;

    }

}