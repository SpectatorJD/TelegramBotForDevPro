package com.example.TelegramBotForDevPro;

import com.example.TelegramBotForDevPro.model.Dog;
import com.example.TelegramBotForDevPro.model.DogAdopter;
import com.example.TelegramBotForDevPro.repository.DogAdopterRepository;
import com.example.TelegramBotForDevPro.serviceBd.DogAdopterService;
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
public class DogAdopterServiceTest {


    private DogAdopterService out;
    private DogAdopterRepository dogAdopterRepository;

    @BeforeEach
    public void setUp() {
        dogAdopterRepository = mock(DogAdopterRepository.class);
        out = new DogAdopterService(dogAdopterRepository);
    }

    private List<DogAdopter> dogAdopters() {
        return List.of(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")),
                new DogAdopter(2L, "Alice", "89228297762", new Dog(2L, "Goody", "breedly", "gray")));
    }

    @Test
    public void findAllDogAdoptersTest() {
        when(dogAdopterRepository.findAll()).thenReturn(dogAdopters());
        out.addDogAdopter(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")));
        out.addDogAdopter(new DogAdopter(2L, "Alice", "89228297762", new Dog(2L, "Goody", "breedly", "gray")));
        assertIterableEquals(dogAdopters(), out.findAllDogAdopters());
        verify(dogAdopterRepository, times(1)).findAll();
    }

    @Test
    public void addDogAdopterTest() {
        when(dogAdopterRepository.save(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")))).thenReturn(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")));
        DogAdopter dogAdopter = new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red"));
        DogAdopter result = out.addDogAdopter(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")));
        assertEquals(dogAdopter, result);
        verify(dogAdopterRepository, times(1)).save(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")));
    }

    @Test
    public void findDogAdopterTest() {
        when(dogAdopterRepository.findById(1L)).thenReturn(Optional.of(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red"))));

        DogAdopter dogAdopter = new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red"));
        DogAdopter result = out.findDogAdopter(1L);
        verify(dogAdopterRepository, times(1)).findById(1L);
    }

    @Test
    public void updateDogAdopterTest() {
        when(dogAdopterRepository.save(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")))).thenReturn(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")));

        DogAdopter dogAdopter = new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red"));
        DogAdopter result = out.updateDogAdopter(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")));
        assertEquals(dogAdopter, result);
        verify(dogAdopterRepository, times(1)).save(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red")));
    }

    @Test
    public void deleteDogAdopterTest() {
        when(dogAdopterRepository.findById(1L)).thenReturn(Optional.of(new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red"))));
        DogAdopter dogAdopter = new DogAdopter(1L, "Kate", "89223191715", new Dog(1L, "Doggy", "breedy", "red"));
        DogAdopter result = out.findDogAdopter(1L);
        out.deleteDogAdopter(1L);
        verify(dogAdopterRepository, times(1)).deleteById(1L);
    }
}

