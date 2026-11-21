package com.hotel.mapper;


import com.hotel.dto.ReservationDTO;
import com.hotel.model.*;


public class ReservationMapper {


    public static Reservation toEntity(
            ReservationDTO dto,
            Guest guest,
            Room room
    ) {

        Reservation reservation =
                new Reservation();

        reservation.setGuest(
                guest
        );

        reservation.setRoom(
                room
        );

        reservation.setCheckIn(
                dto.getCheckIn()
        );

        reservation.setCheckOut(
                dto.getCheckOut()
        );

        reservation.setStatus(
                ReservationStatus.RESERVED
        );

        return reservation;


    }


}