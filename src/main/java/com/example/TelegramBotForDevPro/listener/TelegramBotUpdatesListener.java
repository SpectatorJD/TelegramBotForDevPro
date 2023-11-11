package com.example.TelegramBotForDevPro.listener;

import com.example.TelegramBotForDevPro.model.CatReport;
import com.example.TelegramBotForDevPro.repository.CatReportRepository;
import com.example.TelegramBotForDevPro.serviceBd.CatReportService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetFileResponse;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.telegram.telegrambots.bots.DefaultAbsSender;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelegramBotUpdatesListener implements UpdatesListener {
    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
    CatReportService catReportService;
    CatReportRepository catReportRepository;
//    private DefaultAbsSender HttpDownload;

    @Autowired
    public TelegramBotUpdatesListener(CatReportRepository catReportRepository, CatReportService catReportService) {
        this.catReportRepository = catReportRepository;
        this.catReportService = catReportService;
    }

    @Autowired
    private TelegramBot telegramBot;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            CatReport catReport = new CatReport();

            if (update.message().photo() != null) {
                telegramBot.execute(new SendMessage(update.message().chat().id(), "Пришлите фото"));
            }
            if (update.message().text() !=null) {
                telegramBot.execute(new SendMessage(update.message().chat().id(), "Пришлите текст"));

            }
            if (update.message().photo().length > 0) {
                System.out.println(update.toString());
                catReport.setHabits(update.message().text());
                catReport.setHabits(update.message().text());
                catReport.setBehavior(update.message().text());
//                GetFileResponse fileResponse = telegramBot.execute(new GetFile(update.message().photo()[0].fileId()));
//                String fullPath = telegramBot.getFullFilePath(fileResponse.file());
//                System.out.println(fullPath);
//                try {
//                        catReportService.downloadReport();
//                        return;
//                } catch (Exception e) {
//                    logger.error((e.getMessage()), e);


//                try {
//                    catReportService.downloadReport.downloadFile(fullPath, "./images", update.message().photo()[0].fileId() + ".jpg");
//                } catch (IOException e) {
//                    System.err.println(e.getMessage());
//                    catReport.setPhoto(new File("./images/" + update.message().photo()[0].fileId() + ".jpg").getPath());
//                    CatReport.get(update.message().from().id()).addCatRepository(catReport);
//                    System.out.println(users.toString());

//                }
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}


