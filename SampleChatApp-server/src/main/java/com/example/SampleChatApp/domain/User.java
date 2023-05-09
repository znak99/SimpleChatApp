package com.example.SampleChatApp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;   // 로그인 이메일

    @Column
    private String nickname;    // 닉네임

    @Setter
    @Column
    private String password;    // 로그인 패스워드

    @Column
    private String chatId;  // 챗 아이디 (친구추가시 사용)

    @Column
    private Byte[] profileImage;   // 프로필 이미지

    @Column
    private Id[] friendsList;   // 유저의 친구목록

    public User(){}
    public User(String email, String nickname, String password) {
        this.email=email;
        this.nickname=nickname;
        this.password=password;
    }
}
