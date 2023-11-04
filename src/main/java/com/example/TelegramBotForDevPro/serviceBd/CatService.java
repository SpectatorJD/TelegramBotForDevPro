package com.example.TelegramBotForDevPro.serviceBd;

import com.example.TelegramBotForDevPro.model.Cat;
import com.example.TelegramBotForDevPro.repository.CatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CatService {
    Logger logger = LoggerFactory.getLogger(CatService.class);
    private final CatRepository catRepository;
@Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }


    //    adds new cat to the db
    public Cat AddCat(Cat cat) {
        logger.debug("requesting write cat: {}", cat);
        return catRepository.save(cat);
    }

    //    finds cat by id from the db
    public Cat findCat(Long id) {
        logger.debug("requesting find cat by id: {}", id);
        return catRepository.findById(id).get();
    }


    //    edits cat at the db
    public Cat updateCat(Cat cat) {
        logger.debug("requesting change cat: {}", cat);
        return catRepository.save(cat);
    }

    //    deletes cat from the db
    public void DeleteCat(Long id) {
        logger.debug("requesting delete cat by id: {}", id);
        catRepository.deleteById(id);
    }
    //    finds all cats from the db
    public Collection<Cat> findAllCats() {
        logger.debug("requesting find all cats");
        return catRepository.findAll();
    }
}
