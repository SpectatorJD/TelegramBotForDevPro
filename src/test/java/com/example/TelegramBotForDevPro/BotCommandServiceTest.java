//package com.example.TelegramBotForDevPro;
//
//import com.example.TelegramBotForDevPro.properties.TelegramProperties;
//import com.example.TelegramBotForDevPro.repository.person.CustomerRepository;
//import com.example.TelegramBotForDevPro.service.bot.BotCommandService;
//import com.pengrad.telegrambot.TelegramBot;
//import com.pengrad.telegrambot.UpdatesListener;
//import com.pengrad.telegrambot.model.Chat;
//import com.pengrad.telegrambot.model.Message;
//import com.pengrad.telegrambot.model.Update;
//import com.pengrad.telegrambot.request.SendMessage;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class BotCommandServiceTest {
//   @Mock
//    private TelegramProperties telegramProperties;
//   @Mock
//    private  CustomerRepository customerRepository;
//    @InjectMocks
//    BotCommandService botCommandService;
//    public static Update getUpdate(Long chatId, String command) {
//        Update update = mock(Update.class);
//        Chat chat = mock(Chat.class);
//        Message message = mock(Message.class);
//        when(chat.id()).thenReturn(chatId);
//        when(message.text()).thenReturn(command);
//        when(message.chat()).thenReturn(chat);
//        when(update.message()).thenReturn(message);
//        return update;
//    }
//
//    public static SendMessage getSendMessage(TelegramBot bot, UpdatesListener listener, Update update) {
//        var requestCaptor = ArgumentCaptor.forClass(SendMessage.class);
//        when(bot.execute(requestCaptor.capture())).thenReturn(null);
//        listener.process(List.of(update));
//        return requestCaptor.getValue();
//    }
//}
