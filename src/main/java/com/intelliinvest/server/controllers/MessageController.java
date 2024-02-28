package com.intelliinvest.server.controllers;

import com.intelliinvest.server.entities.Message;
import com.intelliinvest.server.payloads.MessageDto;
import com.intelliinvest.server.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @PostMapping("/")
    public ResponseEntity<?> creatMessage(@RequestBody MessageDto messageDto){
        System.out.println(messageDto);
        MessageDto created=this.messageService.createMessage(messageDto);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }
}
