package com.programming.techie.springngblog.repository;

import com.programming.techie.springngblog.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatMessage, Long> {
/*
    List<ChatMessage> findBySenderAndReciever(String sender, String reciever);


   List<ChatMessage> findBySenderOrReciever(String sender, String reciever);

 */


}