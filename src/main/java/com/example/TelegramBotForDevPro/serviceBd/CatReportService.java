package com.example.TelegramBotForDevPro.serviceBd;

import com.example.TelegramBotForDevPro.model.CatReport;
import com.example.TelegramBotForDevPro.repository.CatReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CatReportService {
    Logger logger = LoggerFactory.getLogger(CatReportService.class);
    private final CatReportRepository catReportRepository;
    @Autowired
    public CatReportService(CatReportRepository catReportRepository) {
        this.catReportRepository = catReportRepository;
    }


    //    adds new cat report to the db
    public CatReport addCatReport(CatReport catReport) {
        logger.debug("requesting write cat report: {}", catReport);
        return catReportRepository.save(catReport);
    }

    //    finds cat report by id from the db
    public CatReport findCatReport(Long id) {
        logger.debug("requesting find cat report by id: {}", id);
        return catReportRepository.findById(id).get();
    }


    //    edits cat report at the db
    public CatReport updateCatReport(CatReport catReport) {
        logger.debug("requesting change cat report: {}", catReport);
        return catReportRepository.save(catReport);
    }

    //    deletes cat report from the db
    public void deleteCatReport(Long id) {
        logger.debug("requesting delete cat report by id: {}", id);
        catReportRepository.deleteById(id);
    }
    //    finds all cat reports  from the db
    public Collection<CatReport> findAllCatReports() {
        logger.debug("requesting find all cat reports");
        return catReportRepository.findAll();
    }
}

