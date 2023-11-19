package com.example.TelegramBotForDevPro.repository.person;


import com.example.TelegramBotForDevPro.entity.person.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    Boolean existsByChatId(Long chatId);


    Optional<Customer> findByChatId(Long chatId);
}
