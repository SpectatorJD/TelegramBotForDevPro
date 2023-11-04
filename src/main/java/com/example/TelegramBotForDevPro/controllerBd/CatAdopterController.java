package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.CatAdopter;
import com.example.TelegramBotForDevPro.serviceBd.CatAdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cat_adopter")
public class CatAdopterController {
    public CatAdopterService catAdopterService;

    @Autowired
    public CatAdopterController(CatAdopterService catAdopterService) {
        this.catAdopterService = catAdopterService;
    }

    //    add new cat adopter to the db
    @PostMapping
    public CatAdopter addCatAdopter(@RequestBody CatAdopter catAdopter) {
        return catAdopterService.addCatAdopter(catAdopter);
    }

    //    find cat adopter by id from the db
    @GetMapping("{id}")
    public ResponseEntity<CatAdopter> findCat(@PathVariable Long id) {
        CatAdopter catAdopter = catAdopterService.findCatAdopter(id);
        if (catAdopter == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(catAdopter);
    }

    //    edit cat adopter at the db
    @PutMapping
    public ResponseEntity<CatAdopter> updateCat(@RequestBody CatAdopter catAdopter) {
        CatAdopter updatedCat = catAdopterService.updateCatAdopter(catAdopter);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(catAdopter);
    }

    //    delete cat adopter from the db
    @DeleteMapping("{id}")
    public ResponseEntity<CatAdopter> deleteCatAdopter(@PathVariable Long id) {
        catAdopterService.deleteCatAdopter(id);
        return ResponseEntity.ok().build();
    }

    //    finds all cat adopters from the db
    @GetMapping("/cat_adopters")
    public ResponseEntity<Collection<CatAdopter>> getAllCatAdopters() {
        Collection<CatAdopter> catAdopters = catAdopterService.findAllCatAdopters();
        return ResponseEntity.ok(catAdopters);
    }
}
