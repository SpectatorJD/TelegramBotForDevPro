package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.Dog;
import com.example.TelegramBotForDevPro.serviceBd.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dog")
public class DogController {
    public DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    //    add new dog to the db
    @PostMapping
    public Dog addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    //    find dog by id from the db
    @GetMapping("{id}")
    public ResponseEntity<Dog> findDog(@PathVariable Long id) {
        Dog dog = dogService.findDog(id);
        if (dog == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(dog);
    }

    //    edit dog at the db
    @PutMapping
    public ResponseEntity<Dog> updateDog(@RequestBody Dog dog) {
        Dog updatedDog = dogService.updateDog(dog);
        if (updatedDog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(dog);
    }

    //    delete dog from the db
    @DeleteMapping("{id}")
    public ResponseEntity<Dog> deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return ResponseEntity.ok().build();
    }

    //    finds all dogs from the db
    @GetMapping("/dogs")
    public ResponseEntity<Collection<Dog>> getAllDogs() {
        Collection<Dog> dogs = dogService.findAllDogs();
        return ResponseEntity.ok(dogs);
    }
}

