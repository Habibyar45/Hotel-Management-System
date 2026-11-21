package com.hotel.controller;


import com.hotel.model.Room;
import com.hotel.model.RoomStatus;
import com.hotel.service.RoomService;


import java.util.List;


public class RoomController {


    private final RoomService service;


    public RoomController() {

        service =
                new RoomService();


    }


    public void addRoom(
            Room room
    ) {

        service.createRoom(room);


    }


    public List<Room> getRooms() {

        return service.getRooms();


    }


    public List<Room> getAvailableRooms() {

        return service.getAvailableRooms();


    }


    public void updateStatus(
            int roomId,
            RoomStatus status
    ) {

        service.changeStatus(
                roomId,
                status
        );


    }


    public void deleteRoom(
            int id
    ) {

        service.deleteRoom(id);


    }


}