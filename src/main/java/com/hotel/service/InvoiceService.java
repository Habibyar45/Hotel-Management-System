package com.hotel.service;


import com.hotel.model.*;
import com.hotel.repository.InvoiceRepository;
import com.hotel.util.InvoiceCalculator;


import java.util.List;


public class InvoiceService {


    private final InvoiceRepository repository;


    public InvoiceService() {

        repository =
                new InvoiceRepository();

    }


    public Invoice createInvoice(

            Reservation reservation

    ) {

        double amount =

                InvoiceCalculator
                        .calculate(
                                reservation
                        );

        Invoice invoice =

                new Invoice(
                        reservation,
                        amount
                );

        repository.save(invoice);

        return invoice;


    }


    public List<Invoice> getInvoices() {

        return repository.findAll();


    }


    public void markAsPaid(

            int invoiceId

    ) {

        repository.updatePaymentStatus(

                invoiceId,

                PaymentStatus.PAID

        );


    }


}