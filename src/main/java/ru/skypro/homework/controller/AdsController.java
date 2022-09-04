package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping(path = "/add")
    public ResponseEntity<Ads> addAds(@RequestBody CreateAdsDto createAds) {
        Ads ads = adsService.createAds(createAds);
        if (ads != null) {
            return ResponseEntity.ok(ads);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/me")
    public ResponseEntity<ResponseWrapperAds> getAllUserAds(Authentication authentication) {
        ResponseWrapperAds ads = adsService.getAllMyAds(authentication.getName());
        if (ads != null) {
            return ResponseEntity.ok(ads);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/{ad_pk}/comments")
    public ResponseEntity<ResponseWrapperAdsComment> getAllCommentsAds(@PathVariable Integer ad_pk) {
        ResponseWrapperAdsComment responseWrapperAdsComment = commentService.getAllCommentsByAdsId(ad_pk);
        if (responseWrapperAdsComment != null) {
            return ResponseEntity.ok(responseWrapperAdsComment);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    /*
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

     */

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @DeleteMapping(path = "/{ad_pk}/comments/{id}")
    public ResponseEntity deleteAdsComment(@PathVariable Integer ad_pk,
                                           @PathVariable Integer id,
                                           String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        adsService.deleteAds(id, authentication.getName());
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{ad_pk}/comments/{id}")
    public ResponseEntity<AdsCommentDto> getAdsComment(@PathVariable Integer ad_pk,
                                                       @PathVariable Integer id) {
        return ResponseEntity.ok(commentService.getAdsComment(id));
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PatchMapping(path = "/{ad_pk}/comments/{id}")
    public ResponseEntity<AdsCommentDto> updateAdsComment(@PathVariable Integer ad_pk,
                                                          @PathVariable Integer id,
                                                          @RequestBody AdsCommentDto adsCommentDto)  {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(commentService.updateAdsComment(id, adsCommentDto, authentication.getName()));
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping(path = "/{ad_pk}/comments")
    public ResponseEntity<AdsCommentDto> addAdsComment(@PathVariable Integer ad_pk,
                                                       @RequestBody AdsCommentDto adsCommentDto)  {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(commentService.createAdsComment(ad_pk, adsCommentDto));
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteAds(@PathVariable Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        adsService.deleteAds(id, authentication.getName());
        return ResponseEntity.ok().build();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<FullAdsDto> getFullAds(@PathVariable Integer id) {
        return ResponseEntity.ok(adsService.getAdsById(id));
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PatchMapping(path = "{id}")
    public ResponseEntity<AdsDTO> updateAds(@PathVariable Integer id,
                                            @RequestBody AdsDTO adsDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(adsService.updateAds(adsDTO, authentication.getName()));
    }




}