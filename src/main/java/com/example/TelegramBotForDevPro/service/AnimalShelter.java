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

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            extraProcess(updates);
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
    public List<AnimalShelter>notifications(LocalDateTime time) {
        List<AnimalShelter> animalShelterList = animalShelterRepository.findAll();
        animalShelterRepository.findAll().forEach(times->{
            if (time.equals(times)) {
                animalShelterList.add(times);
            }
        });
        return animalShelterList;
    }
    @Scheduled(cron = "0 0/1 * * * *")
    public void scheduleNotification() {
        List<AnimalShelter>animalShelterList=this.notifications(LocalDateTime.now()
                .truncatedTo(ChronoUnit.MINUTES));
        this.scheduleNotificationMassage(animalShelterList);
    }
    public void scheduleNotificationMassage(List<AnimalShelter>animalShelterList){
        animalShelterList.forEach(animalShelter -> {
            SendMessage sendMessage = new SendMessage(AnimalShelter.this.animalShelter.getId(),
                    AnimalShelter.this.animalShelter.getInfo());
            telegramBot.execute(sendMessage);
        });
    }

    public int extraProcess(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            Pattern pattern = Pattern.compile("([\\d.:\\s]{16})\\s+(.+)");
            Matcher matcher = pattern.matcher(update.message().text());
            if (matcher.matches()) {
                String time = matcher.group(1);
                LocalDateTime times = LocalDateTime.parse(time,
                        DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
                String notes = matcher.group(2);
                AnimalShelter animalShelter = new AnimalShelter(update
                        .message()
                        .chat().id(), notes, times);

                animalShelterRepository.save(animalShelter);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
}