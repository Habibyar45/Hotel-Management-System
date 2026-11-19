package com.hotel.dto;


import java.time.LocalDate;



public class ReservationDTO {


    private int guestId;

    private int roomId;

    private LocalDate checkIn;

    private LocalDate checkOut;



    public int getGuestId(){

        return guestId;

    }


    public void setGuestId(int guestId){

        this.guestId = guestId;

    }




    public int getRoomId(){

        return roomId;

    }



    public void setRoomId(int roomId){

        this.roomId = roomId;

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


}