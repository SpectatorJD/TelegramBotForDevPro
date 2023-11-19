package com.example.TelegramBotForDevPro.configuration;


import com.example.TelegramBotForDevPro.properties.TelegramProperties;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TelegramConfiguration {

    private final TelegramProperties telegramProperties;


    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(telegramProperties.token());
        bot.execute(new DeleteMyCommands());
        return bot;
    }
}
