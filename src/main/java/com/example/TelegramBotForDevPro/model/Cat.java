package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "cat")
public class Cat {
    public Cat() {
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

    public Cat(long id, String name, String breed, String color) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id && Objects.equals(name, cat.name) && Objects.equals(breed, cat.breed) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed, color);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
