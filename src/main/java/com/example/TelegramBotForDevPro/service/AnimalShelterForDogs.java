package com.example.TelegramBotForDevPro.service;

import com.example.TelegramBotForDevPro.buttons.Option1;
import com.example.TelegramBotForDevPro.buttons.Option2;
import com.pengrad.telegrambot.TelegramBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class AnimalShelterForDogs extends TelegramLongPollingBot {
    Option1 option1;
    Option2 option2;

    @Autowired
    public AnimalShelterForDogs(Option1 option1, Option2 option2) {
        this.option1 = option1;
        this.option2 = option2;
    }

    private Logger logger = LoggerFactory.getLogger(AnimalShelterForDogs.class);
//    AnimalShelterRepository animalShelterRepository;
//
//
//    @Autowired
//
//    public AnimalShelterForDogs(AnimalShelterRepository animalShelterRepository) {
//        this.animalShelterRepository = animalShelterRepository;
//    }

    @Autowired
    private TelegramBot telegramBot;


    @Override
    public String getBotUsername() {
        return "@farrytail_bot";
    }

    @Override
    public String getBotToken() {
        return "6695921384:AAH9jQ9X0boP8_qZKGVsdLK381Fn7o2kKkc";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (update.getMessage().getText().equals("/start")) {
                try {
                    execute(
                            SendMessage
                                    .builder()
                                    .chatId(message.getChatId().toString())
                                    .text("Hi")
                                    .build());
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            option1.register1();
            if (update.hasCallbackQuery()) {
                String callbackData = update.getCallbackQuery().getData();
                long messageId = update.getCallbackQuery().getMessage().getMessageId();
                long chatId = update.getCallbackQuery().getMessage().getChatId();

                switch (callbackData) {
                    case ("dog_button") -> {
                        option1.register2();
                    }
                    case ("head3_button")-> {
                        option2.register3();
                    }
                    case "query1_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 1");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query2_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 2");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query3_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 3");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query4_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 4");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query5_1_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 5.1");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query6_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 6");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query7_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 7");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query8_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 8");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query9_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 9");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query10_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 10");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query11_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация для собак по выбору 11");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                }
            }
        }
    }
}

