package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Ads;
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
        ResponseWrapperAds ads = adsService.getAllAds();
        if (ads != null) {
            return ResponseEntity.ok(ads);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping(path = "/add")
    public ResponseEntity<Ads> addAds(@RequestBody CreateAdsDto createAds) {
        Ads ads = adsService.createAds(createAds);
        if (ads != null) {
            return ResponseEntity.ok(ads);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/me")
    public ResponseEntity<ResponseWrapperAds> getAllUserAds(Authentication authentication) {
        ResponseWrapperAds ads = adsService.getAllMyAds(authentication.getName());
        if (ads != null) {
            return ResponseEntity.ok(ads);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/{ad_pk}/comments")
    public ResponseEntity<AdsCommentDto> getAllCommentsAds(@PathVariable Integer ad_pk) {
        AdsCommentDto ads = commentService.getComment(ad_pk);
        if (ads != null) {
            return ResponseEntity.ok(ads);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/{message}/comments")
    public ResponseEntity<ResponseWrapperAdsComment> getAllCommentsByAdsId(@PathVariable Integer message) {
        ResponseWrapperAdsComment ads = commentService.getAllCommentsByAdsId(message);
        if (ads != null) {
            return ResponseEntity.ok(ads);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/{user}/comments")
    public ResponseEntity<ResponseWrapperAdsComment> getAllCommentsByUserId(@PathVariable Integer user) {
        ResponseWrapperAdsComment ads = commentService.getAllCommentsByUserId(user);
        if (ads != null) {
            return ResponseEntity.ok(ads);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
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