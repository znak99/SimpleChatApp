package com.example.SampleChatApp.domain;

import lombok.Getter;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Chatroom {

    @Id
    private Long id;

    @Column
    private String roomName; // 채팅방 이름

    @OneToMany
    private List<ChatMessage> message;  // 채팅방 메시지

    @OneToMany
    private List<Chatroom_user> chatroomUsers; // 채팅방 인원
}
