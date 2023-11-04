package com.example.TelegramBotForDevPro.repository;

import com.example.TelegramBotForDevPro.model.DogReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogReportRepository extends JpaRepository<DogReport, Long> {
}
