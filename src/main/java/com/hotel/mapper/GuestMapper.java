package com.hotel.mapper;


import com.hotel.dto.GuestDTO;
import com.hotel.model.Guest;


public class GuestMapper {


    public static Guest toEntity(
            GuestDTO dto
    ) {

        return new Guest(

                dto.getFirstName(),

                dto.getLastName(),

                dto.getEmail(),

                dto.getPhone(),

                null

        );


    }


}