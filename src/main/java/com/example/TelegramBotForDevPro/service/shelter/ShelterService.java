package com.example.TelegramBotForDevPro.service.shelter;


import com.example.TelegramBotForDevPro.entity.shelter.AnimalShelter;



public interface ShelterService <T extends AnimalShelter> {



    String updateName(AnimalShelter t, String name);


    String updateAddress(AnimalShelter t, String address);


    String updateContact(AnimalShelter t, String contact);


    String updateDescription(AnimalShelter t, String description);

}
