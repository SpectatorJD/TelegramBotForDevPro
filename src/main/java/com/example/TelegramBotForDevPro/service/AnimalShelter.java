package com.example.TelegramBotForDevPro.service;

import com.example.TelegramBotForDevPro.configuration.TelegramBotConfiguration;
import com.example.TelegramBotForDevPro.model.Manager;
import com.example.TelegramBotForDevPro.repository.AnimalShelterRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.EditMessageText;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
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
            registar(chatId());
            if (update.hasCallbackQuery()) {
                String callbackData = update.getCallbackQuery().getData();
                long messageId = update.getCallbackQuery().getMessage().getMessageId();
                long chatId = update.getCallbackQuery().getMessage().getChatId();
                if (callbackData.equals("yes_button")) {
                    String text = "text that i see yes";
                   EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
//            logger error("Error occurred: " + e.getMessage());
                    }
                } else if (callbackData.equals("yes_button")) {
                    String text = "text that i see no";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
//            logger error("Error occurred: " + e.getMessage());
                    }
                }
            }
//            if (update.hasCallbackQuery()) {
//                handleCallBack(update.getCallbackQuery());
//            }
//            handlerMessage(update.getMessage());


        }
    }

    private void registar(long chatId) {
        SendMessage message = new SendMessage();
        message.getChatId(String.valueOf(chatId));
        message.setText("do you really want register");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var yesButton = new InlineKeyboardButton();
        yesButton.setText("Yes");
        yesButton.setCallbackData("yes_button");

        var noButton = new InlineKeyboardButton();
        noButton.setText("No");
        noButton.setCallbackData("no_button");

        rowInLine.add(yesButton);
        rowInLine.add(noButton);
        rowsInLine.add(rowInLine);
        markup.setKeyboard(rowsInLine);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
//            logger error("Error occurred: " + e.getMessage());
        }


    }

//    private void handlerMessage(Message message)  {
//    if (message.hasText() && message.hasEntities()) {
//        Optional<MessageEntity> commandEntity = message.getEntities().stream()
//                .filter(e -> "bot_command".equals(e.getType()))
//                .findFirst();
//        if (commandEntity.isPresent()) {
//            String command = message.getText().substring((commandEntity.get().getOffset()),
//                    commandEntity.get().getLength());
//            switch (command) {
//                case "/Консультация с потенциальным хозяином животного из приюта ":
//                    List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
//                    buttons.add(
//                            Arrays.asList(
//                                    InlineKeyboardButton.builder().text("first button").callbackData("first result").build(),
//                                    InlineKeyboardButton.builder().text("second button").callbackData("second result").build()
//                            )
//                    );
//                    try {
//                        execute(SendMessage.builder().text("Пожалуста выберети что вы хотите знать")
//                                .chatId(message.getChatId()
//                                        .toString())
//                                .replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build())
//                                .build());
//                    } catch (TelegramApiException e) {
//                        System.out.println("ошибка в телеграме Api");
//                    }
//            }
//        }
//    }
//    }

//        message.setText(" Что хотите выбрать");
//
//        // создаем объект встроенной клавиатуры
//        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
//
//// создаем список списков кнопок, который впоследствии объединит ряды кнопок
//        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
//
//// создаем список с кнопками для первого ряда
//        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
//
//// создаем первую кнопку для в ряду
//        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
//
//// устанавливаем параметр текста на кнопке
//        inlineKeyboardButton1.setText("Кошки");
//
//// устанавливаем параметр callback_data
//        inlineKeyboardButton1.setCallbackData("/cats");
//
//
//        // создаем по аналогии вторую кнопку в ряду
//        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        inlineKeyboardButton2.setText("Собаки");
//        inlineKeyboardButton2.setCallbackData("/dogs");
//
//// добавляем кнопки в первый ряд в том порядке,
//// какой нам необходим. В рассматриваемом случае ряд будет содержать 2 кнопки,
//// размер которых будет одинаково пропорционально растянут по ширине сообщения,
//// под которым клавиатура располагается
//        rowInline1.add(inlineKeyboardButton1);
//        rowInline1.add(inlineKeyboardButton2);
//
//
//
//        return message;
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

