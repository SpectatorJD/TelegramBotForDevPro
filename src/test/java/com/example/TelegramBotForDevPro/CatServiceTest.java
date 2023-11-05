package com.example.TelegramBotForDevPro;

import com.example.TelegramBotForDevPro.model.Cat;
import com.example.TelegramBotForDevPro.repository.CatRepository;
import com.example.TelegramBotForDevPro.serviceBd.CatService;
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
public class CatServiceTest {
    private CatService out;
    private CatRepository catRepository;

    @BeforeEach
    public void setUp() {
        catRepository = mock(CatRepository.class);
        out = new CatService(catRepository);
    }

    private List<Cat> cats() {
        return List.of(new Cat(1L, "Kitty", "breedy", "red"),
                new Cat(2L, "Pussy", "breedly", "gray"));
    }

    @Test
    public void findAllCatsTest() {
        when(catRepository.findAll()).thenReturn(cats());
        out.addCat(new Cat(1L, "Kitty", "breedy", "red"));
        out.addCat(new Cat(2L, "Pussy", "breedly", "gray"));
        assertIterableEquals(cats(), out.findAllCats());
        verify(catRepository, times(1)).findAll();
    }

    @Test
    public void addCatTest() {
        when(catRepository.save(new Cat(1L, "Kitty", "breedy", "red"))).thenReturn(new Cat(1L, "Kitty", "breedy", "red"));
        Cat cat = new Cat(1L, "Kitty", "breedy", "red");
        Cat result = out.addCat(new Cat(1L, "Kitty", "breedy", "red"));
        assertEquals(cat, result);
        verify(catRepository, times(1)).save(new Cat(1L, "Kitty", "breedy", "red"));
    }

    @Test
    public void findCatTest() {
        when(catRepository.findById(1L)).thenReturn(Optional.of(new Cat(1L, "Kitty", "breedy", "red")));

        Cat cat = new Cat(1L, "Kitty", "breedy", "red");
        Cat result = out.findCat(1L);
        verify(catRepository, times(1)).findById(1L);
    }

    @Test
    public void updateCatTest() {
        when(catRepository.save(new Cat(1L, "Kitty", "breedy", "red"))).thenReturn(new Cat(1L, "Kitty", "breedy", "red"));

        Cat cat = new Cat(1L, "Kitty", "breedy", "red");
        Cat result = out.updateCat(new Cat(1L, "Kitty", "breedy", "red"));
        assertEquals(cat, result);
        verify(catRepository, times(1)).save(new Cat(1L, "Kitty", "breedy", "red"));
    }

    @Test
    public void deleteCatTest() {
        when(catRepository.findById(1L)).thenReturn(Optional.of(new Cat(1L, "Kitty", "breedy", "red")));
        Cat cat = new Cat(1L, "Kitty", "breedy", "red");
        Cat result = out.findCat(1L);
        out.deleteCat(1L);
        verify(catRepository, times(1)).deleteById(1L);
    }
}
