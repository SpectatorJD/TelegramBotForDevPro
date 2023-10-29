package com.example.TelegramBotForDevPro.configuration;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")
public class TelegramBotConfiguration {
    @Value("${telegram.bot.token}")
    private String token;
    @Value("My_course_work_by_skypro_bot")
    private String botName;

}
