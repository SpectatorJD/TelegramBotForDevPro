package com.example.TelegramBotForDevPro.listener;


import com.example.TelegramBotForDevPro.service.bot.BotMenuService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SetMyCommands;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ApplicationReadyListener {

    private final TelegramBot telegramBot;
    private final BotMenuService menuService;


    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        System.out.println("Добрый день");
        telegramBot.execute(new SetMyCommands(menuService.createMainMenuCommands()));
    }
}
