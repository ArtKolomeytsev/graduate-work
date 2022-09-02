package ru.skypro.homework.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.GetImageDto;
import ru.skypro.homework.dto.ImagesForMessageDto;
import ru.skypro.homework.service.AdvertImageService;

import java.util.List;


@RequestMapping("images")
public class ImagesFroMessageController {

    private final AdvertImageService advertImageService;

    public ImagesFroMessageController(AdvertImageService advertImageService) {
        this.advertImageService = advertImageService;
    }

    @GetMapping(path = "getImage/{id}")
    public ResponseEntity<GetImageDto> getImage(@PathVariable Integer idImage){
        return ResponseEntity.ok(advertImageService.getImage(idImage));
    }

    @PostMapping(path = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Integer> addImage(@RequestParam MultipartFile image){
        return ResponseEntity.ok(advertImageService.saveImage(image));
    }
}
