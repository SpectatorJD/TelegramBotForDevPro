package com.example.TelegramBotForDevPro.service;

//import com.example.TelegramBotForDevPro.repository.AnimalShelterRepository;

import com.example.TelegramBotForDevPro.configuration.TelegramBotConfigurations;
import com.example.TelegramBotForDevPro.model.CatReport;
import com.example.TelegramBotForDevPro.repository.CatReportRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalShelter extends TelegramLongPollingBot {

//    CatReport catReport;
//    CatReportRepository catReportRepository;
    TelegramBotConfigurations telegramBotConfigurations;



    @Autowired
    public AnimalShelter(
//            CatReport catReport,
//            CatReportRepository catReportRepository,
            TelegramBotConfigurations telegramBotConfigurations) {

//        this.catReport = catReport;
//        this.catReportRepository = catReportRepository;
        this.telegramBotConfigurations = telegramBotConfigurations;

    }

    @PostConstruct
    public void create() {
        logger.error("!!!!!!!");
        System.out.println("!!!!!");
    }

    private Logger logger = LoggerFactory.getLogger(AnimalShelter.class);
//    AnimalShelterRepository animalShelterRepository;
//
//
//    @Autowired21432536
//
//    public AnimalShelter(AnimalShelterRepository animalShelterRepository) {
//        this.animalShelterRepository = animalShelterRepository;
//    }

//    @Autowired
//    private TelegramBot telegramBot;


    @Override
    public String getBotUsername() {
        return telegramBotConfigurations.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramBotConfigurations.getToken();
    }


    //    private void sendText(Long who, String hail) {
//        SendMessage sendMessage = SendMessage.builder()
//                .chatId(who.toString())
//                .text(hail).build();
//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            throw new RuntimeException();
//        }
//    }
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("?");

        Message message = update.getMessage();
//        var message = update.getMessage();
//        var userId = message.getFrom().getId();
//        if (update.hasMessage()) {
////
//            register1(chatId);
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
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

//    }


        if (update.hasCallbackQuery()) {
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            register1(chatId);
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
                    register2(chatId);

                }
                case ("head3_cat_button") -> {
                    register3(chatId);
                }

                case "query1_cat_button" -> {
                    SendMessage sendMessage = new SendMessage(String.valueOf(chatId), "вот информация по коту по выбору 1");
                    //
                    //1
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        logger.info("Processing update: {}", update);
                    }
                }
                case "query2_cat_button" -> {
                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 2");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        logger.info("Processing update: {}", update);
                    }
                }
                case "query3_cat_button" -> {
                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 3");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        logger.info("Processing update: {}", update);
                    }
                }
                case "query4_cat_button" -> {
                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 4");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        logger.info("Processing update: {}", update);
                    }
                }
                case "query5_cat_button" -> {
                    SendMessage sendMessage = new SendMessage(String.valueOf(chatId), "вот информация по коту по выбору 5.2");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        logger.info("Processing update: {}", update);
                    }
                }
                case "query6_cat_button" -> {
                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 6");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        logger.info("Processing update: {}", update);
                    }
                }
                case "query7_cat_button" -> {
                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 7");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        logger.info("Processing update: {}", update);
                    }
                }
                case "query11_cat_button" -> {
                    SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по коту по выбору 11");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        logger.info("Processing update: {}", update);
                    }
                }

//                case ("head4_cat_button") -> {
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
                        case "dog_button" -> {
                            register2(chatId);
                        }
                        case ("head3_dog_button")-> {
                            register3(chatId);

                        }
                        case "query1_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(chatId), "вот информация по собаке по выбору 1");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query2_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 2");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query3_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 3");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query4_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 4");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query5_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 5.1");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query6_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 6");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query7_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 7");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query8_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 8");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query9_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 9");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query10_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 10");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }

                        }
                        case "query11_dog_button" -> {
                            SendMessage sendMessage = new SendMessage(String.valueOf(messageId), "вот информация по собаке по выбору 11");
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                logger.info("Processing update: {}", update);
                            }
                        }
                    }
                }
                    }
    public void register1(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("choose, please");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();

        var catButton = new InlineKeyboardButton();
        catButton.setText("Cat");
        catButton.setCallbackData("cat_button");

        var dogButton = new InlineKeyboardButton();
        dogButton.setText("Dog");
        dogButton.setCallbackData("dog_button");

        rowInLine1.add(catButton);
        rowInLine2.add(dogButton);
        rowsInLine.add(rowInLine1);
        rowsInLine.add(rowInLine2);
        markup.setKeyboard(rowsInLine);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Error occurred: " + e.getMessage());
        }
    }

    public void register2(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("choose, please");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();

        var head1CatButton = new InlineKeyboardButton();
        head1CatButton.setText("Определение запроса");
        head1CatButton.setCallbackData("head1_cat_button");

        var head1DogButton = new InlineKeyboardButton();
        head1DogButton.setText("Определение запроса");
        head1DogButton.setCallbackData("head1_button");

        var head2CatButton = new InlineKeyboardButton();
        head2CatButton.setText("Консультация с новым пользователем");
        head2CatButton.setCallbackData("head2_button");

        var head2DogButton = new InlineKeyboardButton();
        head2DogButton.setText("Консультация с новым пользователем");
        head2DogButton.setCallbackData("head2_button");

        var head3CatButton = new InlineKeyboardButton();
        head3CatButton.setText("Консультация с потенциальным хозяином животного из приюта");
        head3CatButton.setCallbackData("head3_cat_button");

        var head3DogButton = new InlineKeyboardButton();
        head3DogButton.setText("Консультация с потенциальным хозяином животного из приюта");
        head3DogButton.setCallbackData("head3_dog_button");

        var head4CatButton = new InlineKeyboardButton();
        head4CatButton.setText("Ведение питомца");
        head4CatButton.setCallbackData("head4_cat_button");

        var head4DogButton = new InlineKeyboardButton();
        head4DogButton.setText("Ведение питомца");
        head4DogButton.setCallbackData("head4_button");

        rowInLine1.add(head1CatButton);
        rowInLine1.add(head1DogButton);
        rowInLine1.add(head2CatButton);
        rowInLine1.add(head2DogButton);
        rowInLine2.add(head3CatButton);
        rowInLine2.add(head3DogButton);
        rowInLine2.add(head4CatButton);
        rowInLine2.add(head4DogButton);
        rowsInLine.add(rowInLine1);
        rowsInLine.add(rowInLine2);
        markup.setKeyboard(rowsInLine);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Error occurred: " + e.getMessage());
        }
    }

    public void register3(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));;
        message.setText("choose, please");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var query1CatButton = new InlineKeyboardButton();
        query1CatButton.setText("Правила знакомства с животным до того, как забрать его из приюта");
        query1CatButton.setCallbackData("query1_cat_button");

        var query1DogButton = new InlineKeyboardButton();
        query1DogButton.setText("Правила знакомства с животным до того, как забрать его из приюта");
        query1DogButton.setCallbackData("query1_dog_button");

        var query2CatButton = new InlineKeyboardButton();
        query2CatButton.setText("Список документов, необходимых для того, чтобы взять животное из приюта");
        query2CatButton.setCallbackData("query2_cat_button");

        var query2DogButton = new InlineKeyboardButton();
        query2DogButton.setText("Список документов, необходимых для того, чтобы взять животное из приюта");
        query2DogButton.setCallbackData("query2_dog_button");

        var query3CatButton = new InlineKeyboardButton();
        query3CatButton.setText("Список рекомендаций по транспортировке животного");
        query3CatButton.setCallbackData("query3_cat_button");

        var query3DogButton = new InlineKeyboardButton();
        query3DogButton.setText("Список рекомендаций по транспортировке животного");
        query3DogButton.setCallbackData("query3_dog_button");

        var query4CatButton = new InlineKeyboardButton();
        query4CatButton.setText("Выдать список рекомендаций по транспортировке животного");
        query4CatButton.setCallbackData("query4_cat_button");

        var query4DogButton = new InlineKeyboardButton();
        query4DogButton.setText("Выдать список рекомендаций по транспортировке животного");
        query4DogButton.setCallbackData("query4_dog_button");

        var query5DogButton = new InlineKeyboardButton();
        query5DogButton.setText("Выдать список рекомендаций по обустройству дома для щенка");
        query5DogButton.setCallbackData("query5_dog_button");

        var query5CatButton = new InlineKeyboardButton();
        query5CatButton.setText("Выдать список рекомендаций по обустройству дома для котенка");
        query5CatButton.setCallbackData("query5_cat_button");

        var query6CatButton = new InlineKeyboardButton();
        query6CatButton.setText("Выдать список рекомендаций по обустройству дома для взрослого животного");
        query6CatButton.setCallbackData("query6_cat_button");

        var query6DogButton = new InlineKeyboardButton();
        query6DogButton.setText("Выдать список рекомендаций по обустройству дома для взрослого животного");
        query6DogButton.setCallbackData("query6_dog_button");

        var query7CatButton = new InlineKeyboardButton();
        query7CatButton.setText("Выдать список рекомендаций по обустройству дома для животного с ограниченными возможностями " +
                "(зрение, передвижение)");
        query7CatButton.setCallbackData("query7_cat_button");

        var query7DogButton = new InlineKeyboardButton();
        query7DogButton.setText("Выдать список рекомендаций по обустройству дома для животного с ограниченными возможностями " +
                "(зрение, передвижение)");
        query7DogButton.setCallbackData("query7_dog_button");

        var query8DogButton = new InlineKeyboardButton();
        query8DogButton.setText("Выдать рекомендации по проверенным кинологам для дальнейшего обращения к ним");
//        неактуально для кошачьего приюта, реализовать только для приюта для собак
        query8DogButton.setCallbackData("query8_dog_button");

        var query9DogButton = new InlineKeyboardButton();
        query9DogButton.setText("Бот может выдать рекомендации по проверенным кинологам для дальнейшего обращения к ним");
//        неактуально для кошачьего приюта, реализовать только для приюта для собак
        query9DogButton.setCallbackData("query9_dog_button");

        var query10DogButton = new InlineKeyboardButton();
        query10DogButton.setText("Бот может выдать список причин, почему могут отказать и не дать забрать собаку из приюта");
        query10DogButton.setCallbackData("query10_dog_button");

        var query11CatButton = new InlineKeyboardButton();
        query11CatButton.setText("Бот может принять и записать контактные данные для связи");
        query11CatButton.setCallbackData("query11_cat_button");

        var query11DogButton = new InlineKeyboardButton();
        query11DogButton.setText("Бот может принять и записать контактные данные для связи");
        query11DogButton.setCallbackData("query11_dog_button");

        rowInLine.add(query1CatButton);
        rowInLine.add(query1DogButton);
        rowInLine.add(query2CatButton);
        rowInLine.add(query2DogButton);
        rowInLine.add(query3CatButton);
        rowInLine.add(query3DogButton);
        rowInLine.add(query4CatButton);
        rowInLine.add(query4DogButton);
        rowInLine.add(query5DogButton);
        rowInLine.add(query5CatButton);
        rowInLine.add(query6CatButton);
        rowInLine.add(query6DogButton);
        rowInLine.add(query7CatButton);
        rowInLine.add(query7DogButton);
        rowInLine.add(query8DogButton);
        rowInLine.add(query9DogButton);
        rowInLine.add(query10DogButton);
        rowInLine.add(query11CatButton);
        rowInLine.add(query11DogButton);
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


