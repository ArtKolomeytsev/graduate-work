package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.CommentService;
import ru.skypro.homework.service.impl.AdsServiceImpl;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping(path = "/ads")
public class AdsController {

    private final AdsServiceImpl adsService;
    private final CommentService commentService;

    public AdsController(AdsServiceImpl adsService, CommentService commentService) {
        this.adsService = adsService;
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapperAds> getAllAds() {
        return null;
    }

    @PostMapping
    public ResponseEntity addAds(CreateAdsDto createAds) {
        return null;
    }

    @GetMapping(path = "/me")
    public ResponseEntity<ResponseWrapperAds> getAllUserAds() {
        return null;
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
    public ResponseEntity<AdsCommentDto> updateAdsComment(AdsCommentDto adsCommentDto)  {
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteAds() {
        return null;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FullAdsDto> getFullAds() {
        return null;
    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<AdsDTO> updateAds(AdsDTO adsDTO) {
        return null;
    }




}