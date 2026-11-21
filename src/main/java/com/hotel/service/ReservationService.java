package com.hotel.service;


import com.hotel.model.*;
import com.hotel.repository.ReservationRepository;
import com.hotel.repository.RoomRepository;


import java.time.LocalDate;
import java.util.List;


public class ReservationService {


    private final ReservationRepository reservationRepository;

    private final RoomRepository roomRepository;


    public ReservationService() {

        reservationRepository =
                new ReservationRepository();

        roomRepository =
                new RoomRepository();


    }


    public void createReservation(
            Reservation reservation
    ) {

        validate(
                reservation
        );

        if (
                reservation.getRoom()
                        .getStatus()
                        != RoomStatus.AVAILABLE
        ) {

            throw new RuntimeException(
                    "Zimmer ist nicht verfügbar"
            );


        }

        reservationRepository.save(
                reservation
        );

        roomRepository.updateStatus(
                reservation
                        .getRoom()
                        .getRoomId(),

                RoomStatus.OCCUPIED
        );


    }


    public List<Reservation> getReservations() {

        return reservationRepository
                .findAll();


    }


    public void cancelReservation(
            int reservationId,
            int roomId
    ) {

        reservationRepository.updateStatus(
                reservationId,

                ReservationStatus.CANCELLED
        );

        roomRepository.updateStatus(
                roomId,

                RoomStatus.AVAILABLE
        );


    }


    private void validate(
            Reservation reservation
    ) {

        if (reservation == null) {

            throw new RuntimeException(
                    "Reservierung fehlt"
            );

        }

        if (reservation.getGuest() == null) {

            throw new RuntimeException(
                    "Gast fehlt"
            );

        }

        if (reservation.getRoom() == null) {

            throw new RuntimeException(
                    "Zimmer fehlt"
            );

        }

        if (
                reservation.getCheckIn()
                        .isBefore(
                                LocalDate.now()
                        )
        ) {

            throw new RuntimeException(
                    "Check-in Datum ungültig"
            );

        }

        if (
                reservation.getCheckOut()
                        .isBefore(
                                reservation.getCheckIn()
                        )
        ) {

            throw new RuntimeException(
                    "Check-out Datum ungültig"
            );


        }


    }


}