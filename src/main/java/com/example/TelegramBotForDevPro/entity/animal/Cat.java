package com.example.TelegramBotForDevPro.entity.animal;


import com.example.TelegramBotForDevPro.entity.shelter.CatShelter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@DiscriminatorValue("CAT")
public class Cat extends Animal {

    @JoinColumn(name = "CAT_SHELTER_ID")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private CatShelter catShelter;

    public Cat(String name, Integer age, Boolean isHealthy, Boolean isVaccinated) {
        setName(name);
        setAge(age);
        setHealthy(isHealthy);
        setVaccinated(isVaccinated);
    }

    public CatShelter getCatShelter() {
        return catShelter;
    }

    public void setCatShelter(CatShelter catShelter) {
        this.catShelter = catShelter;
    }
}
