package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.MessageDto;

@RestController
@RequestMapping("message")
public class MessageController {

    @GetMapping(path = "get/{id}")
    public ResponseEntity<MessageDto> getMessage(@PathVariable String idMessage){
        return null;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<MessageDto> addMessage(@RequestBody MessageDto message){
        return null;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<MessageDto> updateMessage(@RequestBody MessageDto message){
        return null;
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<MessageDto> deleteMessage(@PathVariable String idMessage){
        return null;
    }

}
