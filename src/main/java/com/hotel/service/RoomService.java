package com.hotel.service;


import com.hotel.model.Room;
import com.hotel.model.RoomStatus;
import com.hotel.repository.RoomRepository;


import java.util.List;



public class RoomService {


    private final RoomRepository roomRepository;




    public RoomService(){


        roomRepository =
                new RoomRepository();


    }





    /*
        Zimmer erstellen
    */

    public void createRoom(
            Room room
    ){

        roomRepository.save(room);

    }







    /*
        Alle Zimmer holen
    */

    public List<Room> getRooms(){


        return roomRepository.findAll();


    }


    /*
        Verfügbare Zimmer laden
    */
    public List<Room> getAvailableRooms(){


        return roomRepository.findAvailableRooms();


    }




    /*
        Zimmer Status ändern
    */

    public void changeStatus(

            int roomId,

            RoomStatus status

    ){


        roomRepository.updateStatus(

                roomId,

                status

        );


    }








    /*
        Zimmer löschen
    */

    public void deleteRoom(

            int roomId

    ){


        roomRepository.delete(

                roomId

        );


    }


}