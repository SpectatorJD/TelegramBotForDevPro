package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.Cat;
import com.example.TelegramBotForDevPro.serviceBd.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cat")
public class CatController {
    public CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    //    add new cat to the db
    @PostMapping
    public Cat addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    //    find cat by id from the db
    @GetMapping("{id}")
    public ResponseEntity<Cat> findCat(@PathVariable Long id) {
        Cat cat = catService.findCat(id);
        if (cat == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(cat);
    }

    //    edit cat at the db
    @PutMapping
    public ResponseEntity<Cat> updateCat(@RequestBody Cat cat) {
        Cat updatedCat = catService.updateCat(cat);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(cat);
    }

    //    delete cat from the db
    @DeleteMapping("{id}")
    public ResponseEntity<Cat> deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
        return ResponseEntity.ok().build();
    }

    //    finds all cats from the db
    @GetMapping("/cats")
    public ResponseEntity<Collection<Cat>> getAllCats() {
        Collection<Cat> cats = catService.findAllCats();
        return ResponseEntity.ok(cats);
    }
}