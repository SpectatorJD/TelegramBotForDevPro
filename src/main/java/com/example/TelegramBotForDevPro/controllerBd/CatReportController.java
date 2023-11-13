package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.CatReport;
import com.example.TelegramBotForDevPro.serviceBd.CatAdopterService;
import com.example.TelegramBotForDevPro.serviceBd.CatReportService;
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
@RequestMapping("/cat_report")
public class CatReportController {
    public CatReportService catReportService;

    @Autowired
    public CatReportController(CatReportService catReportService, ) {
        this.catReportService = catReportService;
    }

    @Operation(
            summary = "Добавление отчета в БД.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Добавление отчета",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CatReport.class)
                            )
                    ),
            }
    )
    @PostMapping
    public CatReport addCatReport(@RequestBody CatReport catReport) {
        return catReportService.addCatReport(catReport);
    }

    @Operation(
            summary = "Поиск отчета по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Информация о найденном отчете",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CatReport.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Отчет с данным id не найден"
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<CatReport> findCatReport(@PathVariable Long id) {
        CatReport catReport = catReportService.findCatReport(id);
        if (catReport == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(catReport);
    }

    @Operation(
            summary = "Редактирование отчета в БД",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Измененный отчет",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CatReport.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Отчет не найден"
                    )
            }
    )
    @PutMapping
    public ResponseEntity<CatReport> updateCatReport(@RequestBody CatReport catReport) {
        CatReport updatedCat = catReportService.updateCatReport(catReport);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(catReport);
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
    public ResponseEntity<CatReport> deleteCatReport(@PathVariable Long id) {
        catReportService.deleteCatReport(id);
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
                                    array = @ArraySchema(schema = @Schema(implementation = CatReport.class))
                            )
                    )
            }
    )
    @GetMapping("/cat_reports")
    public ResponseEntity<Collection<CatReport>> getAllCatReports() {
        Collection<CatReport> catReports = catReportService.findAllCatReports();
        return ResponseEntity.ok(catReports);
    }
    @Operation(
            summary = "Поиск фото по id из БД.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "фото из отчета",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = CatReport.class))
                            )
                    )
            }
    )
    @GetMapping(value = "/{id}/cat_photo")
    public ResponseEntity<byte[]> downLoadAvatar(@PathVariable Long id) {
        CatReport catReport = catReportService.findCatReport(id);
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType(catReport.getMediaType()));
        headers.setContentLength(catReport.getPhoto().length);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(catReport.getPhoto());
    }
}
