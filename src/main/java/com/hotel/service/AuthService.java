package com.hotel.service;


import com.hotel.model.User;
import com.hotel.repository.UserRepository;



public class AuthService {


    private final UserRepository userRepository;



    public AuthService(){

        userRepository =
                new UserRepository();

    }





    public boolean login(
            String username,
            String password
    ){



        User user =
                userRepository
                        .findByUsername(username);



        if(user == null){

            return false;

        }



        if(user.getPassword()
                .equals(password)){



            UserSession.login(user);


            return true;

        }



        return false;


    }






    public User getCurrentUser(){


        return UserSession.getCurrentUser();


    }


}