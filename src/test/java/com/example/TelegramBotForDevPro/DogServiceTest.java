package com.example.TelegramBotForDevPro;

import com.example.TelegramBotForDevPro.model.Dog;
import com.example.TelegramBotForDevPro.repository.DogRepository;
import com.example.TelegramBotForDevPro.serviceBd.DogService;
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
public class DogServiceTest {

    private DogService out;
    private DogRepository dogRepository;

    @BeforeEach
    public void setUp() {
        dogRepository = mock(DogRepository.class);
        out = new DogService(dogRepository);
    }

    private List<Dog> dogs() {
        return List.of(new Dog(1L, "Doggy", "breedy", "red"),
                new Dog(2L, "Goody", "breedly", "gray"));
    }

    @Test
    public void findAllDogsTest() {
        when(dogRepository.findAll()).thenReturn(dogs());
        out.addDog(new Dog(1L, "Doggy", "breedy", "red"));
        out.addDog(new Dog(2L, "Goody", "breedly", "gray"));
        assertIterableEquals(dogs(), out.findAllDogs());
        verify(dogRepository, times(1)).findAll();
    }

    @Test
    public void addDogTest() {
        when(dogRepository.save(new Dog(1L, "Doggy", "breedy", "red"))).thenReturn(new Dog(1L, "Doggy", "breedy", "red"));
        Dog dog = new Dog(1L, "Doggy", "breedy", "red");
        Dog result = out.addDog(new Dog(1L, "Doggy", "breedy", "red"));
        assertEquals(dog, result);
        verify(dogRepository, times(1)).save(new Dog(1L, "Doggy", "breedy", "red"));
    }

    @Test
    public void findDogTest() {
        when(dogRepository.findById(1L)).thenReturn(Optional.of(new Dog(1L, "Doggy", "breedy", "red")));

        Dog dog = new Dog(1L, "Doggy", "breedy", "red");
        Dog result = out.findDog(1L);
        verify(dogRepository, times(1)).findById(1L);
    }

    @Test
    public void updateDogTest() {
        when(dogRepository.save(new Dog(1L, "Doggy", "breedy", "red"))).thenReturn(new Dog(1L, "Doggy", "breedy", "red"));

        Dog dog = new Dog(1L, "Doggy", "breedy", "red");
        Dog result = out.updateDog(new Dog(1L, "Doggy", "breedy", "red"));
        assertEquals(dog, result);
        verify(dogRepository, times(1)).save(new Dog(1L, "Doggy", "breedy", "red"));
    }

    @Test
    public void deleteDogTest() {
        when(dogRepository.findById(1L)).thenReturn(Optional.of(new Dog(1L, "Doggy", "breedy", "red")));
        Dog dog = new Dog(1L, "Doggy", "breedy", "red");
        Dog result = out.findDog(1L);
        out.deleteDog(1L);
        verify(dogRepository, times(1)).deleteById(1L);
    }
}

