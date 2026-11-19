package com.hotel.repository;


import com.hotel.database.DatabaseManager;
import com.hotel.model.Guest;
import com.hotel.model.Reservation;
import com.hotel.model.ReservationStatus;
import com.hotel.model.Room;
import com.hotel.model.RoomStatus;
import com.hotel.model.RoomType;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ReservationRepository {



    public void save(
            Reservation reservation
    ){


        String sql =
                """
                INSERT INTO reservations
                (
                guest_id,
                room_id,
                check_in,
                check_out,
                status
                )

                VALUES(?,?,?,?,?)

                """;


        try(

                Connection connection =
                        DatabaseManager.getConnection();


                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ){


            statement.setInt(
                    1,
                    reservation.getGuest().getGuestId()
            );


            statement.setInt(
                    2,
                    reservation.getRoom().getRoomId()
            );


            statement.setString(
                    3,
                    reservation.getCheckIn().toString()
            );


            statement.setString(
                    4,
                    reservation.getCheckOut().toString()
            );


            statement.setString(
                    5,
                    reservation.getStatus().name()
            );


            statement.executeUpdate();


        }
        catch(SQLException e){

            e.printStackTrace();

        }


    }






    public List<Reservation> findAll(){


        List<Reservation> reservations =
                new ArrayList<>();


        String sql =
                """
                SELECT
                
                r.reservation_id,
                r.check_in,
                r.check_out,
                r.status,
    
    
                g.guest_id,
                g.first_name,
                g.last_name,
                g.email,
                g.phone,
                g.address,
    
    
                ro.room_id,
                ro.room_number,
                ro.room_type,
                ro.price,
                ro.status AS room_status
    
    
                FROM reservations r
    
    
                JOIN guests g
    
                ON r.guest_id = g.guest_id
    
    
    
                JOIN rooms ro
    
                ON r.room_id = ro.room_id
    
                """;



        try(

                Connection connection =
                        DatabaseManager.getConnection();


                PreparedStatement statement =
                        connection.prepareStatement(sql);


                ResultSet result =
                        statement.executeQuery()

        ){



            while(result.next()){



                /*
                 *
                 * Guest erstellen
                 *
                 */


                Guest guest =
                        new Guest();



                guest.setGuestId(
                        result.getInt(
                                "guest_id"
                        )
                );


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


                guest.setEmail(
                        result.getString(
                                "email"
                        )
                );


                guest.setPhone(
                        result.getString(
                                "phone"
                        )
                );


                guest.setAddress(
                        result.getString(
                                "address"
                        )
                );





                /*
                 *
                 * Room erstellen
                 *
                 */


                Room room =
                        new Room();



                room.setRoomId(
                        result.getInt(
                                "room_id"
                        )
                );


                room.setRoomNumber(
                        result.getString(
                                "room_number"
                        )
                );


                room.setRoomType(

                        RoomType.valueOf(

                                result.getString(
                                        "room_type"
                                )

                        )

                );


                room.setPrice(
                        result.getDouble(
                                "price"
                        )
                );


                room.setStatus(

                        RoomStatus.valueOf(

                                result.getString(
                                        "room_status"
                                )

                        )

                );





                /*
                 *
                 * Reservation erstellen
                 *
                 */


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



                reservation.setStatus(

                        ReservationStatus.valueOf(

                                result.getString(
                                        "status"
                                )

                        )

                );



                reservation.setGuest(
                        guest
                );



                reservation.setRoom(
                        room
                );



                reservations.add(
                        reservation
                );


            }



        }
        catch(SQLException e){

            e.printStackTrace();

        }



        return reservations;


    }








    public void updateStatus(
            int reservationId,
            ReservationStatus status
    ){


        String sql =
                """
                UPDATE reservations

                SET status=?

                WHERE reservation_id=?

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
                    reservationId
            );


            statement.executeUpdate();


        }
        catch(SQLException e){

            e.printStackTrace();

        }


    }








    public void delete(
            int id
    ){


        String sql =
                """
                DELETE FROM reservations

                WHERE reservation_id=?

                """;


        try(

                Connection connection =
                        DatabaseManager.getConnection();


                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ){


            statement.setInt(
                    1,
                    id
            );


            statement.executeUpdate();


        }
        catch(SQLException e){

            e.printStackTrace();

        }


    }








    /*
       WICHTIG:
       Diese Methode ersetzt alle alten findById Methoden.
       Sie lädt Reservation + Guest + Room mit JOIN.
    */

    public Reservation findById(
            int id
    ){


        String sql =
                """
                SELECT

                r.reservation_id,
                r.check_in,
                r.check_out,
                r.status,

                g.guest_id,
                g.first_name,
                g.last_name,
                g.email,
                g.phone,
                g.address,

                ro.room_id,
                ro.room_number,
                ro.room_type,
                ro.price,
                ro.status AS room_status


                FROM reservations r


                JOIN guests g

                ON r.guest_id = g.guest_id


                JOIN rooms ro

                ON r.room_id = ro.room_id


                WHERE r.reservation_id = ?

                """;



        try(

                Connection connection =
                        DatabaseManager.getConnection();


                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ){


            statement.setInt(
                    1,
                    id
            );


            ResultSet result =
                    statement.executeQuery();



            if(result.next()){


                Guest guest =
                        new Guest();



                guest.setGuestId(
                        result.getInt(
                                "guest_id"
                        )
                );


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


                guest.setEmail(
                        result.getString(
                                "email"
                        )
                );


                guest.setPhone(
                        result.getString(
                                "phone"
                        )
                );


                guest.setAddress(
                        result.getString(
                                "address"
                        )
                );





                Room room =
                        new Room();



                room.setRoomId(
                        result.getInt(
                                "room_id"
                        )
                );


                room.setRoomNumber(
                        result.getString(
                                "room_number"
                        )
                );


                room.setRoomType(
                        RoomType.valueOf(
                                result.getString(
                                        "room_type"
                                )
                        )
                );


                room.setPrice(
                        result.getDouble(
                                "price"
                        )
                );


                room.setStatus(
                        RoomStatus.valueOf(
                                result.getString(
                                        "room_status"
                                )
                        )
                );





                Reservation reservation =
                        new Reservation();



                reservation.setReservationId(
                        result.getInt(
                                "reservation_id"
                        )
                );


                reservation.setGuest(
                        guest
                );


                reservation.setRoom(
                        room
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


                reservation.setStatus(
                        ReservationStatus.valueOf(
                                result.getString(
                                        "status"
                                )
                        )
                );



                return reservation;


            }


        }
        catch(SQLException e){

            e.printStackTrace();

        }



        return null;


    }


}