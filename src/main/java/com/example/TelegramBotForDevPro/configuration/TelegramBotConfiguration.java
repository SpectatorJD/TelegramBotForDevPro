package com.example.TelegramBotForDevPro.configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.generics.TelegramBot;
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
    private final TelegramBot telegramBot;
    @Autowired
    public TelegramBotConfiguration(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }
    @EventListener({ContextRefreshedEvent.class})
    public void init()throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try{
            telegramBotsApi.registerBot((LongPollingBot) telegramBot);
        } catch (TelegramApiException e){
            System.out.println("При иницилизация бота возникла ошибка: " + e);
    }
    }
}
