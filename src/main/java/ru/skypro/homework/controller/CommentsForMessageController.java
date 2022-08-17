package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentsForMessageDto;
import ru.skypro.homework.dto.ImagesForMessageDto;

import java.util.List;

@RequestMapping("comments")
public class CommentsForMessageController {
    @GetMapping(path = "getComment/{id}")
    public ResponseEntity<CommentsForMessageDto> getComment(@PathVariable String idComment){
        return null;
    }

    @GetMapping(path = "getComments/{id}")
    public ResponseEntity<List<CommentsForMessageDto>> getComments(@PathVariable String idMessage){
        return null;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<CommentsForMessageDto> addComment(@RequestBody CommentsForMessageDto comment){
        return null;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<CommentsForMessageDto> updateComment(@RequestBody CommentsForMessageDto comment){
        return null;
    }

    @DeleteMapping(path = "deleteComment/{id}")
    public ResponseEntity<CommentsForMessageDto> deleteComment(@PathVariable String idComment){
        return null;
    }

    @DeleteMapping(path = "deleteIComments/{id}")
    public ResponseEntity<List<ImagesForMessageDto>> deleteComments(@PathVariable String idMessage){
        return null;
    }
}
