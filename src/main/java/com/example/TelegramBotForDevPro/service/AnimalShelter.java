package com.example.TelegramBotForDevPro.service;

import com.example.TelegramBotForDevPro.repository.AnimalShelterRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class AnimalShelter implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(AnimalShelter.class);
    AnimalShelterRepository animalShelterRepository;

    @Autowired

    public AnimalShelter(AnimalShelterRepository animalShelterRepository) {
        this.animalShelterRepository = animalShelterRepository;
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
            if (update.message().text().equals("/start")) {
                SendMessage message = new SendMessage(update.message().chat().id(), "Hi");
                telegramBot.execute(message);
            }

        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
