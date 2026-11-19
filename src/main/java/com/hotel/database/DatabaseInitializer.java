package com.hotel.database;


import com.hotel.model.User;
import com.hotel.model.UserRole;
import com.hotel.repository.UserRepository;
import com.hotel.util.PasswordUtil;



public class DatabaseInitializer {


    public static void initialize(){


        try{


            DatabaseManager.getConnection();



            createAdminUser();



        }
        catch(Exception e){

            e.printStackTrace();

        }


    }






    private static void createAdminUser(){


        UserRepository repository =
                new UserRepository();



        User existing =
                repository.findByUsername(
                        "admin"
                );



        if(existing != null){

            return;

        }



        User admin =
                new User();



        admin.setUsername(
                "admin"
        );



        admin.setPassword(

                PasswordUtil.hashPassword(
                        "admin123"
                )

        );



        admin.setFullName(
                "System Administrator"
        );



        admin.setRole(
                UserRole.ADMIN
        );



        repository.save(
                admin
        );


        System.out.println(
                "Admin user created"
        );


    }


}