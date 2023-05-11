package com.example.SampleChatApp.Repository;

import com.example.SampleChatApp.domain.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {
}
