package com.example.TelegramBotForDevPro.repository;

import com.example.TelegramBotForDevPro.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalShelterRepository extends JpaRepository<Manager, Long> {
}
