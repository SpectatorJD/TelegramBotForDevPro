package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.DogAdopter;
import com.example.TelegramBotForDevPro.serviceBd.DogAdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dog_adopter")
public class DogAdopterController {
    public DogAdopterService dogAdopterService;

    @Autowired
    public DogAdopterController(DogAdopterService dogAdopterService) {
        this.dogAdopterService = dogAdopterService;
    }

    //    add new dog adopter to the db
    @PostMapping
    public DogAdopter addDogAdopter(@RequestBody DogAdopter dogAdopter) {
        return dogAdopterService.addDogAdopter(dogAdopter);
    }

    //    find dog adopter by id from the db
    @GetMapping("{id}")
    public ResponseEntity<DogAdopter> findDogAdopter(@PathVariable Long id) {
        DogAdopter dogAdopter = dogAdopterService.findDogAdopter(id);
        if (dogAdopter == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(dogAdopter);
    }

    //    edit dog adopter at the db
    @PutMapping
    public ResponseEntity<DogAdopter> updateDogAdopter(@RequestBody DogAdopter dogAdopter) {
        DogAdopter updatedCat = dogAdopterService.updateDogAdopter(dogAdopter);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(dogAdopter);
    }

    //    delete dog adopter from the db
    @DeleteMapping("{id}")
    public ResponseEntity<DogAdopter> deleteDogAdopter(@PathVariable Long id) {
        dogAdopterService.deleteDogAdopter(id);
        return ResponseEntity.ok().build();
    }

    //    finds all dog adopters from the db
    @GetMapping("/dog_adopters")
    public ResponseEntity<Collection<DogAdopter>> getAllDogAdopters() {
        Collection<DogAdopter> dogAdopters = dogAdopterService.findAllDogAdopters();
        return ResponseEntity.ok(dogAdopters);
    }
}
