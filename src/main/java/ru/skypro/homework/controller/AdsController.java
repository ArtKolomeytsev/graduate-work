package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.service.impl.AdsServiceImpl;
import ru.skypro.homework.service.impl.CommentServiceImpl;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads")
public class AdsController {

    private final AdsServiceImpl adsService;
    private final CommentServiceImpl commentService;

    public AdsController(AdsServiceImpl adsService, CommentServiceImpl commentService) {
        this.adsService = adsService;
        this.commentService = commentService;

    }


    @GetMapping
    public ResponseEntity<ResponseWrapperAds> getAllAds() {
        ResponseEntity<ResponseWrapperAds> response = ResponseEntity.ok(adsService.getAllAds());
        return response;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FullAds> getAdsById(@PathVariable Integer id) {
        ResponseEntity<FullAds> response = ResponseEntity.ok(adsService.getAdsById(id));
        return response;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<FullAds> addAds(CreateAds createAds) {
        ResponseEntity<FullAds> response = ResponseEntity.ok(adsService.createAds(createAds));
        return response;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<FullAds> updateAds(CreateAds updateAds) {
        ResponseEntity<FullAds> response = ResponseEntity.ok(adsService.createAds(updateAds));
        return response;
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<FullAds> deleteByIdAds(@PathVariable Integer id) {
        ResponseEntity<FullAds> response = ResponseEntity.ok(adsService.deleteAdsById(id));
        return response;
    }

    @GetMapping(path = "/me/{username}")
    public ResponseEntity<ResponseWrapperAds> getAllUserAds(@PathVariable String username) {
        ResponseEntity<ResponseWrapperAds> response = ResponseEntity.ok(adsService.getAllMyAds(username));
        return response;

    }

    @GetMapping(path = "/{ad_pk}/comments")
    public ResponseEntity<ResponseWrapperAdsComment> getAllCommentsAds() {
        return null;
    }

    @PostMapping(path = "/{ad_pk}/comments")
    public ResponseEntity<AdsCommentDto> addCommentToAds(AdsCommentDto adsCommentDto) {
        return null;
    }

    @DeleteMapping(path = "/{ad_pk}/comments/{id}")
    public ResponseEntity deleteAdsComemnt() {
        return null;
    }

    @GetMapping(path = "/{ad_pk}/comments/{id}")
    public ResponseEntity<AdsCommentDto> getAdsComment() {
        return null;
    }

    @PatchMapping(path = "/{ad_pk}/comments/{id}")
    public ResponseEntity<AdsCommentDto> updateAdsComment(AdsCommentDto adsCommentDto) {
        return null;
    }
}