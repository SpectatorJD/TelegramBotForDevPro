package com.example.TelegramBotForDevPro.service;

import com.example.TelegramBotForDevPro.configuration.TelegramBotConfiguration;
import com.example.TelegramBotForDevPro.repository.AnimalShelterRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class AnimalShelter extends TelegramLongPollingBot {

    private Logger logger = LoggerFactory.getLogger(AnimalShelter.class);
    AnimalShelterRepository animalShelterRepository;


    @Autowired

    public AnimalShelter(AnimalShelterRepository animalShelterRepository) {
        this.animalShelterRepository = animalShelterRepository;
    }

    @Autowired
    private TelegramBot telegramBot;

//    @PostConstruct
//    public void init() {

//        telegramBot.(this);

//    }
@Override
public String getBotUsername() {
    return "@farrytail_bot";
}

    @Override
    public String getBotToken() {
       return "6695921384:AAH9jQ9X0boP8_qZKGVsdLK381Fn7o2kKkc";
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(org.telegram.telegrambots.meta.api.objects.Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
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
//            handlerMessage(update.getMessage());
        }
    }
//@SneakyThrows
//    private void handlerMessage(Message message) {
//    if (message.hasText() && message.hasEntities()) {
//        Optional<MessageEntity> commandEntity = message.getEntities().stream()
//                .filter(e -> "bot_command".equals(e.getType()))
//                .findFirst();
//        if (commandEntity.isPresent()) {
//            String command = message.getText().substring((commandEntity.get().getOffset()),
//                    commandEntity.get().getLength());
//            switch (command) {
//                case "/Консультация с потенциальным хозяином животного из приюта ":
//                    List<List<InlineKeyboardButton>> bottons;
//                    execute(SendMessage.builder().text("Пожалуста выберети что вы хотите знать")
//                            .chatId(message.getChatId()
//                                    .toString())
//                            .replyMarkup(InlineKeyboardMarkup.builder().keyboard().build())
//                            .build());
//            }
//        }
//    }
//    }


//    public int process(List<Update> updates) {
//        updates.forEach(update -> {
//            logger.info("Processing update: {}", update);
//                    if (update.message().text().equals("/start")) {
//                        SendMessage message = new SendMessage(update.message().chat().id(), "Hi");
//                        telegramBot.execute(message);
//                    }
////            takeMassages(updates);
//
//
//        });
//        return UpdatesListener.CONFIRMED_UPDATES_ALL;
//    }

//    public int takeMassages(List<Update> updates) {
//        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
//        Arrays.asList(
//                InlineKeyboardButton.builder().text("правила знакомства с животным до того, как забрать его из приюта")
//                        .callbackData("вот информация по выбору 1").build(),
//                InlineKeyboardButton.builder().text("список документов, необходимых для того, чтобы взять животное из приюта")
//                        .callbackData("вот информация по выбору 2").build(),
//                InlineKeyboardButton.builder().text("список рекомендаций по транспортировке животного")
//                        .callbackData("вот информация по выбору 3"),
//                InlineKeyboardButton.builder().text(" выдать список рекомендаций по транспортировке животного")
//                        .callbackData("вот информация по выбору 4").build(),
//                InlineKeyboardButton.builder().text("выдать список рекомендаций по обустройству дома для щенка/котенка.")
//                        .callbackData("вот информация по выбору 5").build(),
//                InlineKeyboardButton.builder().text("выдать список рекомендаций по обустройству дома для взрослого животного. ")
//                        .callbackData("вот информация по выбору 6"),
//                InlineKeyboardButton.builder().text("выдать список рекомендаций по обустройству дома для животного с ограниченными возможностями " +
//                                "(зрение, передвижение). ")
//                        .callbackData("вот информация по выбору 7").build(),
//                InlineKeyboardButton.builder().text("выдать список рекомендаций по обустройству дома для животного с ограниченными возможностями " +
//                                "(зрение, передвижение). ")
//                        .callbackData("вот информация по выбору 8").build(),
//                InlineKeyboardButton.builder().text("выдать рекомендации по проверенным кинологам для дальнейшего обращения к ним" +
//                                " (неактуально для кошачьего приюта, реализовать только для приюта для собак).")
//                        .callbackData("вот информация по выбору 9"),
//                InlineKeyboardButton.builder().text("выдать список причин, почему могут отказать и не дать забрать собаку из приюта.  ")
//                        .callbackData("вот информация по выбору 10").build(),
//                InlineKeyboardButton.builder().text("принять и записать контактные данные для связи")
//                        .callbackData("вот информация по выбору 11").build()
//                );//Если бот не может ответить на вопросы клиента, то можно позвать волонтера.
//
//        return UpdatesListener.CONFIRMED_UPDATES_ALL;
//        }
//
    }

