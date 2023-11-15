package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;



    @Entity(name = "adopter")
    public class Adopter {
        /**
         * Поле: идентификационный номер пользователя
         */
        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        /**
         * Поле: номер чата пользователя
         */
        @Column(name = "chat_id", nullable = false)
        private Long chatId;

        /**
         * Поле: имя пользователя
         */
        @Column(name = "name", nullable = false)
        private String name;

        /**
         * Поле: выбор приюта
         */
        @Column(name = "is_dog", nullable = false)
        private boolean isDog = true;


        /**
         * Конструктор
         *
         * @param chatId номер чата пользователя
         * @param name   имя пользователя
         * @param isDog  поле выбора приюта
         */
        public Adopter(Long chatId, String name, boolean isDog) {
            this.chatId = chatId;
            this.name = name;
            this.isDog = isDog;
        }

        /**
         * Конструктор без параметров для создания объекта "пользователь"
         */
        public Adopter() {

        }

        /**
         * Если пользователь выбирает собачий приют, возвращается true, иначе false
         *
         * @return boolean значение выбора приюта
         */
        public boolean isDog() {
            return isDog;
        }

        public void setIsDog(boolean dog) {
            isDog = dog;
        }

        public Long getChatId() {
            return chatId;
        }

        public void setChatId(Long chatId) {
            this.chatId = chatId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Adopter adopter = (Adopter) o;
            return isDog == adopter.isDog && Objects.equals(chatId, adopter.chatId) && Objects.equals(name, adopter.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(chatId, name, isDog);
        }

        @Override
        public String toString() {
            return "User{" +
                    "chatId=" + chatId +
                    ", name='" + name + '\'' +
                    ", isDog=" + isDog +
                    '}';
        }
}
}
