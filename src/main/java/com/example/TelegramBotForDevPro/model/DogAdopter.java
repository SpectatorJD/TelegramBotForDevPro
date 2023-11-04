package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity(name = "dog_adopter")
public class DogAdopter {
    public DogAdopter() {
    }
    @Id
    private long id;
    private String name;
    private String phone;
    @OneToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    public DogAdopter(long id, String name, String phone, Dog dog) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dog = dog;
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

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogAdopter that = (DogAdopter) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(dog, that.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, dog);
    }

    @Override
    public String toString() {
        return "DogAdopter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dog=" + dog +
                '}';
    }
}
