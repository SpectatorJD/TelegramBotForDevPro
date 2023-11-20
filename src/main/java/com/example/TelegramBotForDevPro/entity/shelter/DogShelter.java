package com.example.TelegramBotForDevPro.entity.shelter;




import com.example.TelegramBotForDevPro.entity.animal.Dog;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("DSH")
public class DogShelter extends AnimalShelter {

    @OneToMany(mappedBy = "dogShelter")
    private List<Dog> dogs;

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}





