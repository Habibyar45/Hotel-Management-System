package com.hotel.controller;


import com.hotel.model.Guest;
import com.hotel.service.GuestService;


import java.util.List;



public class GuestController {



    private final GuestService service;




    public GuestController(){


        service =
                new GuestService();

    }






    public void addGuest(
            Guest guest
    ){


        service.createGuest(
                guest
        );


    }







    public List<Guest> getGuests(){


        return service.getGuests();


    }





    public void deleteGuest(
            int id
    ){


        service.deleteGuest(id);


    }


}