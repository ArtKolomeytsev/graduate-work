package ru.skypro.homework.exceprion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdvertNotFoundException extends RuntimeException {
    public AdvertNotFoundException() {
        super("Advert not found");
    }
}
