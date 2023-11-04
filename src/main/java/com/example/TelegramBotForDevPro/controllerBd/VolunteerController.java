package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.Volunteer;
import com.example.TelegramBotForDevPro.serviceBd.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/Volunteer")
public class VolunteerController {
    public VolunteerService volunteerService;

    @Autowired
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    //    add new volunteer to the db
    @PostMapping
    public Volunteer addVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerService.addVolunteer(volunteer);
    }

    //    find volunteer by id from the db
    @GetMapping("{id}")
    public ResponseEntity<Volunteer> findVolunteer(@PathVariable Long id) {
        Volunteer volunteer = volunteerService.findVolunteer(id);
        if (volunteer == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(volunteer);
    }

    //    edit volunteer at the db
    @PutMapping
    public ResponseEntity<Volunteer> updateVolunteer(@RequestBody Volunteer volunteer) {
        Volunteer updatedDog = volunteerService.updateVolunteer(volunteer);
        if (updatedDog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(volunteer);
    }

    //    delete volunteer from the db
    @DeleteMapping("{id}")
    public ResponseEntity<Volunteer> deleteVolunteer(@PathVariable Long id) {
        volunteerService.deleteVolunteer(id);
        return ResponseEntity.ok().build();
    }

    //    finds all volunteers from the db
    @GetMapping("/Volunteers")
    public ResponseEntity<Collection<Volunteer>> getAllVolunteers() {
        Collection<Volunteer> Volunteers = volunteerService.findAllVolunteers();
        return ResponseEntity.ok(Volunteers);
    }
}

