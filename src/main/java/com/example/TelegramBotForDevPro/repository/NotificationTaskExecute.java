package com.example.TelegramBotForDevPro.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "notification_task")
@Getter
@Setter
public class NotificationTaskExecute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "chat_id")
    Long chatId;

    @Column(name = "notification")
    String notification;

    @Column(name = "date_send_notification")
    Timestamp dateSendNotification;
}
