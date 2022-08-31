package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdsCommentDto;
import ru.skypro.homework.dto.ResponseWrapperAdsComment;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repo.AdsCommentRepo;
import ru.skypro.homework.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final AdsCommentRepo commentRepo;
    private final AdsMapper adsMapper;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(AdsCommentRepo commentRepo, AdsMapper adsMapper,CommentMapper commentMapper) {
        this.commentRepo = commentRepo;
        this.commentMapper = commentMapper;
        this.adsMapper = adsMapper;
    }


    @Override
    public AdsCommentDto getComment(Integer id) {
        AdsCommentDto adsComments =  commentMapper.EntityToDto(commentRepo.findAdsCommentsByIdComment(id));
        return adsComments;
    }

    @Override
    public ResponseWrapperAdsComment getAllComments() {
        List<AdsCommentDto> adsComments =  commentMapper.commentEntitiesToDtoList(commentRepo.findAll());
        ResponseWrapperAdsComment responseWrapperAdsComment = new ResponseWrapperAdsComment();
        responseWrapperAdsComment.setCount(adsComments.size());
        responseWrapperAdsComment.setResult(adsComments);
        return responseWrapperAdsComment;
    }

    @Override
    public ResponseWrapperAdsComment getAllCommentsByUserId(Integer userId) {
        List<AdsCommentDto> adsComments =  commentMapper.commentEntitiesToDtoList(commentRepo.findAdsCommentsByUser(userId));
        ResponseWrapperAdsComment responseWrapperAdsComment = new ResponseWrapperAdsComment();
        responseWrapperAdsComment.setCount(adsComments.size());
        responseWrapperAdsComment.setResult(adsComments);
        return responseWrapperAdsComment;
    }

    @Override
    public ResponseWrapperAdsComment getAllCommentsByAdsId(Integer adsIs) {
        List<AdsCommentDto> adsComments =  commentMapper.commentEntitiesToDtoList(commentRepo.findAdsCommentsByMessages(adsIs));
        ResponseWrapperAdsComment responseWrapperAdsComment = new ResponseWrapperAdsComment();
        responseWrapperAdsComment.setCount(adsComments.size());
        responseWrapperAdsComment.setResult(adsComments);
        return responseWrapperAdsComment;
    }
}
