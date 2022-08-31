package ru.skypro.homework.service;

import ru.skypro.homework.dto.AdsCommentDto;
import ru.skypro.homework.dto.ResponseWrapperAdsComment;

public interface CommentService {
    AdsCommentDto getComment(Integer id);
    ResponseWrapperAdsComment getAllComments();
    ResponseWrapperAdsComment getAllCommentsByUserId(Integer userId);
    ResponseWrapperAdsComment getAllCommentsByAdsId(Integer adsIs);
}
