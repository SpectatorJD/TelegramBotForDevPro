package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.CatReport;
import com.example.TelegramBotForDevPro.serviceBd.CatReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cat_report")
public class CatReportController {
    public CatReportService catReportService;

    @Autowired
    public CatReportController(CatReportService catReportService) {
        this.catReportService = catReportService;
    }

    //    add new cat report to the db
    @PostMapping
    public CatReport addCatReport(@RequestBody CatReport catReport) {
        return catReportService.addCatReport(catReport);
    }

    //    find cat report by id from the db
    @GetMapping("{id}")
    public ResponseEntity<CatReport> findCatReport(@PathVariable Long id) {
        CatReport catReport = catReportService.findCatReport(id);
        if (catReport == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(catReport);
    }

    //    edit cat report at the db
    @PutMapping
    public ResponseEntity<CatReport> updateCatReport(@RequestBody CatReport catReport) {
        CatReport updatedCat = catReportService.updateCatReport(catReport);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(catReport);
    }

    //    delete cat report from the db
    @DeleteMapping("{id}")
    public ResponseEntity<CatReport> deleteCatReport(@PathVariable Long id) {
        catReportService.deleteCatReport(id);
        return ResponseEntity.ok().build();
    }

    //    finds all cat reports from the db
    @GetMapping("/cat_reports")
    public ResponseEntity<Collection<CatReport>> getAllCatReports() {
        Collection<CatReport> catReports = catReportService.findAllCatReports();
        return ResponseEntity.ok(catReports);
    }
}
