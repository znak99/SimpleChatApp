package com.example.SampleChatApp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Chatroom_user {
    @Id
    private Long id;

    @ManyToOne
    private Chatroom chatroom;

    @ManyToOne
    private User user;
}
