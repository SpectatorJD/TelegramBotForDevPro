package com.example.TelegramBotForDevPro.repository;

import com.example.TelegramBotForDevPro.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
