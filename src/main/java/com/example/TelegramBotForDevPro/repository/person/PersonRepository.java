package com.example.TelegramBotForDevPro.repository.person;


import com.example.TelegramBotForDevPro.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
