package com.example.TelegramBotForDevPro.repository;

import com.example.TelegramBotForDevPro.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {

}
