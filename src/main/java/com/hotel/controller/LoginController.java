package com.hotel.controller;


import com.hotel.service.AuthService;



public class LoginController {


    private final AuthService authService;



    public LoginController(){

        authService =
                new AuthService();

    }





    public boolean login(
            String username,
            String password
    ){


        return authService.login(
                username,
                password
        );


    }


}