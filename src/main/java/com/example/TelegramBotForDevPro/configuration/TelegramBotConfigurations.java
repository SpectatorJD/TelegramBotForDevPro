package com.example.TelegramBotForDevPro.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

    @Configuration
    @Data
    @PropertySource("application.properties")
    public class TelegramBotConfigurations {

        @Value("${telegram.bot.token}")
        private String token;

        @Value("telegram.bot.name")
        private String botName;

    }

