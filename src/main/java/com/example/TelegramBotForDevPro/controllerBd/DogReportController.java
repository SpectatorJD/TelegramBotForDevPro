package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.DogReport;
import com.example.TelegramBotForDevPro.serviceBd.DogReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dog_report")
public class DogReportController {
    public DogReportService dogReportService;

    @Autowired
    public DogReportController(DogReportService dogReportService) {
        this.dogReportService = dogReportService;
    }

    //    add new Dog report to the db
    @PostMapping
    public DogReport addDogReport(@RequestBody DogReport DogReport) {
        return dogReportService.addDogReport(DogReport);
    }

    //    find dog report by id from the db
    @GetMapping("{id}")
    public ResponseEntity<DogReport> findDogReport(@PathVariable Long id) {
        DogReport DogReport = dogReportService.findDogReport(id);
        if (DogReport == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(DogReport);
    }

    //    edit dog report at the db
    @PutMapping
    public ResponseEntity<DogReport> updateDogReport(@RequestBody DogReport DogReport) {
        DogReport updatedCat = dogReportService.updateDogReport(DogReport);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(DogReport);
    }

    //    delete dog report from the db
    @DeleteMapping("{id}")
    public ResponseEntity<DogReport> deleteDogReport(@PathVariable Long id) {
        dogReportService.deleteDogReport(id);
        return ResponseEntity.ok().build();
    }

    //    finds all dog reports from the db
    @GetMapping("/dog_reports")
    public ResponseEntity<Collection<DogReport>> getAllDogReports() {
        Collection<DogReport> dogReports = dogReportService.findAllDogReports();
        return ResponseEntity.ok(dogReports);
    }
}

