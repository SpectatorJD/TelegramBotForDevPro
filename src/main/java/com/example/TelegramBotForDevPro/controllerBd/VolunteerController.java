package com.example.TelegramBotForDevPro.controllerBd;

import com.example.TelegramBotForDevPro.model.Volunteer;
import com.example.TelegramBotForDevPro.serviceBd.VolunteerService;
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
@RequestMapping("/Volunteer")
public class VolunteerController {
    public VolunteerService volunteerService;

    @Autowired
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @Operation(
            summary = "Добавление нового волонтера",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Добавлен новый волонтер",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Volunteer.class)
                            )
                    ),

                    @ApiResponse(
                            responseCode = "404",
                            description = "волонтер не добавлен"
                    )
            }
    )
    @PostMapping
    public Volunteer addVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerService.addVolunteer(volunteer);
    }

    @Operation(
            summary = "Поиск волонтера по id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Найден волонтер с параметрами",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Volunteer.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "волонтер не найден"
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<Volunteer> findVolunteer(@PathVariable Long id) {
        Volunteer volunteer = volunteerService.findVolunteer(id);
        if (volunteer == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(volunteer);
    }

    @Operation(
            summary = "Редактирование волонтера",
            responses = {
        @ApiResponse(
                responseCode = "200",
                description = "Обновленный волонтер",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = Volunteer.class)
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = "волонтер не найден"
        )
    }
    )
    @PutMapping
    public ResponseEntity<Volunteer> updateVolunteer(@RequestBody Volunteer volunteer) {
        Volunteer updatedDog = volunteerService.updateVolunteer(volunteer);
        if (updatedDog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(volunteer);
    }

    @Operation(
            summary = "Удаление волонтера по id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "волонтер успешно удален"
                    )
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity<Volunteer> deleteVolunteer(@PathVariable Long id) {
        volunteerService.deleteVolunteer(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Получение всех волонтеров из БД.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Все найденные волонтеры",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Volunteer.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "волонтеры не найдены"
                    )
            }
    )
    @GetMapping("/Volunteers")
    public ResponseEntity<Collection<Volunteer>> getAllVolunteers() {
        Collection<Volunteer> Volunteers = volunteerService.findAllVolunteers();
        return ResponseEntity.ok(Volunteers);
    }
}

