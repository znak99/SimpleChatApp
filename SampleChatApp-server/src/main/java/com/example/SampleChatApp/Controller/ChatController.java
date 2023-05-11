package com.example.SampleChatApp.Controller;

import com.example.SampleChatApp.Dto.ChatRequestDto;
import com.example.SampleChatApp.Service.ChatMessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ChatController {
    private final ChatMessageService chattingService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public ChatController(ChatMessageService chattingService, SimpMessagingTemplate simpMessagingTemplate) {
        this.chattingService = chattingService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/messages")
    public void chat(@Valid ChatRequestDto chatRequestDto) {
        chattingService.save(chatRequestDto);
        simpMessagingTemplate.convertAndSend("/topic/rooms/" + chatRequestDto.getRoomId(), chatRequestDto.getMessage());
    }

    //채팅방 생성
    @PostMapping("")
    public void chatroomCreate(){

    }
    //채팅인원 목록

}
