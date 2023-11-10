package com.example.TelegramBotForDevPro.repository;

import com.example.TelegramBotForDevPro.model.DogAdopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogAdopterRepository extends JpaRepository<DogAdopter, Long> {
    DogAdopter findByChatId(Long chatId);
}
