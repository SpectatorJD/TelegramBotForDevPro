package com.example.TelegramBotForDevPro.service.report;



import com.example.TelegramBotForDevPro.entity.animal.Animal;
import com.example.TelegramBotForDevPro.entity.person.Customer;
import com.example.TelegramBotForDevPro.entity.report.AnimalReport;

import java.time.LocalDateTime;
import java.util.List;


public interface AnimalReportService {


    void uploadAnimalReport(
            String photo
            , String diet
            , String wellBeing
            , String behavior
            , LocalDateTime dateCreate
            , Animal animal
            , Customer customer);



    AnimalReport findById(Integer id);


    AnimalReport save(AnimalReport report);


    void remove(Integer id);


    List<AnimalReport> getAll();
}
