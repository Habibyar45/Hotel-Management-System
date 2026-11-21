package com.hotel.database;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;


public class DatabaseManager {


    private static final String URL =
            "jdbc:sqlite:hotel.db";


    public static Connection getConnection()
            throws SQLException {

        Connection connection =
                DriverManager.getConnection(URL);

        initializeDatabase(connection);

        return connection;

    }


    private static void initializeDatabase(
            Connection connection
    ) {

        try {

            Statement statement =
                    connection.createStatement();

            ResultSet result =
                    statement.executeQuery(

                            """
                                    SELECT name
                                    FROM sqlite_master
                                    WHERE type='table'
                                    """

                    );

            boolean hasTables =
                    result.next();

            if (!hasTables) {

                executeSQLFile(
                        connection,
                        "/schema.sql"
                );

                executeSQLFile(
                        connection,
                        "/seed.sql"
                );


            }


        } catch (Exception e) {

            e.printStackTrace();

        }


    }


    private static void executeSQLFile(

            Connection connection,

            String file

    )
            throws Exception {

        InputStream input =
                DatabaseManager.class
                        .getResourceAsStream(file);

        if (input == null) {

            throw new RuntimeException(
                    "SQL Datei nicht gefunden: "
                            + file
            );


        }

        BufferedReader reader =
                new BufferedReader(

                        new InputStreamReader(
                                input
                        )

                );

        StringBuilder sql =
                new StringBuilder();

        String line;

        while (
                (line = reader.readLine())
                        != null
        ) {

            sql.append(line);

            sql.append("\n");


        }

        String[] commands =
                sql.toString()
                        .split(";");

        Statement statement =
                connection.createStatement();

        for (String command : commands) {

            if (!command.trim().isEmpty()) {

                statement.execute(
                        command
                );


            }

        }


    }


}