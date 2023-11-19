package com.example.TelegramBotForDevPro.entity;



import com.example.TelegramBotForDevPro.exception.ValidationException;
import com.example.TelegramBotForDevPro.service.ValidationRegularService;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!ValidationRegularService.validateBaseStr(name)) {
            throw new ValidationException(name);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
