package com.hotel.service;


import com.hotel.model.Guest;
import com.hotel.repository.GuestRepository;


import java.util.List;



public class GuestService {



    private final GuestRepository guestRepository;




    public GuestService(){


        guestRepository =
                new GuestRepository();


    }





    /*
        Gast erstellen
    */

    public void createGuest(
            Guest guest
    ){


        guestRepository.save(
                guest
        );


    }







    /*
        Alle Gäste laden
    */

    public List<Guest> getGuests(){


        return guestRepository.findAll();


    }







    /*
        Gast löschen
    */

    public void deleteGuest(

            int guestId

    ){


        guestRepository.delete(
                guestId
        );


    }





    /*
        Gast suchen
    */

    public Guest getGuestById(

            int guestId

    ){


        return guestRepository.findById(
                guestId
        );


    }



}