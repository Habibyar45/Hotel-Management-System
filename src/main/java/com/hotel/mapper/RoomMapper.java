package com.hotel.mapper;


import com.hotel.dto.RoomDTO;
import com.hotel.model.Room;
import com.hotel.model.RoomStatus;
import com.hotel.model.RoomType;


public class RoomMapper {


    public static Room toEntity(
            RoomDTO dto
    ) {

        return new Room(

                dto.getRoomNumber(),

                RoomType.valueOf(
                        dto.getRoomType()
                ),

                dto.getPrice(),

                RoomStatus.AVAILABLE

        );


    }


}