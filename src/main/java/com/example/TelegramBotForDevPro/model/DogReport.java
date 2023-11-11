package com.example.TelegramBotForDevPro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "report_about_Dog")
public class DogReport {
        public DogReport() {
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private byte[] photo;
        private String ration;
        private String habits;
        private String behavior;
        private LocalDate lastMessage;
        @OneToOne
        @JoinColumn(name = "dog_adopter_id")
        private DogAdopter dogAdopter;

        public DogReport(long id, byte[] photo, String ration, String habits, String behavior, DogAdopter dogAdopter, LocalDate lastMessage) {
                this.id = id;
                this.photo = photo;
                this.ration = ration;
                this.habits = habits;
                this.behavior = behavior;
                this.dogAdopter = dogAdopter;
                this.lastMessage = lastMessage;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                DogReport dogReport = (DogReport) o;
                return id == dogReport.id && Arrays.equals(photo, dogReport.photo) && Objects.equals(ration, dogReport.ration) && Objects.equals(habits, dogReport.habits) && Objects.equals(behavior, dogReport.behavior) && Objects.equals(lastMessage, dogReport.lastMessage) && Objects.equals(dogAdopter, dogReport.dogAdopter);
        }

        @Override
        public int hashCode() {
                int result = Objects.hash(id, ration, habits, behavior, lastMessage, dogAdopter);
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
                        ", lastMessage=" + lastMessage +
                        ", dogAdopter=" + dogAdopter +
                        '}';
        }
}

