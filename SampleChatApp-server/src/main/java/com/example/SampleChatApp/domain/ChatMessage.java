package com.example.SampleChatApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChatMessage {
    @Id
    private Long id;

    @Column
    private String massage; //채팅 내용

    @ManyToOne
    private Chatroom chatroom;

    @ManyToOne
    private User user;



}
