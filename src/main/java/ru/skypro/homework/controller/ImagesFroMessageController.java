package ru.skypro.homework.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.GetImageDto;
import ru.skypro.homework.dto.ImagesForMessageDto;
import ru.skypro.homework.service.AdvertImageService;

import java.util.List;


@RestController
@RequestMapping("images")
public class ImagesFroMessageController {

    private final AdvertImageService advertImageService;

    public ImagesFroMessageController(AdvertImageService advertImageService) {
        this.advertImageService = advertImageService;
    }

    @GetMapping(value = "getImage/{idImage}", produces = {MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte []> getImage(@PathVariable("idImage") Integer idImage){
        return ResponseEntity.ok().body(advertImageService.getImage(idImage));
    }

    @PostMapping(path = "{idMessage}/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Integer> addImage(@PathVariable Integer idMessage,
                                            @RequestParam MultipartFile image){
        return ResponseEntity.ok(advertImageService.saveImage(idMessage, image));
    }
}
