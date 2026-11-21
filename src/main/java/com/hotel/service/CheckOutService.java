package com.hotel.service;

import com.hotel.model.Reservation;
import com.hotel.repository.ReservationRepository;
import com.hotel.model.ReservationStatus;
import com.hotel.model.RoomStatus;
import com.hotel.repository.CheckOutRepository;
import com.hotel.repository.RoomRepository;


public class CheckOutService {


    private final CheckOutRepository repository;

    private final RoomRepository roomRepository;

    private final InvoiceService invoiceService;

    private final ReservationRepository reservationRepository;


    public CheckOutService() {

        repository =
                new CheckOutRepository();

        roomRepository =
                new RoomRepository();

        invoiceService =
                new InvoiceService();

        reservationRepository =
                new ReservationRepository();


    }


    public void checkOut(
            int reservationId,
            int roomId
    ) {

        // 1. Reservierung auf CHECKED_OUT setzen

        repository.updateReservationStatus(

                reservationId,

                ReservationStatus.CHECKED_OUT

        );

        // 2. Zimmer wieder verfügbar machen

        roomRepository.updateStatus(

                roomId,

                RoomStatus.AVAILABLE

        );

        // 3. Reservierung laden

        Reservation reservation =
                reservationRepository
                        .findById(reservationId);

        // 4. Rechnung erstellen

        invoiceService.createInvoice(
                reservation
        );


    }


}