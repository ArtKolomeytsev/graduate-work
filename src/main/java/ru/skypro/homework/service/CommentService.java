package ru.skypro.homework.service;

import ru.skypro.homework.dto.AdsCommentDto;
import ru.skypro.homework.dto.ResponseWrapperAdsComment;

public interface CommentService {

    public ResponseWrapperAdsComment getAllCommentsByAdsId(Integer id);

    public void deleteAdsComment(Integer commentId, String username);

    public AdsCommentDto getAdsComment(Integer commentId);

    public AdsCommentDto updateAdsComment(Integer commentId, AdsCommentDto adsCommentDto, String username);

    public AdsCommentDto createAdsComment(Integer adsId, AdsCommentDto adsCommentDto);

}
