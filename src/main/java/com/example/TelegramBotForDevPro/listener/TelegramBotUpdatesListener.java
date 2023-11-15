package com.example.TelegramBotForDevPro.listener;

import static com.example.TelegramBotForDevPro.keyboard.Keyboard.*;
import static com.example.TelegramBotForDevPro.keyboard.KeyboardConstant.*;

import com.example.TelegramBotForDevPro.keyboard.Keyboard;
import com.example.TelegramBotForDevPro.repository.AdopterRepository;
import com.example.TelegramBotForDevPro.model.Adopter;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class TelegramBotUpdatesListener implements UpdatesListener {
    private static final Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    private final TelegramBot telegramBot;
    private final Keyboard keyboard;
    private final AdopterRepository adopterRepository;

    public TelegramBotUpdatesListener(TelegramBot telegramBot, Keyboard keyboard, AdopterRepository adopterRepository) {
        this.telegramBot = telegramBot;
        this.keyboard = keyboard;
        this.adopterRepository = adopterRepository;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            String nameUser = update.message().chat().firstName();
            String textUpdate = update.message().text();
            Integer messageId = update.message().messageId();
            long chatId = update.message().chat().id();
            try {

                if (update.message() != null && update.message().photo() != null && update.message().caption() != null) {
                    return;
                }

                switch (textUpdate) {

// Главное меню (выбор приюта)
                    case START:
                        sendMessage(chatId, nameUser + HI);
                        keyboard.mainMenu(chatId);
                        break;
                    default:
                        sendReplyMessage(chatId, "Я не знаю такой команды", messageId);
                        break;
                }
            } catch (Exception e) {
                logger.error((e.getMessage()), e);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    public void sendReplyMessage(Long chatId, String messageText, Integer messageId) {
        SendMessage sendMessage = new SendMessage(chatId, messageText);
        sendMessage.replyToMessageId(messageId);
        telegramBot.execute(sendMessage);
    }

    public void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage(chatId, text);
        telegramBot.execute(message);
    }
}


//    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
//    CatReportService catReportService;
//    CatReportRepository catReportRepository;
////    private DefaultAbsSender HttpDownload;
//
//    @Autowired
//    public TelegramBotUpdatesListener(CatReportRepository catReportRepository, CatReportService catReportService) {
//        this.catReportRepository = catReportRepository;
//        this.catReportService = catReportService;
//    }
//
//    @Autowired
//    private TelegramBot telegramBot;
//
//    @PostConstruct
//    public void init() {
//        telegramBot.setUpdatesListener(this);
//    }
//
//    @Override
//    public int process(List<Update> updates) {
//        updates.forEach(update -> {
//            logger.info("Processing update: {}", update);
//            CatReport catReport = new CatReport();
//
//            if (update.message().photo() != null) {
//                telegramBot.execute(new SendMessage(update.message().chat().id(), "Пришлите фото"));
//            }
//            if (update.message().text() !=null) {
//                telegramBot.execute(new SendMessage(update.message().chat().id(), "Пришлите текст"));
//
//            }
//            if (update.message().photo().length > 0) {
//                System.out.println(update.toString());
//                catReport.setHabits(update.message().text());
//                catReport.setHabits(update.message().text());
//                catReport.setBehavior(update.message().text());
////                GetFileResponse fileResponse = telegramBot.execute(new GetFile(update.message().photo()[0].fileId()));
////                String fullPath = telegramBot.getFullFilePath(fileResponse.file());
////                System.out.println(fullPath);
////                try {
////                        catReportService.downloadReport();
////                        return;
////                } catch (Exception e) {
////                    logger.error((e.getMessage()), e);
//
//
////                try {
////                    catReportService.downloadReport.downloadFile(fullPath, "./images", update.message().photo()[0].fileId() + ".jpg");
////                } catch (IOException e) {
////                    System.err.println(e.getMessage());
////                    catReport.setPhoto(new File("./images/" + update.message().photo()[0].fileId() + ".jpg").getPath());
////                    CatReport.get(update.message().from().id()).addCatRepository(catReport);
////                    System.out.println(users.toString());
//
////                }
//            }
//        });
//        return UpdatesListener.CONFIRMED_UPDATES_ALL;
//    }
//}
//
//
