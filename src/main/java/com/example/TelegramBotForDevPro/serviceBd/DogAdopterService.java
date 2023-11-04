package com.example.TelegramBotForDevPro.serviceBd;

import com.example.TelegramBotForDevPro.model.DogAdopter;
import com.example.TelegramBotForDevPro.repository.DogAdopterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DogAdopterService {
    Logger logger = LoggerFactory.getLogger(DogAdopterService.class);
    private final DogAdopterRepository dogAdopterRepository;
    @Autowired
    public DogAdopterService(DogAdopterRepository dogAdopterRepository) {
        this.dogAdopterRepository = dogAdopterRepository;
    }


    //    adds new dog adopter to the db
    public DogAdopter AddDogAdopter(DogAdopter dogAdopter) {
        logger.debug("requesting write dog adopter: {}", dogAdopter);
        return dogAdopterRepository.save(dogAdopter);
    }

    //    finds dog adopter by id from the db
    public DogAdopter findDogAdopter(Long id) {
        logger.debug("requesting find dog adopter by id: {}", id);
        return dogAdopterRepository.findById(id).get();
    }


    //    edits dog adopter at the db
    public DogAdopter updateDogAdopter(DogAdopter dogAdopter) {
        logger.debug("requesting change dog adopter: {}", dogAdopter);
        return dogAdopterRepository.save(dogAdopter);
    }

    //    deletes dog adopter from the db
    public void DeleteDogAdopter(Long id) {
        logger.debug("requesting delete dog adopter by id: {}", id);
        dogAdopterRepository.deleteById(id);
    }
    //    finds all dog adopters from the db
    public Collection<DogAdopter> findAllDogAdopters() {
        logger.debug("requesting find all dog adopters");
        return dogAdopterRepository.findAll();
    }
}

