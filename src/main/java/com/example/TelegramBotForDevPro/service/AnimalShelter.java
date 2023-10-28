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
            if (update.getMessage().hasText()) {
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
            }
            register1();
            if (update.hasCallbackQuery()) {
                String callbackData = update.getCallbackQuery().getData();
                long messageId = update.getCallbackQuery().getMessage().getMessageId();
                long chatId = update.getCallbackQuery().getMessage().getChatId();
                if (callbackData.equals("cat_button")) {
                    register2();
                }
                if (callbackData.equals("head3_button")) {
                    register3();
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

    private void register1() {
        SendMessage message = new SendMessage();
        message.getChatId();
        message.setText("choose, please");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var catButton = new InlineKeyboardButton();
        catButton.setText("Cat");
        catButton.setCallbackData("cat_button");

        var dogButton = new InlineKeyboardButton();
        dogButton.setText("Dog");
        dogButton.setCallbackData("dog_button");

        rowInLine.add(catButton);
        rowInLine.add(dogButton);
        rowsInLine.add(rowInLine);
        markup.setKeyboard(rowsInLine);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Error occurred: " + e.getMessage());
        }
    }


    private void register2() {
        SendMessage message = new SendMessage();
        message.getChatId();
        message.setText("choose, please");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var head1Button = new InlineKeyboardButton();
        head1Button.setText("Определение запроса");
        head1Button.setCallbackData("head1_button");

        var head2Button = new InlineKeyboardButton();
        head2Button.setText("Консультация с новым пользователем");
        head2Button.setCallbackData("head2_button");

        var head3Button = new InlineKeyboardButton();
        head3Button.setText("Консультация с потенциальным хозяином животного из приюта");
        head3Button.setCallbackData("head3_button");

        var head4Button = new InlineKeyboardButton();
        head4Button.setText("Ведение питомца");
        head4Button.setCallbackData("head4_button");

        rowInLine.add(head1Button);
        rowInLine.add(head2Button);
        rowInLine.add(head3Button);
        rowInLine.add(head4Button);
        rowsInLine.add(rowInLine);
        markup.setKeyboard(rowsInLine);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Error occurred: " + e.getMessage());
        }


    }

    private void register3() {
        SendMessage message = new SendMessage();
        message.getChatId();
        message.setText("choose, please");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var query1Button = new InlineKeyboardButton();
        query1Button.setText("Правила знакомства с животным до того, как забрать его из приюта");
        query1Button.setCallbackData("query1_button");

        var query2Button = new InlineKeyboardButton();
        query2Button.setText("Список документов, необходимых для того, чтобы взять животное из приюта");
        query2Button.setCallbackData("query2_button");

        var query3Button = new InlineKeyboardButton();
        query3Button.setText("Список рекомендаций по транспортировке животного");
        query3Button.setCallbackData("query_button");

        var query4Button = new InlineKeyboardButton();
        query4Button.setText("выдать список рекомендаций по транспортировке животного");
        query4Button.setCallbackData("query4_button");

        rowInLine.add(query1Button);
        rowInLine.add(query2Button);
        rowInLine.add(query3Button);
        rowInLine.add(query4Button);
        rowsInLine.add(rowInLine);
        markup.setKeyboard(rowsInLine);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Error occurred: " + e.getMessage());
        }
    }
}

