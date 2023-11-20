package com.example.TelegramBotForDevPro.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableScheduling
@ComponentScan("com.example.TelegramBotForDevPro")
@EntityScan("com.example.TelegramBotForDevPro.entity")
@ConfigurationPropertiesScan("com.example.TelegramBotForDevPro.properties")
public class AppConfiguration {
}