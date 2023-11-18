package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "dog_adopter")
public class DogAdopter {
    public DogAdopter() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name") //, nullable = false)
    private String name;
    @Column(name = "phone") //, nullable = false)
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
