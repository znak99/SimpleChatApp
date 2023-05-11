package com.example.SampleChatApp.Repository;

import com.example.SampleChatApp.domain.Chatroom_user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomUserRepository extends JpaRepository<Chatroom_user,Long> {



}
