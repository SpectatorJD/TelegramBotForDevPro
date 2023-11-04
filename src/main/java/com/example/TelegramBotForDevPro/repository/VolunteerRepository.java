package com.example.TelegramBotForDevPro.repository;

import com.example.TelegramBotForDevPro.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
