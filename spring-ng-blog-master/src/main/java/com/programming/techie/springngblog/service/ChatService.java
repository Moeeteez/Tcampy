package com.programming.techie.springngblog.service;

import com.programming.techie.springngblog.model.ChatMessage;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.repository.ChatRepository;
import com.programming.techie.springngblog.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
/*
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendMessage(ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
    }





@Autowired
private SimpMessagingTemplate messagingTemplate;

    public void sendMessage(ChatMessage chatMessage) {
        messagingTemplate.convertAndSendToUser(chatMessage.getReciever(), "/queue/reply", chatMessage);
    }

    public void addUser(ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
    }







    @Autowired
    private ChatRepository chatMessageRepository;

    public ChatMessage save(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findBySenderAndReciever(String sender, String reciever) {
        return chatMessageRepository.findBySenderAndReciever(sender, reciever);
    }

    public List<ChatMessage> findBySenderOrReciever(String user) {
        return chatMessageRepository.findBySenderOrReciever(user, user);
    }


 */


    @Autowired
    private ChatRepository chatMessageRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ChatMessage> getAllMessages() {
        return chatMessageRepository.findAll();
    }

    public ChatMessage getMessageById(Long id) {
        return chatMessageRepository.findById(id)
                .orElseThrow(null);
    }

    public ChatMessage createMessage(String content, Long senderId, Long receiverId) {
        User sender = userRepository.findById(senderId)
                .orElseThrow(null);

        User receiver = userRepository.findById(receiverId)
                .orElseThrow(null);

        ChatMessage message = new ChatMessage();
        message.setContent(content);
        message.setSender(sender);
        message.setReceiver(receiver);
        return chatMessageRepository.save(message);
    }

    public ChatMessage updateMessage(Long id, String content, Long senderId, Long receiverId) {
        ChatMessage existingMessage = getMessageById(id);

        User sender = userRepository.findById(senderId)
                .orElse(null);

        User receiver = userRepository.findById(receiverId).orElse(null);

        existingMessage.setContent(content);
        existingMessage.setSender(sender);
        existingMessage.setReceiver(receiver);
        return chatMessageRepository.save(existingMessage);
    }

    public void deleteMessage(Long id) {
        chatMessageRepository.deleteById(id);
    }
}