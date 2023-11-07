package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.Dog;
import com.example.TelegramBotForDevPro.serviceBd.DogService;
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
@RequestMapping("/dog")
public class DogController {
    public DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @Operation(
            summary = "Создание собаки",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные создаваемой собаки." +
                            "id переданный в теле будет игнорироваться, будет присвоен следующий id из БД. " +
                            "Все поля кроме id обязательны.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Dog.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные созданной собаки",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Dog.class)
                            )
                    )
            }
    )
    @PostMapping
    public Dog addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    @Operation(
            summary = "Поиск владельца животного по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Информация о найденой собаке",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Dog.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "собака с данным id не найден"
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<Dog> findDog(@PathVariable Long id) {
        Dog dog = dogService.findDog(id);
        if (dog == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(dog);
    }

    @Operation(
            summary = "Изменение данных собаки.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные о собаке с изменениями. Все поля обязательны.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Dog.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Измененные данные о собаке",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Dog.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Собака с данным id не найдена"
                    )
            }
    )
    @PutMapping
    public ResponseEntity<Dog> updateDog(@RequestBody Dog dog) {
        Dog updatedDog = dogService.updateDog(dog);
        if (updatedDog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(dog);
    }

    @Operation(
            summary = "Удаление собаки по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Собака успешно удалена"
                    )
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity<Dog> deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Получение всех собак из БД.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Все найденные собаки",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Dog.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "собаки не найдены"
                    )
            }
    )
    @GetMapping("/dogs")
    public ResponseEntity<Collection<Dog>> getAllDogs() {
        Collection<Dog> dogs = dogService.findAllDogs();
        return ResponseEntity.ok(dogs);
    }
}

