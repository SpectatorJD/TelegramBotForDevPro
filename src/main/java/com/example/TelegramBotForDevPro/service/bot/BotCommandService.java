package com.example.TelegramBotForDevPro.service.bot;


import com.example.TelegramBotForDevPro.configuration.CommandType;
import com.example.TelegramBotForDevPro.entity.person.Customer;
import com.example.TelegramBotForDevPro.entity.shelter.AnimalShelter;
import com.pengrad.telegrambot.model.Message;

import javax.validation.constraints.NotNull;


public interface BotCommandService {


    void runAbout(@NotNull Customer customer);


    void runAdopt(Long chatId, AnimalShelter shelter);


    void runCats(Long chatId, AnimalShelter shelter);


    void runDogs(Long chatId, AnimalShelter shelter);


    void runStart(Long chatId);


    void runInfo(Long chatId, AnimalShelter shelter);


    void runShelter(Long chatId, AnimalShelter shelter);


    void runSecurity(Long chatId, AnimalShelter shelter);


    void runSafety(Long chatId, AnimalShelter shelter);


    void runReport(Long chatId);


    void saveReport(Message message);


    void runVolunteer(Long chatId);


    void runTelephone(Long chatId);


    void saveTelephone(long chatId, String phone);


    void sendMessageToVolunteer(Long chatId, String text);


    void runContact(Long chatId, AnimalShelter shelter);


    void runLocation(Long chatId, AnimalShelter shelter);


    void sendMessage(@NotNull Long chatId, String message);

    void runTopic2(Long chatId);


    void runOption1(Long chatId);


    void runOption2(Long chatId);


    void runOption3(Long chatId);


    void runOption4(Long chatId);


    void runOption5_1(Long chatId);


    void runOption5_2(Long chatId);


    void runOption6(Long chatId);


    void runOption7(Long chatId);


    void runOption8(Long chatId);


    void runOption9(Long chatId);


    void runOption10(Long chatId);


    void runOption11(Long chatId);
}


