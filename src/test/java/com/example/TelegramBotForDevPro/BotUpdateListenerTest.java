//package com.example.TelegramBotForDevPro;
//
//import com.example.TelegramBotForDevPro.entity.shelter.AnimalShelter;
//import com.example.TelegramBotForDevPro.listener.BotUpdatesListener;
//import com.example.TelegramBotForDevPro.repository.CatShelterRepository;
//import com.example.TelegramBotForDevPro.repository.DogShelterRepository;
//import com.example.TelegramBotForDevPro.repository.person.CustomerRepository;
//import com.example.TelegramBotForDevPro.service.bot.BotCommandService;
//import com.pengrad.telegrambot.TelegramBot;
//import com.pengrad.telegrambot.model.request.ParseMode;
//import com.pengrad.telegrambot.request.SendMessage;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static com.example.TelegramBotForDevPro.configuration.CommandType.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(MockitoExtension.class)
//public class BotUpdateListenerTest {
//    private static final Long CHAT_ID = 1L;
//
//    @Autowired
//    private BotUpdatesListener listener;
//
//    @MockBean
//    private TelegramBot telegramBot;
////    @Mock
////    private CustomerRepository customerRepository;
////    @Mock
////    private BotCommandService botCommandService;
////    @Mock
////    private CatShelterRepository catShelterRepository;
////    @Mock
////    private DogShelterRepository dogShelterRepository;
////
////    private AnimalShelter animalShelter;
//
//    @Test
//    public void catConsultationCommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(CAT_CONSULTATION));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertNotNull(sendMessage.getParameters().get("reply_markup"));
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Выберите что вас интересует",
//                CAT_CONSULTATION,
//                sendMessage.getParameters().get("text"));
//    }
// @Test
//    public void DogConsultationCommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(DOG_CONSULTATION));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertNotNull(sendMessage.getParameters().get("reply_markup"));
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Выберите что вас интересует",
//                DOG_CONSULTATION,
//                sendMessage.getParameters().get("text"));
//    }
// @Test
//    public void Option1CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION1));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Правила знакомства с животным до того, как забрать его из приюта",
//                OPTION1,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option2CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION2));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Список документов, необходимых для того, чтобы взять животное из приюта",
//                OPTION2,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option3CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION3));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Список документов, необходимых для того, чтобы взять животное из приюта.",
//                OPTION3,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option4CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION4));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Список рекомендаций по транспортировке животного",
//                OPTION4,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option5_1CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION5_1));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Список рекомендаций по обустройству дома для щенка",
//                OPTION5_1,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option5_2CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION5_2));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Список рекомендаций по обустройству дома для котенка",
//                OPTION5_2,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option6CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION6));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Список рекомендаций по обустройству дома для взрослого животного",
//                OPTION6,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option7CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION7));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Список рекомендаций по обустройству дома для животного с ограниченными возможностями " +
//              //  " (зрение, передвижение)",
//                OPTION7,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option8CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION8));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Советы кинолога по первичному общению с собакой",
//                OPTION8,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option9CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION9));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Рекомендации по проверенным кинологам для дальнейшего обращения к ним",
//                OPTION9,
//                sendMessage.getParameters().get("text"));
//    }
//    @Test
//    public void Option10CommandTest() {
//        var update = BotTestUtils.getUpdate(CHAT_ID, String.valueOf(OPTION10));
//        var sendMessage = BotTestUtils.getSendMessage(telegramBot, listener, update);
//        assertNotNull(sendMessage);
//        assertEquals(CHAT_ID, (Long) sendMessage.getParameters().get("chat_id"));
//        assertEquals(//"Список причин, почему могут отказать и не дать забрать собаку из приюта",
//                OPTION10,
//                sendMessage.getParameters().get("text"));
//    }
//}
