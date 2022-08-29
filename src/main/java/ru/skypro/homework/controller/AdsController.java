package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.CommentService;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping(path = "/ads")
public class AdsController {

    private final AdsService adsService;
    private final CommentService commentService;

    public AdsController(AdsService adsService, CommentService commentService) {
        this.adsService = adsService;
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapperAds> getAllAds() {

    }

    @PostMapping
    public ResponseEntity addAds(CreateAdsDto createAds) {

    }

    @GetMapping(path = "/me")
    public ResponseEntity<ResponseWrapperAds> getAllUserAds() {

    }

    @GetMapping(path = "/{ad_pk}/comments")
    public ResponseEntity<ResponseWrapperAdsComment> getAllCommentsAds() {

    }

    @PostMapping(path = "/{ad_pk}/comments")
    public ResponseEntity<AdsCommentDto> addCommentToAds(AdsCommentDto adsCommentDto) {

    }

    @DeleteMapping(path = "/{ad_pk}/comments/{id}")
    public ResponseEntity deleteAdsComemnt() {

    }

    @GetMapping(path = "/{ad_pk}/comments/{id}")
    public ResponseEntity<AdsCommentDto> getAdsComment() {

    }

    @PatchMapping(path = "/{ad_pk}/comments/{id}")
    public ResponseEntity<AdsCommentDto> updateAdsComment(AdsCommentDto) {

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteAds() {

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FullAdsDto> getFullAds() {

    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<AdsDTO> updateAds(AdsDTO adsDTO) {

    }




}