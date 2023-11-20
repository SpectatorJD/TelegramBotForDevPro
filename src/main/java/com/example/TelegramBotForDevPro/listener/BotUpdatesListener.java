package com.example.TelegramBotForDevPro.listener;


import com.example.TelegramBotForDevPro.configuration.CommandType;
import com.example.TelegramBotForDevPro.entity.person.Customer;
import com.example.TelegramBotForDevPro.entity.shelter.AnimalShelter;
import com.example.TelegramBotForDevPro.repository.CatShelterRepository;
import com.example.TelegramBotForDevPro.repository.DogShelterRepository;
import com.example.TelegramBotForDevPro.repository.person.CustomerRepository;
import com.example.TelegramBotForDevPro.service.bot.BotCommandService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.example.TelegramBotForDevPro.configuration.CommandType.PHONE;
import static com.example.TelegramBotForDevPro.service.bot.impl.BotCommandServiceImpl.PHONE_AGAIN;
import static com.example.TelegramBotForDevPro.service.bot.impl.BotCommandServiceImpl.VOLUNTEER_MESSAGE;



@Service
@RequiredArgsConstructor
public class BotUpdatesListener implements UpdatesListener {
    private final Logger logger = LoggerFactory.getLogger(BotUpdatesListener.class);

    private final TelegramBot telegramBot;
    private final CustomerRepository customerRepository;
    private final BotCommandService botCommandService;

    private final CatShelterRepository catShelterRepository;

    private final DogShelterRepository dogShelterRepository;

    private AnimalShelter animalShelter;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }


    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Обработка обновления: {}", update);
            if (update.callbackQuery() != null) {
                handleCallback(update.callbackQuery());
            }
            if (update.message() != null) {
                handleMessage(update.message());
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }


    private void handleCallback(CallbackQuery callbackQuery) {
        String callbackQueryData = callbackQuery.data();
        Long chatId = callbackQuery.from().id();
        Customer customer = customerRepository.findByChatId(chatId).orElseThrow();

        CommandType commandType = CommandType.valueOf(callbackQueryData);
        try {
            switch (commandType) {
                case CATS -> {
                    animalShelter = catShelterRepository.findById(2).orElse(null);
                    botCommandService.runCats(chatId, animalShelter);
                }
                case DOGS -> {
                    animalShelter = dogShelterRepository.findById(1).orElse(null);
                    botCommandService.runDogs(chatId, animalShelter);
                }
                case ADOPT -> botCommandService.runAdopt(chatId, animalShelter);
                case INFO -> botCommandService.runInfo(chatId, animalShelter);
                case CONTACT -> botCommandService.runContact(chatId, animalShelter);
                case PHONE -> botCommandService.runTelephone(chatId);
                case LOCATION -> botCommandService.runLocation(chatId, animalShelter);
                case SHELTER -> botCommandService.runShelter(chatId, animalShelter);
                case SECURITY -> botCommandService.runSecurity(chatId, animalShelter);
                case SAFETY -> botCommandService.runSafety(chatId, animalShelter);
                case VOLUNTEER -> {
                    if (customer.getPhone() != null) {
                        botCommandService.runVolunteer(chatId);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Прежде чем позвать волонтера - укажите ваш номер телефона!");
                        telegramBot.execute(sendMessage);
                    }
                }
                case REPORT -> botCommandService.runReport(chatId);

            }
        } catch (Exception e) {
            logger.error("Ошибка обработки обратного вызова: {}", e.getMessage());
        }
    }


    private void handleMessage(Message message) {

        boolean isNewCustomer = false; // Флаг нового пользователя
        try {
            Long chatId = message.from().id();
            Customer customer;

            // Ищем пользователя в базе, если нет - сохраняем
            if (customerRepository.existsByChatId(chatId)) {
                customer = customerRepository.findByChatId(chatId).orElseThrow();
            } else {
                isNewCustomer = true;
                customer = customerRepository.save(
                        new Customer(message.from().firstName(), message.from().lastName(), chatId)
                );
            }

            // Если сообщение пришло в ответ на сообщение бота, то обрабатываем в другом методе
            if (message.replyToMessage() != null) {
                handleReplyToMessage(message);
                return;
            }

            // Ловим сообщения с фото
            if (message.photo() != null && message.caption() != null) {
                botCommandService.saveReport(message);
                return;
            }

            // Если это отдельное сообщение, то сверяем со списком команд из CommandType и запускаем выполнение при совпадении
            String command = message.text();
            CommandType commandType = CommandType.fromCommand(command);
            if (commandType == null) {
                botCommandService.sendMessage(chatId, String.format("Команда *%s* не найдена", command));
            } else {
                switch (commandType) {
                    case ABOUT -> botCommandService.runAbout(customer);
                    case ADOPT -> botCommandService.runAdopt(chatId, animalShelter);
                    case CATS -> {
                        animalShelter = catShelterRepository.findById(2).orElse(null);
                        botCommandService.runCats(chatId, animalShelter);
                    }
                    case DOGS -> {
                        animalShelter = dogShelterRepository.getReferenceById(1);
                        botCommandService.runDogs(chatId, animalShelter);
                    }
                    case START -> {
                        if (isNewCustomer) {
                            botCommandService.runAbout(customer);
                        }
                        botCommandService.runStart(chatId);
                    }
                    case INFO -> botCommandService.runInfo(chatId, animalShelter);
                    case REPORT -> botCommandService.runReport(chatId);
                    case VOLUNTEER -> botCommandService.runVolunteer(chatId);
                    case CONTACT -> botCommandService.runContact(chatId, animalShelter);
                    case LOCATION -> botCommandService.runLocation(chatId, animalShelter);
                    case SHELTER -> botCommandService.runShelter(chatId, animalShelter);
                    case SECURITY -> botCommandService.runSecurity(chatId, animalShelter);
                    case SAFETY -> botCommandService.runSafety(chatId, animalShelter);
                }
            }
        } catch (Exception e) {
            logger.error("Ошибка при обработке сообщения: {}", e.getMessage());
        }
    }

    private void handleReplyToMessage(Message message) {
        if (message.replyToMessage().text().equals(PHONE) || message.replyToMessage().text().equals(PHONE_AGAIN)) {
            // Если сообщение пришло в ответ на кнопку "Телефон"
            botCommandService.saveTelephone(message.chat().id(), message.text());
        } else if (message.replyToMessage().text().equals(VOLUNTEER_MESSAGE)) {
            // Если сообщение пришло в ответ на кнопку "Позвать волонтера" с любым текстом
            botCommandService.sendMessageToVolunteer(message.chat().id(), message.text());
            SendMessage sendMessage = new SendMessage(message.chat().id(), "Волонтер скоро свяжется с Вами!");
            telegramBot.execute(sendMessage);
        }
    }
}