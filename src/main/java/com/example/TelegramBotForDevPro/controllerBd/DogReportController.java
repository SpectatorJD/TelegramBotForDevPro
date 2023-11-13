package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.DogReport;
import com.example.TelegramBotForDevPro.serviceBd.DogReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dog_report")
public class DogReportController {
    public DogReportService dogReportService;

    @Autowired
    public DogReportController(DogReportService dogReportService) {
        this.dogReportService = dogReportService;
    }

        @Operation(
            summary = "Добавление отчета в БД",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Добавленный отчет",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DogReport.class)
                            )
                    )
            }
    )
    @PostMapping
    public DogReport addDogReport(@RequestBody DogReport DogReport) {
        return dogReportService.addDogReport(DogReport);
    }

    @Operation(
            summary = "Поиск отчета по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Информация о найденном отчете",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DogReport.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Отчет с данным id не найден"
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<DogReport> findDogReport(@PathVariable Long id) {
        DogReport DogReport = dogReportService.findDogReport(id);
        if (DogReport == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(DogReport);
    }

    @Operation(
            summary = "Редактирование отчета в БД",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Измененный отчет",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DogReport.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Отчет не найден"
                    )
            }
    )
    @PutMapping
    public ResponseEntity<DogReport> updateDogReport(@RequestBody DogReport DogReport) {
        DogReport updatedCat = dogReportService.updateDogReport(DogReport);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(DogReport);
    }

    @Operation(
            summary = "Удаление отчета по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Отчет успешно удален"

                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Отчет с данным id не найден"
                    )
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity<DogReport> deleteDogReport(@PathVariable Long id) {
        dogReportService.deleteDogReport(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Получить список всех отчетов",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Список всех отчетов",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = DogReport.class))
                            )
                    )
            }
    )
    @GetMapping("/dog_reports")
    public ResponseEntity<Collection<DogReport>> getAllDogReports() {
        Collection<DogReport> dogReports = dogReportService.findAllDogReports();
        return ResponseEntity.ok(dogReports);
    }
    @GetMapping(value = "/{id}/dog_photo")
    public ResponseEntity<byte[]> downLoadDogPhoto(@PathVariable Long id) {
        DogReport catReport = dogReportService.findDogReport(id);
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType(catReport.getMediaType()));
        headers.setContentLength(catReport.getPhoto().length);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(catReport.getPhoto());
    }
}



