package com.example.TelegramBotForDevPro.components;

import com.example.TelegramBotForDevPro.configuration.TelegramBotConfiguration;
import com.example.TelegramBotForDevPro.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;


@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private final NotificationService notificationService;

    private final TelegramBotConfiguration telegramBotConfiguration;

    final static String taskInfoTest = " выбери о каком приюте хочешь узнать ";



    public String getBotUsername() {
        return telegramBotConfiguration.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramBotConfiguration.getToken();
    }

    private void startCommandReceived(Long chatId, String name) {
        String answer = "Привет, " + name + ", приятно познакомиться!" + "\n"
                + "Я рассказываю о приютах с кошками и собаками " + "\n " + taskInfoTest;
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

    /*@Override
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
    }*/
    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update){
        if (update.hasMessage()){
            handleMessage(update.getMessage());
        }
    }
    @SneakyThrows
    private void handleMessage(Message message){
        if(message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity =
                    message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (commandEntity.isPresent())  {
                String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                switch (command)    {
                    case "/set_cats":
                        execute(SendMessage.builder()
                                .text("пожалуйста выберите животное")
                                .chatId(message.getChatId().toString())
                                .build());
                        return;
                }
            }

        }

    }

}
