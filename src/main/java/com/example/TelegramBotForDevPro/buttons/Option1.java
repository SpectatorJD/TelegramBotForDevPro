package com.example.TelegramBotForDevPro.buttons;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
@Component
public class Option1 extends TelegramLongPollingBot {
    private Logger logger = LoggerFactory.getLogger(Option1.class);

    @Override
    public String getBotUsername() {
        return "@farrytail_bot";
    }

    @Override
    public String getBotToken() {
        return "6695921384:AAH9jQ9X0boP8_qZKGVsdLK381Fn7o2kKkc";
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    public void register1() {
        SendMessage message = new SendMessage();
        message.getChatId();
        message.setText("choose, please");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();

        var catButton = new InlineKeyboardButton();
        catButton.setText("Cat");
        catButton.setCallbackData("cat_button");

        var dogButton = new InlineKeyboardButton();
        dogButton.setText("Dog");
        dogButton.setCallbackData("dog_button");

        rowInLine1.add(catButton);
        rowInLine2.add(dogButton);
        rowsInLine.add(rowInLine1);
        rowsInLine.add(rowInLine2);
        markup.setKeyboard(rowsInLine);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Error occurred: " + e.getMessage());
        }
    }


    public void register2() {
        SendMessage message = new SendMessage();
        message.getChatId();
        message.setText("choose, please");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();

        var head1Button = new InlineKeyboardButton();
        head1Button.setText("Определение запроса");
        head1Button.setCallbackData("head1_button");

        var head2Button = new InlineKeyboardButton();
        head2Button.setText("Консультация с новым пользователем");
        head2Button.setCallbackData("head2_button");

        var head3Button = new InlineKeyboardButton();
        head3Button.setText("Консультация с потенциальным хозяином животного из приюта");
        head3Button.setCallbackData("head3_button");

        var head4Button = new InlineKeyboardButton();
        head4Button.setText("Ведение питомца");
        head4Button.setCallbackData("head4_button");

        rowInLine1.add(head1Button);
        rowInLine1.add(head2Button);
        rowInLine2.add(head3Button);
        rowInLine2.add(head4Button);
        rowsInLine.add(rowInLine1);
        rowsInLine.add(rowInLine2);
        markup.setKeyboard(rowsInLine);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Error occurred: " + e.getMessage());
        }


    }
}
