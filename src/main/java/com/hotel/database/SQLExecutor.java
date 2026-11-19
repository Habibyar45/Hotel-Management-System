package com.hotel.database;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.Statement;



public class SQLExecutor {



    public static void executeSQLFile(
            String filePath
    ){


        try(


                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(filePath)
                        );


                Connection connection =
                        DatabaseManager.getConnection();


                Statement statement =
                        connection.createStatement()


        ){


            StringBuilder sql =
                    new StringBuilder();



            String line;



            while(
                    (line = reader.readLine())
                            != null
            ){


                sql.append(line);



                if(line.trim().endsWith(";")){


                    statement.execute(
                            sql.toString()
                    );


                    sql.setLength(0);

                }


            }


            System.out.println(
                    filePath +
                            " executed successfully"
            );


        }
        catch(IOException e){


            System.out.println(
                    "SQL file not found: "
                            + filePath
            );


            e.printStackTrace();


        }
        catch(Exception e){


            e.printStackTrace();

        }


    }


}