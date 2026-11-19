package com.hotel.model;


import java.time.LocalDate;



public class Invoice {


    private int invoiceId;


    private Reservation reservation;


    private double amount;


    private PaymentStatus paymentStatus;


    private LocalDate createdAt;





    public Invoice(){

    }





    public Invoice(
            Reservation reservation,
            double amount
    ){


        this.reservation = reservation;

        this.amount = amount;

        this.paymentStatus =
                PaymentStatus.UNPAID;

        this.createdAt =
                LocalDate.now();

    }






    public int getInvoiceId(){

        return invoiceId;

    }


    public void setInvoiceId(int invoiceId){

        this.invoiceId = invoiceId;

    }





    public Reservation getReservation(){

        return reservation;

    }



    public void setReservation(
            Reservation reservation
    ){

        this.reservation = reservation;

    }





    public double getAmount(){

        return amount;

    }



    public void setAmount(double amount){

        this.amount = amount;

    }






    public PaymentStatus getPaymentStatus(){

        return paymentStatus;

    }



    public void setPaymentStatus(
            PaymentStatus paymentStatus
    ){

        this.paymentStatus = paymentStatus;

    }






    public LocalDate getCreatedAt(){

        return createdAt;

    }



    public void setCreatedAt(
            LocalDate createdAt
    ){

        this.createdAt = createdAt;

    }


}