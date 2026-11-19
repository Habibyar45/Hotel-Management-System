package com.hotel.repository;


import com.hotel.database.DatabaseManager;
import com.hotel.model.Invoice;
import com.hotel.model.PaymentStatus;
import com.hotel.model.Reservation;
import com.hotel.model.Guest;
import com.hotel.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class InvoiceRepository {



    public void save(
            Invoice invoice
    ){


        String sql =
                """
                INSERT INTO invoices
        
                (
                reservation_id,
                amount,
                payment_status,
                created_at
                )
        
                VALUES(?,?,?,?)
        
                """;



        try(

                Connection connection =
                        DatabaseManager.getConnection();


                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ){


            statement.setInt(

                    1,

                    invoice
                            .getReservation()
                            .getReservationId()

            );



            statement.setDouble(

                    2,

                    invoice.getAmount()

            );



            statement.setString(

                    3,

                    invoice
                            .getPaymentStatus()
                            .name()

            );



            statement.setString(

                    4,

                    invoice
                            .getCreatedAt()
                            .toString()

            );



            statement.executeUpdate();


        }
        catch(SQLException e){

            e.printStackTrace();

        }


    }







    public List<Invoice> findAll(){


        List<Invoice> invoices =
                new ArrayList<>();



        String sql =
                """
                SELECT
            
            
                i.invoice_id,
                i.amount,
                i.payment_status,
                i.created_at,
            
            
                r.reservation_id,
                r.check_in,
                r.check_out,
            
            
                g.guest_id,
                g.first_name,
                g.last_name,
            
            
                ro.room_id,
                ro.room_number,
                ro.price
            
            
            
                FROM invoices i
            
            
            
                JOIN reservations r
            
                ON i.reservation_id =
                   r.reservation_id
            
            
            
                JOIN guests g
            
                ON r.guest_id =
                   g.guest_id
            
            
            
                JOIN rooms ro
            
                ON r.room_id =
                   ro.room_id
            
                """;




        try(

                Connection connection =
                        DatabaseManager.getConnection();


                Statement statement =
                        connection.createStatement();


                ResultSet result =
                        statement.executeQuery(sql)

        ){



            while(result.next()){


                Invoice invoice =
                        new Invoice();



                invoice.setInvoiceId(

                        result.getInt(
                                "invoice_id"
                        )

                );



                invoice.setAmount(

                        result.getDouble(
                                "amount"
                        )

                );



                invoice.setPaymentStatus(

                        PaymentStatus.valueOf(

                                result.getString(
                                        "payment_status"
                                )

                        )

                );



                invoice.setCreatedAt(

                        result.getDate(
                                        "created_at"
                                )
                                .toLocalDate()

                );



                // Reservierung laden

                Reservation reservation =
                        new Reservation();



                reservation.setReservationId(

                        result.getInt(
                                "reservation_id"
                        )

                );



                reservation.setCheckIn(

                        result.getDate(
                                        "check_in"
                                )
                                .toLocalDate()

                );



                reservation.setCheckOut(

                        result.getDate(
                                        "check_out"
                                )
                                .toLocalDate()

                );



                // Gast

                Guest guest =
                        new Guest();



                guest.setFirstName(

                        result.getString(
                                "first_name"
                        )

                );


                guest.setLastName(

                        result.getString(
                                "last_name"
                        )

                );



                // Zimmer

                Room room =
                        new Room();



                room.setRoomNumber(

                        result.getString(
                                "room_number"
                        )

                );


                room.setPrice(

                        result.getDouble(
                                "price"
                        )

                );



                reservation.setGuest(
                        guest
                );


                reservation.setRoom(
                        room
                );



                invoice.setReservation(
                        reservation
                );



                invoices.add(invoice);


            }



        }
        catch(SQLException e){

            e.printStackTrace();

        }



        return invoices;


    }








    public void updatePaymentStatus(

            int invoiceId,

            PaymentStatus status

    ){



        String sql =
                """
                UPDATE invoices
        
                SET payment_status=?
        
                WHERE invoice_id=?
        
                """;



        try(

                Connection connection =
                        DatabaseManager.getConnection();


                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ){


            statement.setString(

                    1,

                    status.name()

            );



            statement.setInt(

                    2,

                    invoiceId

            );



            statement.executeUpdate();



        }
        catch(SQLException e){

            e.printStackTrace();

        }


    }



}