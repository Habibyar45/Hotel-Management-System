package com.hotel.service;


import com.hotel.repository.GuestRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.ReservationRepository;
import com.hotel.repository.InvoiceRepository;


public class DashboardService {


    private final GuestRepository guestRepository;

    private final RoomRepository roomRepository;

    private final ReservationRepository reservationRepository;

    private final InvoiceRepository invoiceRepository;


    public DashboardService() {

        guestRepository =
                new GuestRepository();

        roomRepository =
                new RoomRepository();

        reservationRepository =
                new ReservationRepository();

        invoiceRepository =
                new InvoiceRepository();


    }


    public int getGuestCount() {

        return guestRepository
                .findAll()
                .size();


    }


    public int getRoomCount() {

        return roomRepository
                .findAll()
                .size();


    }


    public int getAvailableRooms() {

        return roomRepository
                .findAvailableRooms()
                .size();


    }


    public int getReservationCount() {

        return reservationRepository
                .findAll()
                .size();


    }


    public int getInvoiceCount() {

        return invoiceRepository
                .findAll()
                .size();


    }


}