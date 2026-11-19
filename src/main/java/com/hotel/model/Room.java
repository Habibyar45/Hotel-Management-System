package com.hotel.model;


public class Room {


    private int roomId;

    private String roomNumber;

    private RoomType roomType;

    private double price;

    private RoomStatus status;



    public Room(){

    }



    public Room(
            String roomNumber,
            RoomType roomType,
            double price,
            RoomStatus status
    ){

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.status = status;

    }



    public Room(
            int roomId,
            String roomNumber,
            RoomType roomType,
            double price,
            RoomStatus status
    ){

        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.status = status;

    }



    public int getRoomId() {
        return roomId;
    }


    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }


    public String getRoomNumber() {
        return roomNumber;
    }


    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    public RoomType getRoomType() {
        return roomType;
    }


    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public RoomStatus getStatus() {
        return status;
    }


    public void setStatus(RoomStatus status) {
        this.status = status;
    }



    @Override
    public String toString(){

        return
                "Room " + roomNumber +
                        " - " + roomType +
                        " - " + price + " €";

    }

}