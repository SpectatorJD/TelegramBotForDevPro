package com.example.TelegramBotForDevPro.configuration;


import com.example.TelegramBotForDevPro.properties.TelegramProperties;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@Data
@PropertySource("application.properties")
public class TelegramConfiguration {
    @Value("${telegram.bot.token}")
    private String token;
    @Value("My_course_work_by_skypro_bot")
    private String botName;

}

/*
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
}*/
