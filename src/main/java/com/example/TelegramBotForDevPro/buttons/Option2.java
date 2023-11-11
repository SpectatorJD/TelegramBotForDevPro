package com.example.TelegramBotForDevPro.buttons;

;
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
public class Option2 extends TelegramLongPollingBot {
    private Logger logger = LoggerFactory.getLogger(Option2.class);

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

    public void register3(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));;
        message.setText("choose, please");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var query1Button = new InlineKeyboardButton();
        query1Button.setText("Правила знакомства с животным до того, как забрать его из приюта");
        query1Button.setCallbackData("query1_button");

        var query2Button = new InlineKeyboardButton();
        query2Button.setText("Список документов, необходимых для того, чтобы взять животное из приюта");
        query2Button.setCallbackData("query2_button");

        var query3Button = new InlineKeyboardButton();
        query3Button.setText("Список рекомендаций по транспортировке животного");
        query3Button.setCallbackData("query3_button");

        var query4Button = new InlineKeyboardButton();
        query4Button.setText("Выдать список рекомендаций по транспортировке животного");
        query4Button.setCallbackData("query4_button");

        var query5_1Button = new InlineKeyboardButton();
        query5_1Button.setText("Выдать список рекомендаций по обустройству дома для щенка");
        query5_1Button.setCallbackData("query5_button");

        var query5_2Button = new InlineKeyboardButton();
        query5_2Button.setText("Выдать список рекомендаций по обустройству дома для котенка");
        query5_2Button.setCallbackData("query5_2_button");

        var query6Button = new InlineKeyboardButton();
        query6Button.setText("Выдать список рекомендаций по обустройству дома для взрослого животного");
        query6Button.setCallbackData("query6_button");

        var query7Button = new InlineKeyboardButton();
        query7Button.setText("Выдать список рекомендаций по обустройству дома для животного с ограниченными возможностями " +
                             "(зрение, передвижение)");
        query7Button.setCallbackData("query7_button");

        var query8Button = new InlineKeyboardButton();
        query8Button.setText("Выдать рекомендации по проверенным кинологам для дальнейшего обращения к ним");
//        неактуально для кошачьего приюта, реализовать только для приюта для собак
        query8Button.setCallbackData("query8_button");

        var query9Button = new InlineKeyboardButton();
        query9Button.setText("Бот может выдать рекомендации по проверенным кинологам для дальнейшего обращения к ним");
//        неактуально для кошачьего приюта, реализовать только для приюта для собак
        query9Button.setCallbackData("query9_button");

        var query10Button = new InlineKeyboardButton();
        query10Button.setText("Бот может выдать список причин, почему могут отказать и не дать забрать собаку из приюта");
        query10Button.setCallbackData("query10_button");

        var query11Button = new InlineKeyboardButton();
        query11Button.setText("Бот может принять и записать контактные данные для связи");
        query11Button.setCallbackData("query11_button");

        rowInLine.add(query1Button);
        rowInLine.add(query2Button);
        rowInLine.add(query3Button);
        rowInLine.add(query4Button);
        rowInLine.add(query5_1Button);
        rowInLine.add(query5_2Button);
        rowInLine.add(query6Button);
        rowInLine.add(query7Button);
        rowInLine.add(query8Button);
        rowInLine.add(query9Button);
        rowInLine.add(query10Button);
        rowInLine.add(query11Button);
        rowsInLine.add(rowInLine);
        markup.setKeyboard(rowsInLine);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Error occurred: " + e.getMessage());
        }
    }
}
