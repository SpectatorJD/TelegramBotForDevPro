package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@Entity(name = "cat_adopter")
public class CatAdopter {
    public CatAdopter() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    @OneToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    public CatAdopter(long id, String name, String phone, Cat cat) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.cat = cat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatAdopter that = (CatAdopter) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(cat, that.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, cat);
    }

    @Override
    public String toString() {
        return "CatAdopter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", cat=" + cat +
                '}';
    }
}
