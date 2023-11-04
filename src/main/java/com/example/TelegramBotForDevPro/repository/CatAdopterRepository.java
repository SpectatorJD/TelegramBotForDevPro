package com.example.TelegramBotForDevPro.repository;

import com.example.TelegramBotForDevPro.model.CatAdopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatAdopterRepository extends JpaRepository<CatAdopter, Long> {
}
