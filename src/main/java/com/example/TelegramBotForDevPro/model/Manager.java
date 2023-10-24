package com.example.TelegramBotForDevPro.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "manager")
public class Manager {
    public Manager() {
    }

    @Id
    private long id;
    private String firstText;
    private String secondText;


    public Manager(long id, String firstText, String secondText) {
        this.id = id;
        this.firstText = firstText;
        this.secondText= secondText;
    }

    public long getId() {
        return id;
    }

    public String getFirstText() {
        return firstText;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstText(String firstText) {
        this.firstText = firstText;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstText='" + firstText + '\'' +
                ", secondText='" + secondText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id && Objects.equals(firstText, manager.firstText) && Objects.equals(secondText, manager.secondText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstText, secondText);
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }

}
