package com.example.TelegramBotForDevPro.repository;

import com.example.TelegramBotForDevPro.model.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdopterRepository extends JpaRepository<Adopter, Long>{
    Adopter findAdopterByChatId(Long chatId);
}
