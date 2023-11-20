package com.example.TelegramBotForDevPro.entity.report;



import com.example.TelegramBotForDevPro.entity.BaseEntity;
import com.example.TelegramBotForDevPro.entity.animal.Animal;
import com.example.TelegramBotForDevPro.entity.person.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ANIMAL_REPORT", indexes = {
        @Index(name = "IDX_ANIMAL_REPORT_ANIMAL", columnList = "ANIMAL_ID"),
        @Index(name = "IDX_ANIMAL_REPORT_CUSTOMER", columnList = "CUSTOMER_ID")
})
public class AnimalReport extends BaseEntity {

    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "DIET")
    private String diet;

    @Column(name = "WELL_BEING")
    private String wellBeing;

    @Column(name = "BEHAVIOR")
    private String behavior;

    @Column(name = "DATE_CREATE")
    private LocalDateTime dateCreate;

    @ManyToOne
    @JoinColumn(name = "ANIMAL_ID")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public AnimalReport(String photo,
                        String diet,
                        String wellBeing,
                        String behavior,
                        LocalDateTime dateCreate,
                        Animal animal,
                        Customer customer) {
        this.photo = photo;
        this.diet = diet;
        this.wellBeing = wellBeing;
        this.behavior = behavior;
        this.dateCreate = dateCreate;
        this.animal = animal;
        this.customer = customer;
    }

    public AnimalReport(String diet, String wellBeing, String behavior) {
        this.diet = diet;
        this.wellBeing = wellBeing;
        this.behavior = behavior;
    }

    public AnimalReport(String photo, String diet, String wellBeing, String behavior) {
        this.photo = photo;
        this.diet = diet;
        this.wellBeing = wellBeing;
        this.behavior = behavior;
    }

    public AnimalReport() {

    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getWellBeing() {
        return wellBeing;
    }

    public void setWellBeing(String wellBeing) {
        this.wellBeing = wellBeing;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
