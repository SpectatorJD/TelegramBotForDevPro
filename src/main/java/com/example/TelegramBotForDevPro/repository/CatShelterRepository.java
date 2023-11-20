package com.example.TelegramBotForDevPro.repository;


import com.example.TelegramBotForDevPro.entity.shelter.CatShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatShelterRepository extends JpaRepository<CatShelter, Integer> {
}