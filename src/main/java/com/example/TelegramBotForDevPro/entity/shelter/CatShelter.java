package com.example.TelegramBotForDevPro.entity.shelter;



import com.example.TelegramBotForDevPro.entity.animal.Cat;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity

public class CatShelter extends AnimalShelter {

    @OneToMany(mappedBy = "catShelter")
    private List<Cat> cats;

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}

;


