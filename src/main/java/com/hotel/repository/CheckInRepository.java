package com.hotel.repository;


import com.hotel.database.DatabaseManager;
import com.hotel.model.ReservationStatus;


import java.sql.*;


public class CheckInRepository {


    public void updateReservationStatus(
            int reservationId,
            ReservationStatus status
    ) {

        String sql =
                """
                        UPDATE reservations
                        
                        SET status=?
                        
                        WHERE reservation_id=?
                        
                        """;

        try (

                Connection connection =
                        DatabaseManager.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setString(
                    1,
                    status.name()
            );

            statement.setInt(
                    2,
                    reservationId
            );

            statement.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();

        }


    }


}