package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.CatAdopter;
import com.example.TelegramBotForDevPro.serviceBd.CatAdopterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cat_adopter")
public class CatAdopterController {
    public CatAdopterService catAdopterService;

    @Autowired
    public CatAdopterController(CatAdopterService catAdopterService) {
        this.catAdopterService = catAdopterService;
    }

    @Operation(
            summary = "Создание владельца животного",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные создаваемого владельца животного." +
                            "id переданный в теле будет игнорироваться, будет присвоен следующий id из БД. " +
                            "Все поля кроме id обязательны.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CatAdopter.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные созданного владельца животного",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CatAdopter.class)
                            )
                    )
            }
    )
    @PostMapping
    public CatAdopter addCatAdopter(@RequestBody CatAdopter catAdopter) {
        return catAdopterService.addCatAdopter(catAdopter);
    }

    @Operation(
            summary = "Поиск владельца животного по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Информация о найденном владельце животного",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CatAdopter.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "владелец животного с данным id не найден"
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<CatAdopter> findCat(@PathVariable Long id) {
        CatAdopter catAdopter = catAdopterService.findCatAdopter(id);
        if (catAdopter == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(catAdopter);
    }

    @Operation(
            summary = "Изменение данных владельца животного.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные о владельце животного с изменениями. Все поля обязательны.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CatAdopter.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Измененные данные о владельце животного",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CatAdopter.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Владелец животного с данным id не найден"
                    )
            }
    )
    @PutMapping
    public ResponseEntity<CatAdopter> updateCat(@RequestBody CatAdopter catAdopter) {
        CatAdopter updatedCat = catAdopterService.updateCatAdopter(catAdopter);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(catAdopter);
    }

    @Operation(
            summary = "Удаление владельца животного по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Владелец животного успешно удален"
                    )
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity<CatAdopter> deleteCatAdopter(@PathVariable Long id) {
        catAdopterService.deleteCatAdopter(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Получение всех клиентов из БД.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Все найденные клиенты",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CatAdopter.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "клиенты не найдены"
                    )
            }
    )
    @GetMapping("/cat_adopters")
    public ResponseEntity<Collection<CatAdopter>> getAllCatAdopters() {
        Collection<CatAdopter> catAdopters = catAdopterService.findAllCatAdopters();
        return ResponseEntity.ok(catAdopters);
    }
}
