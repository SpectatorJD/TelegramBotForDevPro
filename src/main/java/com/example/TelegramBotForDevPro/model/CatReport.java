package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
@Setter
@Getter
@Entity(name = "report_about_cat")
public class CatReport {
    public CatReport() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private byte[] photo;
    private String ration;
    private String habits;
    private String behavior;
    private LocalDate lastMessage;
    @ManyToOne
    @JoinColumn(name = "cat_adopter_id")
    private CatAdopter catAdopter;

    public CatReport(long id, byte[] photo, String ration, String habits, String behavior, CatAdopter catAdopter, LocalDate lastMessage) {
        this.id = id;
        this.photo = photo;
        this.ration = ration;
        this.habits = habits;
        this.behavior = behavior;
        this.catAdopter = catAdopter;
        this.lastMessage = lastMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatReport catReport = (CatReport) o;
        return id == catReport.id && Arrays.equals(photo, catReport.photo) && Objects.equals(ration, catReport.ration) && Objects.equals(habits, catReport.habits) && Objects.equals(behavior, catReport.behavior) && Objects.equals(lastMessage, catReport.lastMessage) && Objects.equals(catAdopter, catReport.catAdopter);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, ration, habits, behavior, lastMessage, catAdopter);
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
                ", lastMessage=" + lastMessage +
                ", catAdopter=" + catAdopter +
                '}';
    }
}
