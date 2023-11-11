package com.example.TelegramBotForDevPro.serviceBd;

import com.example.TelegramBotForDevPro.model.CatReport;
import com.example.TelegramBotForDevPro.repository.CatReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collection;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

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
//    public CatReport downloadReport() {
//        logger.info("Method downloadReport has been run");
//
//        CatReport reportCat = new CatReport();
//        reportCat.setId(id);
//        reportCat.setRation(ration);
//        reportCat.setBehavior(behavior);
//        reportCat.setHabits(habits);
//        reportCat.setLastMessage(lastMessage);
//        reportCat.setPhoto(photo);
//
//        return catReportRepository.save(reportCat);
//    }
//    public void uploadAvatar(Long studentID, MultipartFile file) throws IOException {
//        logger.debug("requesting upload avatar by studentId: {}, and file: {}", studentID, file);
//        CatReport client = findCatReport(cat);
//        Path filePath = Path.of("./avatar", studentID + "." + getExtension(file.getOriginalFilename()));
//        Files.createDirectories(filePath.getParent());
//        Files.deleteIfExists(filePath);
//        try (InputStream is = file.getInputStream();
//             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
//             BufferedInputStream bis = new BufferedInputStream(is, 1024);
//             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
//        ) {
//            bis.transferTo(bos);
//        }
//        CatReport catReport = catReportRepository.findById(id).orElseGet(CatReport::new);
//        catReport.setId(id);
//        catReport.setRation(ration);
//        catReport.setBehavior(behavior);
//        catReport.setHabits(habits);
//        catReport.setLastMessage(lastMessage);
//        catReport.setPhoto(photo);
//        catReportRepository.save(catReport);
//    }
//    private String getExtension(String fileName) {
//        logger.debug("requesting extension file name: {}", fileName);
//        return fileName.substring(fileName.lastIndexOf(".") + 1);
//    }
//
}
