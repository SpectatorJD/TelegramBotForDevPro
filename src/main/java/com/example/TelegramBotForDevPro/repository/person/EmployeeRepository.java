package com.example.TelegramBotForDevPro.repository.person;


import com.example.TelegramBotForDevPro.entity.person.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
