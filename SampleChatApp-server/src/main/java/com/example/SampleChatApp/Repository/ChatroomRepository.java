package com.example.SampleChatApp.Repository;

import com.example.SampleChatApp.domain.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomRepository extends JpaRepository<Chatroom,Long> {
}
