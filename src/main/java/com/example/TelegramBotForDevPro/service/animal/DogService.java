package com.example.TelegramBotForDevPro.service.animal;


import com.example.TelegramBotForDevPro.entity.animal.Dog;
import com.example.TelegramBotForDevPro.entity.person.Customer;
import com.example.TelegramBotForDevPro.repository.animal.DogRepository;

import com.example.TelegramBotForDevPro.timer.ProbationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DogService {
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    public boolean save(Dog dog) {
        if (!(dog == null
                || (dog.getName() == null || dog.getName().isBlank())
                || (dog.getAge() == null || dog.getAge() < 0)
                || dog.getHealthy() == null
                || dog.getVaccinated() == null)) {
            dogRepository.save(dog);
            return true;
        }
        return false;
    }


    public Optional<Dog> findById(int id) {
        return dogRepository.findById(id);
    }


    public List<Dog> findAllByHealth(Boolean isHealthy) {
        return dogRepository.findAllByHealth(isHealthy);
    }


    public List<Dog> findAllByVaccinate(Boolean isVaccinated) {
        return dogRepository.findAllByVaccination(isVaccinated);
    }


    public List<Dog> findAllByHealthAndVaccination(Boolean isHealthy, Boolean isVaccinated) {
        return dogRepository.findAllByHealthAndVaccination(isHealthy, isVaccinated);
    }

    public List<Dog> findAll() {
        return dogRepository.findAll();
    }


    public Integer updateById(Integer id, String name, Integer age, Boolean isHealthy, Boolean isVaccinated) {
        Optional<Dog> dog = findById(id);
        if (dog.isEmpty()
                || (name == null || name.isBlank())
                || (age == null || age < 0)
                || isHealthy == null
                || isVaccinated == null) {
            return 0;
        } else {
            dogRepository.updateById(id, name, age, isHealthy, isVaccinated);
            return 1;
        }
    }

    public Boolean deleteById(int id) {
        Optional<Dog> findDogById = findById(id);
        if (findDogById.isEmpty()) {
            return false;
        }
        dogRepository.deleteById(id);
        return true;
    }
    public List<Dog> findOnProbation(ProbationType... probationTypes) {
        List<Integer> integers = new ArrayList<>();
        for (ProbationType probation : probationTypes) {
            integers.add(probation.getId());
        }
        return dogRepository.findByProbationIn(integers);
    }
}
