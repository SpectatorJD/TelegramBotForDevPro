package com.example.TelegramBotForDevPro.repository;


import com.example.TelegramBotForDevPro.entity.shelter.DogShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DogShelterRepository extends JpaRepository<DogShelter, Integer> {
}