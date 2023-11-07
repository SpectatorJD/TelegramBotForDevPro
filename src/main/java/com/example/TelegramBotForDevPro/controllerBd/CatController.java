package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.Cat;
import com.example.TelegramBotForDevPro.serviceBd.CatService;
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
@RequestMapping("/cat")
public class CatController {
    public CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @Operation(
            summary = "Создание кошки",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные создаваемой кошки." +
                            "id переданный в теле будет игнорироваться, будет присвоен следующий id из БД. " +
                            "Все поля кроме id обязательны.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Cat.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные созданной кошки",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    )
            }
    )
    @PostMapping
    public Cat addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @Operation(
            summary = "Получение кошек  по id из БД.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "кошка найдена",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "кошка не найдена"
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<Cat> findCat(@PathVariable Long id) {
        Cat cat = catService.findCat(id);
        if (cat == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(cat);
    }
    @Operation(
            summary = "Изменение данных кошки.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные о кошке с изменениями. Все поля обязательны.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Cat.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Измененные данные о кошке",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "кошка с данным id не найдена"
                    )
            }
    )

    @PutMapping
    public ResponseEntity<Cat> updateCat(@RequestBody Cat cat) {
        Cat updatedCat = catService.updateCat(cat);
        if (updatedCat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(cat);
    }
    @Operation(
            summary = "Удаление кошки по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "кошка успешно удалена"
                    )
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity<Cat> deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Получение всех кошек из БД.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Все найденные кошки",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "кошки не найдены"
                    )
            }
    )
    @GetMapping("/cats")
    public ResponseEntity<Collection<Cat>> getAllCats() {
        Collection<Cat> cats = catService.findAllCats();
        return ResponseEntity.ok(cats);
    }
}