package com.example.TelegramBotForDevPro.service.report.impl;



import com.example.TelegramBotForDevPro.entity.animal.Animal;
import com.example.TelegramBotForDevPro.entity.person.Customer;
import com.example.TelegramBotForDevPro.entity.report.AnimalReport;
import com.example.TelegramBotForDevPro.repository.AnimalReportRepository;
import com.example.TelegramBotForDevPro.service.report.AnimalReportService;
import org.springframework.stereotype.Service;
import com.example.TelegramBotForDevPro.exception.ReportException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class AnimalReportServiceImpl implements AnimalReportService {

    private final AnimalReportRepository animalReportRepository;

    public AnimalReportServiceImpl(AnimalReportRepository animalReportRepository) {
        this.animalReportRepository = animalReportRepository;
    }

    @Override
    public void uploadAnimalReport(
             String photo
            , String diet
            , String wellBeing
            , String behavior
            , LocalDateTime dateCreate
            , Animal animal
            , Customer customer) {

        AnimalReport animalReport = new AnimalReport();
        animalReport.setPhoto(photo);
        animalReport.setDiet(diet);
        animalReport.setWellBeing(wellBeing);
        animalReport.setBehavior(behavior);
        animalReport.setDateCreate(dateCreate);
        animalReport.setAnimal(animal);
        animalReport.setCustomer(customer);
        this.animalReportRepository.save(animalReport);
    }

    @Override
    public AnimalReport findById(Integer id) {
        return this.animalReportRepository
                .findById(id).orElseThrow(ReportException::new);
    }

    @Override
    public AnimalReport save(AnimalReport report) {
        if (report != null) {
           this.animalReportRepository.save(report);
        }
        return report;
    }

    @Override
    public void remove(Integer id) {
        Optional<AnimalReport> byId = animalReportRepository.findById(id);
        if (byId.isPresent()) {
            this.animalReportRepository.deleteById(id);
        }
    }

    @Override
    public List<AnimalReport> getAll() {
        return this.animalReportRepository.findAll();
    }
}
