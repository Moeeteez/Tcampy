package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.model.ChatMessage;
import com.programming.techie.springngblog.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody ChatMessage chatMessage) {
        chatService.sendMessage(chatMessage);
    }



}
