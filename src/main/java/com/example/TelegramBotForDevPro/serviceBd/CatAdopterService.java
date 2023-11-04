package com.example.TelegramBotForDevPro.serviceBd;

import com.example.TelegramBotForDevPro.model.CatAdopter;
import com.example.TelegramBotForDevPro.repository.CatAdopterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CatAdopterService {
    Logger logger = LoggerFactory.getLogger(CatAdopterService.class);
    private final CatAdopterRepository catAdopterRepository;
    @Autowired
    public CatAdopterService(CatAdopterRepository catAdopterRepository) {
        this.catAdopterRepository = CatAdopterService.this.catAdopterRepository;
    }


    //    adds new catAdopter to the db
    public CatAdopter AddCatAdopter(CatAdopter catAdopter) {
        logger.debug("requesting write cat adopter: {}", catAdopter);
        return catAdopterRepository.save(catAdopter);
    }

    //    finds catAdopter by id from the db
    public CatAdopter findCatAdopter(Long id) {
        logger.debug("requesting find cat adopter by id: {}", id);
        return catAdopterRepository.findById(id).get();
    }


    //    edits catAdopter at the db
    public CatAdopter updateCatAdopter(CatAdopter catAdopter) {
        logger.debug("requesting change cat adopter: {}", catAdopter);
        return catAdopterRepository.save(catAdopter);
    }

    //    deletes catAdopter from the db
    public void DeleteCatAdopter(Long id) {
        logger.debug("requesting delete cat adopter by id: {}", id);
        catAdopterRepository.deleteById(id);
    }
    //    finds all cat adopters from the db
    public Collection<CatAdopter> findAllCatAdopters() {
        logger.debug("requesting find all cat adopters");
        return catAdopterRepository.findAll();
    }
}

