package com.example.TelegramBotForDevPro;

import com.example.TelegramBotForDevPro.model.Volunteer;
import com.example.TelegramBotForDevPro.repository.VolunteerRepository;
import com.example.TelegramBotForDevPro.serviceBd.VolunteerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VolunteerTest {

    private VolunteerService out;
    private VolunteerRepository volunteerRepository;

    @BeforeEach
    public void setUp() {
        volunteerRepository = mock(VolunteerRepository.class);
        out = new VolunteerService(volunteerRepository);
    }

    private List<Volunteer> volunteers() {
        return List.of(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"),
                new Volunteer(2L, 678L, "Luter", "89228892732", "Devil"));
    }

    @Test
    public void findAllVolunteersTest() {
        when(volunteerRepository.findAll()).thenReturn(volunteers());
        out.addVolunteer(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"));
        out.addVolunteer(new Volunteer(2L, 678L, "Luter", "89228892732", "Devil"));
        assertIterableEquals(volunteers(), out.findAllVolunteers());
        verify(volunteerRepository, times(1)).findAll();
    }

    @Test
    public void addVolunteerTest() {
        when(volunteerRepository.save(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"))).thenReturn(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"));
        Volunteer volunteer = new Volunteer(1L, 541, "Michale", "89228191712", "Angel");
        Volunteer result = out.addVolunteer(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"));
        assertEquals(volunteer, result);
        verify(volunteerRepository, times(1)).save(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"));
    }

    @Test
    public void findVolunteerTest() {
        when(volunteerRepository.findById(1L)).thenReturn(Optional.of(new Volunteer(1L, 541, "Michale", "89228191712", "Angel")));

        Volunteer volunteer = new Volunteer(1L, 541, "Michale", "89228191712", "Angel");
        Volunteer result = out.findVolunteer(1L);
        verify(volunteerRepository, times(1)).findById(1L);
    }

    @Test
    public void updateVolunteerTest() {
        when(volunteerRepository.save(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"))).thenReturn(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"));

        Volunteer volunteer = new Volunteer(1L, 541, "Michale", "89228191712", "Angel");
        Volunteer result = out.updateVolunteer(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"));
        assertEquals(volunteer, result);
        verify(volunteerRepository, times(1)).save(new Volunteer(1L, 541, "Michale", "89228191712", "Angel"));
    }

    @Test
    public void deleteVolunteerTest() {
        when(volunteerRepository.findById(1L)).thenReturn(Optional.of(new Volunteer(1L, 541, "Michale", "89228191712", "Angel")));
        Volunteer volunteer = new Volunteer(1L, 541, "Michale", "89228191712", "Angel");
        Volunteer result = out.findVolunteer(1L);
        out.deleteVolunteer(1L);
        verify(volunteerRepository, times(1)).deleteById(1L);
    }
}

