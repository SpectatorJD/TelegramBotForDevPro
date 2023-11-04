package com.example.TelegramBotForDevPro.serviceBd;

import com.example.TelegramBotForDevPro.model.DogReport;
import com.example.TelegramBotForDevPro.repository.DogReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DogReportService {
    Logger logger = LoggerFactory.getLogger(DogReportService.class);
    private final DogReportRepository dogReportRepository;
    @Autowired
    public DogReportService(DogReportRepository dogReportRepository) {
        this.dogReportRepository = dogReportRepository;
    }


    //    adds new dog report to the db
    public DogReport AddDogReport(DogReport dogReport) {
        logger.debug("requesting write dog report: {}", dogReport);
        return dogReportRepository.save(dogReport);
    }

    //    finds dog report by id from the db
    public DogReport findDogReport(Long id) {
        logger.debug("requesting find dog report by id: {}", id);
        return dogReportRepository.findById(id).get();
    }


    //    edits dog report at the db
    public DogReport updateDogReport(DogReport dogReport) {
        logger.debug("requesting change dog report: {}", dogReport);
        return dogReportRepository.save(dogReport);
    }

    //    deletes dog report from the db
    public void DeleteDogReport(Long id) {
        logger.debug("requesting delete dog report by id: {}", id);
        dogReportRepository.deleteById(id);
    }
    //    finds all dog reports from the db
    public Collection<DogReport> findAllDogReport() {
        logger.debug("requesting find all dog reports ");
        return dogReportRepository.findAll();
    }
}
