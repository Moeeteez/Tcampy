package com.programming.techie.springngblog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ChatMessage {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String content;
    private String sender;

    public ChatMessage() {
    }

    public ChatMessage(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }


}
