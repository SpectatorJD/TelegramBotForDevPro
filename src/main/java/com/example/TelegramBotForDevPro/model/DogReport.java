package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Arrays;
import java.util.Objects;

@Entity(name = "report_about_Dog")
public class DogReport {
        public DogReport() {
        }
        @Id
        private long id;
        private byte[] photo;
        private String ration;
        private String habits;
        private String behavior;
        @ManyToOne
        @JoinColumn(name = "dog_adopter_id")
        private DogAdopter dogAdopter;

        public DogReport(long id, byte[] photo, String ration, String habits, String behavior, DogAdopter dogAdopter) {
                this.id = id;
                this.photo = photo;
                this.ration = ration;
                this.habits = habits;
                this.behavior = behavior;
                this.dogAdopter = dogAdopter;
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

        public DogAdopter getDogAdopter() {
                return dogAdopter;
        }

        public void setDogAdopter(DogAdopter dogAdopter) {
                this.dogAdopter = dogAdopter;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                DogReport dogReport = (DogReport) o;
                return id == dogReport.id && Arrays.equals(photo, dogReport.photo) && Objects.equals(ration, dogReport.ration) && Objects.equals(habits, dogReport.habits) && Objects.equals(behavior, dogReport.behavior) && Objects.equals(dogAdopter, dogReport.dogAdopter);
        }

        @Override
        public int hashCode() {
                int result = Objects.hash(id, ration, habits, behavior, dogAdopter);
                result = 31 * result + Arrays.hashCode(photo);
                return result;
        }

        @Override
        public String toString() {
                return "DogReport{" +
                        "id=" + id +
                        ", photo=" + Arrays.toString(photo) +
                        ", ration='" + ration + '\'' +
                        ", habits='" + habits + '\'' +
                        ", behavior='" + behavior + '\'' +
                        ", dogAdopter=" + dogAdopter +
                        '}';
        }
}

