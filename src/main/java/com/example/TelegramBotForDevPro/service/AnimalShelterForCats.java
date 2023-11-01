package com.example.TelegramBotForDevPro.service;

//import com.example.TelegramBotForDevPro.repository.AnimalShelterRepository;
import com.example.TelegramBotForDevPro.buttons.Option1;
import com.example.TelegramBotForDevPro.buttons.Option2;
//import com.pengrad.telegrambot.TelegramBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class AnimalShelterForCats extends TelegramLongPollingBot {
    Option1 option1;
    Option2 option2;

@Autowired
    public AnimalShelterForCats(Option1 option1, Option2 option2) {
    this.option1 = option1;
    this.option2 = option2;
    }

    private Logger logger = LoggerFactory.getLogger(AnimalShelterForCats.class);
//    AnimalShelterRepository animalShelterRepository;
//
//
//    @Autowired
//
//    public AnimalShelterForCats(AnimalShelterRepository animalShelterRepository) {
//        this.animalShelterRepository = animalShelterRepository;
//    }

    @Autowired
//    private TelegramBot telegramBot;


    @Override
    public String getBotUsername() {
        return "@farrytail_bot";
    }

    @Override
    public String getBotToken() {
        return "6695921384:AAH9jQ9X0boP8_qZKGVsdLK381Fn7o2kKkc";
    }


    private void sendText(Long who, String hail) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(who.toString())
                .text(hail).build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        long messageId = update.getCallbackQuery().getMessage().getMessageId();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
//        Message message = update.getMessage();
        var message = update.getMessage();
        var userId = message.getFrom().getId();
        if (update.hasMessage()) {
//
            option1.register1(chatId);
        }


            if (update.hasCallbackQuery()) {
                String callbackData = update.getCallbackQuery().getData();
                switch (callbackData) {
                    case ("cat_button") -> {
                        EditMessageText messageText = new EditMessageText();
                        messageText.setChatId(String.valueOf(chatId));
                        messageText.setText("choose");
                        messageText.setMessageId((int) messageId);
                        try {
                            execute(messageText);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                        option1.register2(chatId);

                    }
                    case ("head3_button")-> {
                        option2.register3(chatId);
                    }
                    case "query1_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(chatId), "вот информация по коту по выбору 1");
                        //
                        //
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query2_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 2");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query3_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 3");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query4_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 4");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query5_2_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(chatId), "вот информация по коту по выбору 5.2");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query6_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 6");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query7_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 7");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            logger.info("Processing update: {}", update);
                        }
                    }
                    case "query11_button" -> {
                        SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 11");
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


