package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.ImagesForMessageDto;

import java.util.List;


@RequestMapping("images")
public class ImagesFroMessageController {
    @GetMapping(path = "getImage/{id}")
    public ResponseEntity<ImagesForMessageDto> getImage(@PathVariable String idImage){
        return null;
    }

    @GetMapping(path = "getImages/{id}")
    public ResponseEntity<List<ImagesForMessageDto>> getImages(@PathVariable String idMessage){
        return null;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ImagesForMessageDto> addImage(@RequestBody ImagesForMessageDto image){
        return null;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<ImagesForMessageDto> updateImage(@RequestBody ImagesForMessageDto image){
        return null;
    }

    @DeleteMapping(path = "deleteImage/{id}")
    public ResponseEntity<ImagesForMessageDto> deleteMessage(@PathVariable String idImage){
        return null;
    }

    @DeleteMapping(path = "deleteImages/{id}")
    public ResponseEntity<List<ImagesForMessageDto>> deleteMessages(@PathVariable String idMessage){
        return null;
    }
}
