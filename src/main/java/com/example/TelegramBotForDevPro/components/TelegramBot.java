package com.example.TelegramBotForDevPro.components;

import com.example.TelegramBotForDevPro.configuration.TelegramBotConfiguration;
import com.example.TelegramBotForDevPro.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private final NotificationService notificationService;

    private final TelegramBotConfiguration telegramBotConfiguration;

    final static String taskInfoTest = "Чтобы создать напоминания  введите дату и время в формате: ДД.ММ.ГГГГ ЧЧ:ММ текст задачи." + "\n"
            + "Пример напоминания: 01.01.2022 20:00 Сделать домашнюю работу!";



    public String getBotUsername() {
        return telegramBotConfiguration.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramBotConfiguration.getToken();
    }

    private void startCommandReceived(Long chatId, String name) {
        String answer = "Привет, " + name + ", приятно познакомиться!" + "\n"
                + "Я напоминаю вам о ваших делах." + "\n " + taskInfoTest;
        sendMessage(chatId, answer);
    }
    public void sendMessage(Long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Возникла ошибка при отправке сообщения: " + e.getMessage());
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        String currency = "";
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;

                default:
                    try {
                        notificationService.createNewTask(messageText, chatId);
                        sendMessage(chatId, "Напоминание успешно создано");
                    } catch (ParseException e) {
                        sendMessage(chatId, taskInfoTest);
                    } catch (RuntimeException e) {
                        System.out.println(e);
                        sendMessage(chatId, "Не удалось создать напоминание");
                    }
            }
        }


    }
}
