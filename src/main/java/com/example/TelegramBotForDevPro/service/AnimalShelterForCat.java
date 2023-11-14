//package com.example.TelegramBotForDevPro.service;
//
////import com.example.TelegramBotForDevPro.repository.AnimalShelterRepository;
//import com.example.TelegramBotForDevPro.buttons.Option1;
//import com.example.TelegramBotForDevPro.buttons.Option2;
//
//import com.example.TelegramBotForDevPro.configuration.TelegramBotConfigurations;
//import com.example.TelegramBotForDevPro.model.CatReport;
//import com.example.TelegramBotForDevPro.repository.CatReportRepository;
//import jakarta.annotation.PostConstruct;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
//import org.telegram.telegrambots.meta.api.objects.Message;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//@Service
//public class AnimalShelterForCats extends TelegramLongPollingBot {
//    Option1 option1;
//    Option2 option2;
//    CatReport catReport;
//    CatReportRepository catReportRepository;
//    TelegramBotConfigurations telegramBotConfigurations;
//    AnimalShelterForDogs animalShelterForDogs;
//
//
//    @Autowired
//    public AnimalShelterForCats(Option1 option1, Option2 option2, CatReport catReport,
//                                CatReportRepository catReportRepository, TelegramBotConfigurations telegramBotConfigurations,
//                                AnimalShelterForDogs animalShelterForDogs) {
//        this.option1 = option1;
//        this.option2 = option2;
//        this.catReport = catReport;
//        this.catReportRepository = catReportRepository;
//        this.telegramBotConfigurations = telegramBotConfigurations;
//        this.animalShelterForDogs = animalShelterForDogs;
//    }
//
//    @PostConstruct
//    public void create() {
//        logger.error("!!!!!!!");
//        System.out.println("!!!!!");
//    }
//
//    private Logger logger = LoggerFactory.getLogger(AnimalShelterForCats.class);
////    AnimalShelterRepository animalShelterRepository;
////
////
////    @Autowired
////
////    public AnimalShelterForCats(AnimalShelterRepository animalShelterRepository) {
////        this.animalShelterRepository = animalShelterRepository;
////    }
//
////    @Autowired
////    private TelegramBot telegramBot;
//
//
//    @Override
//    public String getBotUsername() {
//        return telegramBotConfigurations.getBotName();
//    }
//
//    @Override
//    public String getBotToken() {
//        return telegramBotConfigurations.getToken();
//    }
//
//
//    //    private void sendText(Long who, String hail) {
////        SendMessage sendMessage = SendMessage.builder()
////                .chatId(who.toString())
////                .text(hail).build();
////        try {
////            execute(sendMessage);
////        } catch (TelegramApiException e) {
////            throw new RuntimeException();
////        }
////    }
//    @Override
//    public void onUpdateReceived(Update update) {
//        System.out.println("?");
//        Long chatId1 = update.getMessage().getChatId();
//        long messageId = update.getCallbackQuery().getMessage().getMessageId();
//        long chatId = update.getCallbackQuery().getMessage().getChatId();
//        Message message = update.getMessage();
////        var message = update.getMessage();
////        var userId = message.getFrom().getId();
////        if (update.hasMessage()) {
//////
////            option1.register1(chatId);
//        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
//            try {
//                execute(
//                        SendMessage
//                                .builder()
//                                .chatId(message.getChatId().toString())
//                                .text("Hi")
//                                .build());
//            } catch (TelegramApiException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        option1.register1(chatId);
//
//        if (update.hasCallbackQuery()) {
//            String callbackData = update.getCallbackQuery().getData();
//            switch (callbackData) {
//                case ("cat_button") -> {
//                    EditMessageText messageText = new EditMessageText();
//                    messageText.setChatId(String.valueOf(chatId));
//                    messageText.setText("choose");
//                    messageText.setMessageId((int) messageId);
//                    try {
//                        execute(messageText);
//                    } catch (TelegramApiException e) {
//                        logger.info("Processing update: {}", update);
//                    }
//                    option1.register2(chatId);
//
//                }
//                case ("head3_button") -> {
//                    option2.register3(chatId);
//                }
//
//                case "query1_button" -> {
//                    SendMessage sendMessage = new SendMessage(String.valueOf(chatId), "вот информация по коту по выбору 1");
//                    //
//                    //
//                    try {
//                        execute(sendMessage);
//                    } catch (TelegramApiException e) {
//                        logger.info("Processing update: {}", update);
//                    }
//                }
//                case "query2_button" -> {
//                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 2");
//                    try {
//                        execute(sendMessage);
//                    } catch (TelegramApiException e) {
//                        logger.info("Processing update: {}", update);
//                    }
//                }
//                case "query3_button" -> {
//                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 3");
//                    try {
//                        execute(sendMessage);
//                    } catch (TelegramApiException e) {
//                        logger.info("Processing update: {}", update);
//                    }
//                }
//                case "query4_button" -> {
//                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 4");
//                    try {
//                        execute(sendMessage);
//                    } catch (TelegramApiException e) {
//                        logger.info("Processing update: {}", update);
//                    }
//                }
//                case "query5_2_button" -> {
//                    SendMessage sendMessage = new SendMessage(String.valueOf(chatId), "вот информация по коту по выбору 5.2");
//                    try {
//                        execute(sendMessage);
//                    } catch (TelegramApiException e) {
//                        logger.info("Processing update: {}", update);
//                    }
//                }
//                case "query6_button" -> {
//                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 6");
//                    try {
//                        execute(sendMessage);
//                    } catch (TelegramApiException e) {
//                        logger.info("Processing update: {}", update);
//                    }
//                }
//                case "query7_button" -> {
//                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 7");
//                    try {
//                        execute(sendMessage);
//                    } catch (TelegramApiException e) {
//                        logger.info("Processing update: {}", update);
//                    }
//                }
//                case "query11_button" -> {
//                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 11");
//                    try {
//                        execute(sendMessage);
//                    } catch (TelegramApiException e) {
//                        logger.info("Processing update: {}", update);
//                    }
//                }
//
//                case ("head4_button") -> {
//                    if (!(update.getMessage().hasPhoto())) {
//                        SendMessage noPhoto = new SendMessage(String.valueOf(messageId), "Пришлите фото");
//                        try {
//                            execute(noPhoto);
//                        } catch (TelegramApiException e) {
//                            logger.info("Processing update: {}", update);
//                        }
//                        if (!(update.getMessage().hasText())) {
//                            SendMessage noText = new SendMessage(String.valueOf(messageId), "Пришлите текст");
//
//                            try {
//                                execute(noText);
//                            } catch (TelegramApiException e) {
//                                logger.info("Processing update: {}", update);
//                            }
//                            if (update.getMessage().hasPhoto() && update.getMessage().hasText()) {
//                                System.out.println(update.toString());
//                                catReport.setPhoto(String.valueOf(update.getMessage().hasPhoto()).getBytes());
//                                catReport.setRation(String.valueOf(update.getMessage().hasText()));
//                                catReport.setHabits(String.valueOf(update.getMessage().hasText()));
//                                catReport.setBehavior(String.valueOf(update.getMessage().hasText()));
//                            }
//                        }
//                    }
//                }
////                default -> animalShelterForDogs.onUpdateReceived(update);
//            }
//        }
//    }
//}
//
//
