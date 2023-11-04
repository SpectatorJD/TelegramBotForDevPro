package com.example.TelegramBotForDevPro.model;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity(name = "cat")
public class Cat {
    public Cat() {
    }
@Id
    private long id;
    private String name;
    private String breed;

    public Cat(long id, String name, String breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id && Objects.equals(name, cat.name) && Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
