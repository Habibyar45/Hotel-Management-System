package com.hotel.repository;


import com.hotel.database.DatabaseManager;
import com.hotel.model.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class RoomRepository {



    public void save(Room room){


        String sql =
                """
                INSERT INTO rooms
                (room_number,room_type,price,status)

                VALUES(?,?,?,?)
                """;



        try(

                Connection connection =
                        DatabaseManager.getConnection();


                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ){


            statement.setString(
                    1,
                    room.getRoomNumber()
            );


            statement.setString(
                    2,
                    room.getRoomType().name()
            );


            statement.setDouble(
                    3,
                    room.getPrice()
            );


            statement.setString(
                    4,
                    room.getStatus().name()
            );


            statement.executeUpdate();


        }
        catch(SQLException e){

            e.printStackTrace();

        }


    }







    public List<Room> findAll(){


        List<Room> rooms =
                new ArrayList<>();


        String sql =
                "SELECT * FROM rooms";



        try(

                Connection connection =
                        DatabaseManager.getConnection();


                Statement statement =
                        connection.createStatement();


                ResultSet result =
                        statement.executeQuery(sql)

        ){


            while(result.next()){


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
                                        "status"
                                )
                        )
                );


                rooms.add(room);


            }


        }
        catch(SQLException e){

            e.printStackTrace();

        }



        return rooms;


    }








    public List<Room> findAvailableRooms(){


        List<Room> rooms =
                new ArrayList<>();


        String sql =
                """
                SELECT *
                FROM rooms
                WHERE status='AVAILABLE'
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
                                        "status"
                                )
                        )
                );


                rooms.add(room);


            }



        }
        catch(SQLException e){

            e.printStackTrace();

        }



        return rooms;


    }









    public void updateStatus(

            int roomId,

            RoomStatus status

    ){



        String sql =
                """
                UPDATE rooms

                SET status=?

                WHERE room_id=?

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
                    roomId
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
                DELETE FROM rooms

                WHERE room_id=?

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



}