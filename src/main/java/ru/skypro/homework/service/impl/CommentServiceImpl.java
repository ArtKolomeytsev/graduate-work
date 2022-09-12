package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdsCommentDto;
import ru.skypro.homework.dto.ResponseWrapperAdsComment;
import ru.skypro.homework.entities.Ads;
import ru.skypro.homework.entities.AdsComments;
import ru.skypro.homework.entities.Users;
import ru.skypro.homework.exceprion.AdvertNotFoundException;
import ru.skypro.homework.exceprion.CommentNotFoundException;
import ru.skypro.homework.exceprion.UserNotFoundException;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repo.AdsCommentRepo;
import ru.skypro.homework.repo.AdsRepo;
import ru.skypro.homework.repo.UserRepo;
import ru.skypro.homework.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final AdsCommentRepo adsCommentRepo;
    private final AdsRepo adsRepo;
    private final UserRepo userRepo;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(AdsCommentRepo adsCommentRepo, AdsRepo adsRepo, UserRepo userRepo, CommentMapper commentMapper) {
        this.adsCommentRepo = adsCommentRepo;
        this.adsRepo = adsRepo;
        this.userRepo = userRepo;
        this.commentMapper = commentMapper;
    }

    @Override
    public ResponseWrapperAdsComment getAllCommentsByAdsId(Integer id) {
        ResponseWrapperAdsComment responseWrapperAdsComment = new ResponseWrapperAdsComment();
        List<AdsCommentDto> adsCommentDtos =
                commentMapper.commentEntitiesToDtoList(adsCommentRepo.findAllByMessagesMessIdOrderByDateTimeDesc(id));
        responseWrapperAdsComment.setCount(adsCommentDtos.size());
        responseWrapperAdsComment.setResult(adsCommentDtos);
        return responseWrapperAdsComment;
    }

    @Override
    public void deleteAdsComment(Integer commentId, String username) {
        Users user = userRepo.findUsersByUsername(username).orElseThrow(UserNotFoundException::new);
        AdsComments adsComments = adsCommentRepo.findById(commentId).orElseThrow(CommentNotFoundException::new);
        if (username.equals(user.getUsername())) {
            adsCommentRepo.delete(adsComments);
        }
    }

    @Override
    public AdsCommentDto getAdsComment(Integer commentId) {
        AdsComments adsComments = adsCommentRepo.findById(commentId).orElseThrow(CommentNotFoundException::new);
        return commentMapper.EntityToDto(adsComments);
    }

    @Override
    public AdsCommentDto updateAdsComment(Integer commentId, AdsCommentDto adsCommentDto, String username) {
        AdsComments adsComments = adsCommentRepo.findById(commentId).orElseThrow(CommentNotFoundException::new);
        Users user = userRepo.findUsersByUsername(username).orElseThrow(UserNotFoundException::new);
        if (username.equals(user.getUsername())) {
            adsComments.setDateTime(adsCommentDto.getDateTime());
            adsCommentDto.setText(adsCommentDto.getText());
            adsCommentRepo.save(adsComments);
        }
        return adsCommentDto;
    }

    @Override
    public AdsCommentDto createAdsComment(Integer adsId, AdsCommentDto adsCommentDto) {
        AdsComments adsComments = commentMapper.DtoToEntity(adsCommentDto);
        adsComments.setUser(userRepo.findById(adsCommentDto.getAuthor()).orElseThrow(UserNotFoundException::new));
        adsComments.setMessages(adsRepo.findById(adsId).orElseThrow(AdvertNotFoundException::new));
        adsCommentRepo.save(adsComments);
        return adsCommentDto;
    }
}
