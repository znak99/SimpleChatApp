package com.example.SampleChatApp.Service;

import com.example.SampleChatApp.Dto.ChatRequestDto;
import com.example.SampleChatApp.Repository.ChatMessageRepository;
import com.example.SampleChatApp.Repository.ChatroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatroomRepository chatroomRepository;

    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository, ChatroomRepository chatroomRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.chatroomRepository = chatroomRepository;
    }


    public void save(ChatRequestDto chatRequestDto) {

    }
}
