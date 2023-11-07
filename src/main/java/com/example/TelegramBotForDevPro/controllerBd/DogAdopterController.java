package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.DogAdopter;
import com.example.TelegramBotForDevPro.serviceBd.DogAdopterService;
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
@RequestMapping("/dog_adopter")
public class DogAdopterController {
    public DogAdopterService dogAdopterService;

    @Autowired
    public DogAdopterController(DogAdopterService dogAdopterService) {
        this.dogAdopterService = dogAdopterService;
    }

    @Operation(
            summary = "Создание владельца животного",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные создаваемого владельца животного." +
                            "id переданный в теле будет игнорироваться, будет присвоен следующий id из БД. " +
                            "Все поля кроме id обязательны.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = DogAdopter.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные созданного владельца животного",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DogAdopter.class)
                            )

                    )
            }
    )
    @PostMapping
    public DogAdopter addDogAdopter(@RequestBody DogAdopter dogAdopter) {
        return dogAdopterService.addDogAdopter(dogAdopter);
    }

    @Operation(
            summary = "Поиск владельца животного по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Информация о найденном владельце животного",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DogAdopter.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "владелец животного с данным id не найден"
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<DogAdopter> findDogAdopter(@PathVariable Long id) {
        DogAdopter dogAdopter = dogAdopterService.findDogAdopter(id);
        if (dogAdopter == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(dogAdopter);
    }

    @Operation(
            summary = "Изменение данных владельца животного.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные о владельце животного с изменениями. Все поля обязательны.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = DogAdopter.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Измененные данные о владельце животного",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DogAdopter.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Владелец животного с данным id не найден"
                    )
            }
    )
    @PutMapping
    public ResponseEntity<DogAdopter> updateDogAdopter(@RequestBody DogAdopter dogAdopter) {
        DogAdopter updatedCat = dogAdopterService.updateDogAdopter(dogAdopter);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(dogAdopter);
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
    public ResponseEntity<DogAdopter> deleteDogAdopter(@PathVariable Long id) {
        dogAdopterService.deleteDogAdopter(id);
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
                                    schema = @Schema(implementation = DogAdopter.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "клиенты не найдены"
                    )
            }
    )
    @GetMapping("/dog_adopters")
    public ResponseEntity<Collection<DogAdopter>> getAllDogAdopters() {
        Collection<DogAdopter> dogAdopters = dogAdopterService.findAllDogAdopters();
        return ResponseEntity.ok(dogAdopters);
    }
}
