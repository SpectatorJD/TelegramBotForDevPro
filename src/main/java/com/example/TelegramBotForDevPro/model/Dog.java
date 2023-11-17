package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@Entity
@Table(name = "dog")
public class Dog {
        public Dog() {
        }
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;
        @Column(name = "name")
        private String name;
        @Column(name = "breed")
        private String breed;
        @Column(name = "color")
        private String color;

        public Dog(long id, String name, String breed, String color) {
            this.id = id;
            this.name = name;
            this.breed = breed;
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

