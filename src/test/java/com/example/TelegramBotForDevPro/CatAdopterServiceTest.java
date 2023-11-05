package com.example.TelegramBotForDevPro;

import com.example.TelegramBotForDevPro.model.Cat;
import com.example.TelegramBotForDevPro.model.CatAdopter;
import com.example.TelegramBotForDevPro.repository.CatAdopterRepository;
import com.example.TelegramBotForDevPro.serviceBd.CatAdopterService;
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
public class CatAdopterServiceTest {
    private CatAdopterService out;
    private CatAdopterRepository catAdopterRepository;

    @BeforeEach
    public void setUp() {
        catAdopterRepository = mock(CatAdopterRepository.class);
        out = new CatAdopterService(catAdopterRepository);
    }

    private List<CatAdopter> catAdopters() {
        return List.of(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red")),
                new CatAdopter(2L, "Alice", "89229127762", new Cat(2L, "Pussy", "breedly", "gray")));
    }

    @Test
    public void findAllCatAdoptersTest() {
        when(catAdopterRepository.findAll()).thenReturn(catAdopters());
        out.addCatAdopter(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red")));
        out.addCatAdopter(new CatAdopter(2L, "Alice", "89229127762", new Cat(2L, "Pussy", "breedly", "gray")));
        assertIterableEquals(catAdopters(), out.findAllCatAdopters());
        verify(catAdopterRepository, times(1)).findAll();
    }

    @Test
    public void addCatAdopterTest() {
        when(catAdopterRepository.save(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red")))).thenReturn(new CatAdopter(1L, "Kate", "89228153765", new Cat()));
        CatAdopter cat = new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red"));
        CatAdopter result = out.addCatAdopter(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red")));
        assertEquals(cat, result);
        verify(catAdopterRepository, times(1)).save(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red")));
    }

    @Test
    public void findCatAdopterTest() {
        when(catAdopterRepository.findById(1L)).thenReturn(Optional.of(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red"))));

        CatAdopter cat = new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red"));
        CatAdopter result = out.findCatAdopter(1L);
        verify(catAdopterRepository, times(1)).findById(1L);
    }

    @Test
    public void updateCatAdopterTest() {
        when(catAdopterRepository.save(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red")))).thenReturn(new CatAdopter(1L, "Kate", "89228153765", new Cat()));

        CatAdopter cat = new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red"));
        CatAdopter result = out.updateCatAdopter(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red")));
        assertEquals(cat, result);
        verify(catAdopterRepository, times(1)).save(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red")));
    }

    @Test
    public void deleteCatAdopterTest() {
        when(catAdopterRepository.findById(1L)).thenReturn(Optional.of(new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red"))));
        CatAdopter cat = new CatAdopter(1L, "Kate", "89228153765", new Cat(1L, "Kitty", "breedy", "red"));
        CatAdopter result = out.findCatAdopter(1L);
        out.deleteCatAdopter(1L);
        verify(catAdopterRepository, times(1)).deleteById(1L);
    }
}

