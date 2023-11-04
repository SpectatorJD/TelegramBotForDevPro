package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity(name = "dog")
public class Dog {
        public Dog() {
        }
        @Id
        private long id;
        private String name;
        private String breed;
        private String color;

        public Dog(long id, String name, String breed, String color) {
            this.id = id;
            this.name = name;
            this.breed = breed;
            this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id && Objects.equals(name, dog.name) && Objects.equals(breed, dog.breed) && Objects.equals(color, dog.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed, color);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

