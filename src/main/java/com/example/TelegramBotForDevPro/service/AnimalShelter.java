package com.example.TelegramBotForDevPro.service;

//import com.example.TelegramBotForDevPro.repository.AnimalShelterRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.EditMessageText;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
@Service
public class AnimalShelter extends TelegramLongPollingBot {
    Options options;
@Autowired
    public AnimalShelter(Options options) {
        this.options = options;
    }

    private Logger logger = LoggerFactory.getLogger(AnimalShelter.class);
//    AnimalShelterRepository animalShelterRepository;
//
//
//    @Autowired
//
//    public AnimalShelter(AnimalShelterRepository animalShelterRepository) {
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

            options.register1();
            if (update.hasCallbackQuery()) {
                String callbackData = update.getCallbackQuery().getData();
                long messageId = update.getCallbackQuery().getMessage().getMessageId();
                long chatId = update.getCallbackQuery().getMessage().getChatId();
                if (callbackData.equals("cat_button")) {
                    options.register2();
                }
                if (callbackData.equals("head3_button")) {
                    options.register3();
                }
                switch (callbackData) {
                    case "query1_button" -> {
                        message.getChatId();
                        message.setText("вот информация по выбору 1");
                        message.setMessageId((int) messageId);
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по выбору 1");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query2_button" -> {
                        message.getChatId();
                        message.setText("вот информация по выбору 2");
                        message.setMessageId((int) messageId);
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по выбору 2");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query3_button" -> {
                        message.getChatId();
                        message.setText("вот информация по выбору 3");
                        message.setMessageId((int) messageId);
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по выбору 3");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query4_button" -> {
                        message.getChatId();
                        message.setText("вот информация по выбору 4");
                        message.setMessageId((int) messageId);
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по выбору 4");
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

