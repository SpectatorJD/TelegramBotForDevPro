package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Arrays;
import java.util.Objects;

@Entity(name = "report_about_cat")
public class CatReport {
    public CatReport() {
    }
    @Id
    private long id;
    private byte[] photo;
    private String ration;
    private String habits;
    private String behavior;
    @ManyToOne
    @JoinColumn(name = "cat_adopter_id")
    private CatAdopter catAdopter;

    public CatReport(long id, byte[] photo, String ration, String habits, String behavior, CatAdopter catAdopter) {
        this.id = id;
        this.photo = photo;
        this.ration = ration;
        this.habits = habits;
        this.behavior = behavior;
        this.catAdopter = catAdopter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getRation() {
        return ration;
    }

    public void setRation(String ration) {
        this.ration = ration;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public CatAdopter getCatAdopter() {
        return catAdopter;
    }

    public void setCatAdopter(CatAdopter catAdopter) {
        this.catAdopter = catAdopter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatReport catReport = (CatReport) o;
        return id == catReport.id && Arrays.equals(photo, catReport.photo) && Objects.equals(ration, catReport.ration) && Objects.equals(habits, catReport.habits) && Objects.equals(behavior, catReport.behavior) && Objects.equals(catAdopter, catReport.catAdopter);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, ration, habits, behavior, catAdopter);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @Override
    public String toString() {
        return "CatReport{" +
                "id=" + id +
                ", photo=" + Arrays.toString(photo) +
                ", ration='" + ration + '\'' +
                ", habits='" + habits + '\'' +
                ", behavior='" + behavior + '\'' +
                ", catAdopter=" + catAdopter +
                '}';
    }
}
