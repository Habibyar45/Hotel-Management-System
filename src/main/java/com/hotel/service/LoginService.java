package com.hotel.service;


import com.hotel.model.User;
import com.hotel.repository.UserRepository;
import com.hotel.util.PasswordUtil;



public class LoginService {


    private final UserRepository userRepository;



    public LoginService() {


        userRepository =
                new UserRepository();


    }





    public boolean login(

            String username,

            String password

    ) {



        User user =
                userRepository.findByUsername(
                        username
                );



        // Benutzer existiert nicht

        if(user == null){


            System.out.println(
                    "User nicht gefunden"
            );


            return false;

        }




        // TEST: gespeicherter Hash

        System.out.println(
                "Username: "
                        + user.getUsername()
        );


        System.out.println(
                "Gespeicherter Hash: "
                        + user.getPassword()
        );





        // Passwort überprüfen

        return PasswordUtil.verifyPassword(

                password,

                user.getPassword()

        );


    }





    public User getUser(

            String username

    ){


        return userRepository.findByUsername(
                username
        );


    }


}