package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.Objects;
@Entity(name = "volunteer")
public class Volunteer {
    public Volunteer() {
    }

    @Id
    private long id;
    private long ChatId;
    private String name;
    private String phone;
    private String userName;

    public Volunteer(long id, long chatId, String name, String phone, String userName) {
        this.id = id;
        ChatId = chatId;
        this.name = name;
        this.phone = phone;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChatId() {
        return ChatId;
    }

    public void setChatId(long chatId) {
        ChatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volunteer volunteer = (Volunteer) o;
        return id == volunteer.id && ChatId == volunteer.ChatId && Objects.equals(name, volunteer.name) && Objects.equals(phone, volunteer.phone) && Objects.equals(userName, volunteer.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ChatId, name, phone, userName);
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", ChatId=" + ChatId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}