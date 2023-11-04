package com.example.TelegramBotForDevPro.serviceBd;

import com.example.TelegramBotForDevPro.model.Volunteer;
import com.example.TelegramBotForDevPro.repository.VolunteerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VolunteerService {
    Logger logger = LoggerFactory.getLogger(VolunteerService.class);
    private final VolunteerRepository volunteerRepository;
    @Autowired
    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }


    //    adds new volunteer to the db
    public Volunteer addVolunteer(Volunteer volunteer) {
        logger.debug("requesting write volunteer: {}", volunteer);
        return volunteerRepository.save(volunteer);
    }

    //    finds volunteer by id from the db
    public Volunteer findVolunteer(Long id) {
        logger.debug("requesting find volunteer by id: {}", id);
        return volunteerRepository.findById(id).get();
    }


    //    edits volunteer at the db
    public Volunteer updateVolunteer(Volunteer volunteer) {
        logger.debug("requesting change volunteer: {}", volunteer);
        return volunteerRepository.save(volunteer);
    }

    //    deletes volunteer from the db
    public void deleteVolunteer(Long id) {
        logger.debug("requesting delete volunteer by id: {}", id);
        volunteerRepository.deleteById(id);
    }
    //    finds all volunteers from the db
    public Collection<Volunteer> findAllVolunteers() {
        logger.debug("requesting find all volunteers");
        return volunteerRepository.findAll();
    }
}

