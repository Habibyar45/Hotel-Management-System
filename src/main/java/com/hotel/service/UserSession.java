package com.hotel.service;


import com.hotel.model.User;



public class UserSession {


    private static User currentUser;



    private UserSession(){

    }




    public static void login(User user){

        currentUser = user;

    }




    public static User getCurrentUser(){

        return currentUser;

    }




    public static boolean isLoggedIn(){

        return currentUser != null;

    }




    public static void logout(){

        currentUser = null;

    }


}