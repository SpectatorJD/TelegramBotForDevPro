package com.example.TelegramBotForDevPro.configuration;


import com.example.TelegramBotForDevPro.service.AnimalShelterForDogs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
//import org.telegram.telegrambots.meta.api.methods.commands.DeleteMyCommands;
//import org.telegram.telegrambots.meta.generics.TelegramBot;

@PropertySource("application.properties")
@Configuration
public class TelegramBotConfiguration {

    @Value("${telegram.bot.token}")
    private String token;

    //    @Bean
//    public TelegramBot telegramBot() {
//        TelegramBot bot = new TelegramBot() {
//            @Override
//            public String getBotUsername() {
//                return "@farrytail_bot";
//            }
//
//            @Override
//            public String getBotToken() {
//                return "6695921384:AAH9jQ9X0boP8_qZKGVsdLK381Fn7o2kKkc";
//            }
//
//        };
//        return bot;
//    }
//    @Bean
//    public TelegramBot telegramBot() {
//        TelegramBot bot = new TelegramBot (token);
//        bot.execute(new DeleteMyCommands());
//        return bot;
//    }
    @Bean
    public static void telegramBots() {
     try {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//        botsApi.registerBot(new AnimalShelterForCats());
        botsApi.registerBot(new AnimalShelterForDogs());
    } catch (TelegramApiException e) {
        e.printStackTrace();
    }
    }
}
