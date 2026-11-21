package com.hotel.repository;


import com.hotel.database.DatabaseManager;
import com.hotel.model.Guest;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class GuestRepository {



    public void save(Guest guest){


        String sql =
                """
                        INSERT INTO guests
                        (first_name,last_name,email,phone,address)

                        VALUES (?,?,?,?,?)
                        """;



        try(Connection connection =
                    DatabaseManager.getConnection();


            PreparedStatement statement =
                    connection.prepareStatement(sql)){



            statement.setString(1, guest.getFirstName());

            statement.setString(2, guest.getLastName());

            statement.setString(3, guest.getEmail());

            statement.setString(4, guest.getPhone());

            statement.setString(5, guest.getAddress());


            statement.executeUpdate();



        }catch(SQLException e){

            e.printStackTrace();

        }

    }







    public List<Guest> findAll(){


        List<Guest> guests =
                new ArrayList<>();


        String sql =
                "SELECT * FROM guests";



        try(Connection connection =
                    DatabaseManager.getConnection();


            Statement statement =
                    connection.createStatement();


            ResultSet result =
                    statement.executeQuery(sql)){



            while(result.next()){


                Guest guest =
                        new Guest();


                guest.setGuestId(
                        result.getInt("guest_id")
                );


                guest.setFirstName(
                        result.getString("first_name")
                );


                guest.setLastName(
                        result.getString("last_name")
                );


                guest.setEmail(
                        result.getString("email")
                );


                guest.setPhone(
                        result.getString("phone")
                );


                guest.setAddress(
                        result.getString("address")
                );


                guests.add(guest);


            }


        }catch(SQLException e){

            e.printStackTrace();

        }



        return guests;

    }








    public Guest findById(int id){


        String sql =
                """
                SELECT * FROM guests
                WHERE guest_id=?
                """;



        try(Connection connection =
                    DatabaseManager.getConnection();


            PreparedStatement statement =
                    connection.prepareStatement(sql)){



            statement.setInt(1,id);



            ResultSet result =
                    statement.executeQuery();



            if(result.next()){


                return new Guest(

                        result.getInt("guest_id"),

                        result.getString("first_name"),

                        result.getString("last_name"),

                        result.getString("email"),

                        result.getString("phone"),

                        result.getString("address")

                );

            }


        }catch(SQLException e){

            e.printStackTrace();

        }


        return null;

    }







    public void delete(int id){


        String sql =
                """
                DELETE FROM guests
                WHERE guest_id=?
                """;



        try(Connection connection =
                    DatabaseManager.getConnection();


            PreparedStatement statement =
                    connection.prepareStatement(sql)){



            statement.setInt(1,id);


            statement.executeUpdate();



        }catch(SQLException e){

            e.printStackTrace();

        }


    }


}