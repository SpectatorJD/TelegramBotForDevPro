package com.example.TelegramBotForDevPro.repository;


import com.example.TelegramBotForDevPro.entity.animal.Animal;
import com.example.TelegramBotForDevPro.entity.report.AnimalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface AnimalReportRepository extends JpaRepository<AnimalReport, Integer> {


    @Transactional
    AnimalReport findFirstByAnimalOrderByDateCreateDesc(Animal animal);
}
