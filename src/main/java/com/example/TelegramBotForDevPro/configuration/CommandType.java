package com.example.TelegramBotForDevPro.configuration;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;


@Getter
@RequiredArgsConstructor
public enum CommandType {
    ABOUT("/about", "Информация о боте"),
    ADOPT("/adopt", "Как взять животное из приюта"),
    CATS("/cats", "Приют для кошек"),
    DOGS("/dogs", "Приют для собак"),
    START("/start", "Старт бота и приветствие"),
    INFO("/info", "Информация о приюте"),
    REPORT("/report", "Отчет о питомце"),
    VOLUNTEER("/volunteer", "Позвать волонтера"),
    SHELTER("/shelter", "О приюте"),
    LOCATION("/location", "Расписание работы приюта, адрес и схема проезда"),
    CONTACT("/contact", "Телефон приюта"),
    PHONE("/phone", "Оставить номер телефона для связи"),
    SECURITY("/security", "Контактные данные охраны для оформления пропуска на машину"),
    SAFETY("/safety", "Общие рекомендации о технике безопасности на территории приюта"),


    TOPIC2("/consultation", "Консультация с потенциальным хозяином животного из приюта"),

    OPTION1("/option1", "Правила знакомства с животным до того, как забрать его из приюта"),
    OPTION2("/option2", "Список документов, необходимых для того, чтобы взять животное из приюта"),
    OPTION3("/option3", "Список рекомендаций по транспортировке животного"),
    OPTION4("/option4", "Выдать список рекомендаций по транспортировке животного"),
    OPTION5_1("/option5_1", "Выдать список рекомендаций по обустройству дома для щенка"),
    OPTION5_2("/option5_2", "Выдать список рекомендаций по обустройству дома для котенка"),
    OPTION6("/option6", "Выдать список рекомендаций по обустройству дома для взрослого животного"),
    OPTION7("/option7", "Выдать список рекомендаций по обустройству дома для животного с ограниченными возможностями " +
            " (зрение, передвижение)"),
    //    неактуально для кошачьего приюта, реализовать только для приюта для собак
    OPTION8("/option8", "Выдать советы кинолога по первичному общению с собакой"),

    //    неактуально для кошачьего приюта, реализовать только для приюта для собак
    OPTION9("/option9", "Выдать рекомендации по проверенным кинологам для дальнейшего обращения к ним"),
    //    неактуально для кошачьего приюта, реализовать только для приюта для собак
    OPTION10("/option10", "Выдать список причин, почему могут отказать и не дать забрать собаку из приюта");


    private final String command;
    private final String description;


    @Nullable
    public static CommandType fromCommand(String command) {
        for (CommandType commandType : CommandType.values()) {
            if (commandType.getCommand().equals(command)) {
                return commandType;
            }
        }
        return null;
    }
}
