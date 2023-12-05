package com.example.TelegramBotForDevPro.controller;


import com.example.TelegramBotForDevPro.entity.report.AnimalReport;
import com.example.TelegramBotForDevPro.service.report.impl.AnimalReportServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnimalReportController.class)
class AnimalReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalReportServiceImpl service;

    private AnimalReport animalReport;

    private AnimalReport report;

    @BeforeEach
    void init() {
        animalReport = new AnimalReport();
        animalReport.setId(1);
        animalReport.setPhoto("photo");
        animalReport.setDiet("diet");
        animalReport.setWellBeing("wellBeing");
        animalReport.setBehavior("behavior");


        report = new AnimalReport();
        report.setId(2);
        report.setPhoto("photo2");
        report.setDiet("diet2");
        report.setWellBeing("wellBeing2");
        report.setBehavior("behavior2");
    }

    @Test
    void downloadReport() throws Exception {
        when(service.findById(anyInt())).thenReturn(animalReport);
        this.mockMvc.perform(get("/reports/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.photo", is(animalReport.getPhoto())))
                .andExpect(jsonPath("$.diet", is(animalReport.getDiet())))
                .andExpect(jsonPath("$.wellBeing", is(animalReport.getWellBeing())))
                .andExpect(jsonPath("$.behavior", is(animalReport.getBehavior())));
    }

    @Test
    void remove() throws Exception {
        mockMvc.perform(delete("/reports/{id}", 1))
                .andExpect(status().isOk());
        verify(service).remove(1);
    }

    @Test
    void getAll() throws Exception {
        List<AnimalReport> expected = new ArrayList<>();
        expected.add(animalReport);
        expected.add(report);
        when(service.getAll()).thenReturn(expected);
        mockMvc.perform(get("/reports/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(expected.size())));
    }
}