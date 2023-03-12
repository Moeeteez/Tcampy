package com.programming.techie.springngblog.service;

import com.programming.techie.springngblog.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendMessage(ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
    }

}