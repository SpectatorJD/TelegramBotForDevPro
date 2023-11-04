package com.example.TelegramBotForDevPro.serviceBd;

import com.example.TelegramBotForDevPro.model.Dog;
import com.example.TelegramBotForDevPro.repository.DogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DogService {
    Logger logger = LoggerFactory.getLogger(DogService.class);
    private final DogRepository dogRepository;
    @Autowired
    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    //    adds new dog to the db
    public Dog addDog(Dog dog) {
        logger.debug("requesting write dog: {}", dog);
        return dogRepository.save(dog);
    }

    //    finds dog by id from the db
    public Dog findDog(Long id) {
        logger.debug("requesting find dog by id: {}", id);
        return dogRepository.findById(id).get();
    }


    //    edits dog at the db
    public Dog updateDog(Dog dog) {
        logger.debug("requesting change dog: {}", dog);
        return dogRepository.save(dog);
    }

    //    deletes dog from the db
    public void deleteDog(Long id) {
        logger.debug("requesting delete dog by id: {}", id);
        dogRepository.deleteById(id);
    }
    //    finds all dogs from the db
    public Collection<Dog> findAllDogs() {
        logger.debug("requesting find all dogs");
        return dogRepository.findAll();
    }
}
