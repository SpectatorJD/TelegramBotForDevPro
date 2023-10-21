package com.example.TelegramBotForDevPro.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "manager")
public class Manager {
    @Id
    private long id;
    private String info;

    public Manager(long id, String info) {
        this.id = id;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id && Objects.equals(info, manager.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
