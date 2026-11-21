package com.hotel.repository;


import com.hotel.database.DatabaseManager;
import com.hotel.model.User;
import com.hotel.model.UserRole;


import java.sql.*;


public class UserRepository {



    /*
        Benutzer anhand Username suchen
    */

    public User findByUsername(String username) {

        String sql =
                """
                        SELECT *
                        FROM users
                        WHERE username=?
                        """;

        try (
                Connection connection =
                        DatabaseManager.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setString(
                    1,
                    username
            );

            ResultSet result =
                    statement.executeQuery();

            if (result.next()) {

                User user =
                        new User();

                user.setUsername(
                        result.getString("username")
                );

                user.setPassword(
                        result.getString("password")
                );

                user.setFullName(
                        result.getString("full_name")
                );

                user.setRole(
                        UserRole.valueOf(
                                result.getString("role")
                        )
                );

                return user;

            }


        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }



    /*
        Benutzer speichern
        z.B. für neue Mitarbeiter
    */

    public void save(
            User user
    ) {

        String sql =
                """
                        INSERT INTO users
                        (
                        username,
                        password,
                        full_name,
                        role
                        )
                        
                        VALUES(?,?,?,?)
                        """;

        try (

                Connection connection =
                        DatabaseManager.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setString(
                    1,
                    user.getUsername()
            );

            statement.setString(
                    2,
                    user.getPassword()
            );

            statement.setString(
                    3,
                    user.getFullName()
            );

            statement.setString(
                    4,
                    user.getRole().name()
            );

            statement.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();

        }


    }


}