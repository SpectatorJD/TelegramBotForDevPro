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

        public Dog(long id, String name, String breed) {
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
            com.example.TelegramBotForDevPro.model.Dog cat = (com.example.TelegramBotForDevPro.model.Dog) o;
            return id == cat.id && Objects.equals(name, cat.name) && Objects.equals(breed, cat.breed);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, breed);
        }

        @Override
        public String toString() {
            return "dog{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", breed='" + breed + '\'' +
                    '}';
        }
    }

