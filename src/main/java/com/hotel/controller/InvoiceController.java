package com.hotel.controller;


import com.hotel.model.Invoice;
import com.hotel.model.Reservation;
import com.hotel.service.InvoiceService;


import java.util.List;


public class InvoiceController {


    private final InvoiceService service;


    public InvoiceController() {

        service =
                new InvoiceService();

    }


    public Invoice create(

            Reservation reservation

    ) {

        return service.createInvoice(
                reservation
        );


    }


    public List<Invoice> getAll() {

        return service.getInvoices();


    }


    public void pay(

            int invoiceId

    ) {

        service.markAsPaid(
                invoiceId
        );


    }


}