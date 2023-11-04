package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity(name = "cat_adopter")
public class CatAdopter {
    public CatAdopter() {
    }
    @Id
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
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
