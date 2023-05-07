package com.example.SampleChatApp.Service;

import com.example.SampleChatApp.Dto.SignupRequestDto;
import com.example.SampleChatApp.Repository.UserRepository;
import com.example.SampleChatApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUser(SignupRequestDto signupRequestDto) {
        // 회원 ID 중복 확인
        String email = signupRequestDto.getEmail();
        Optional<User> found = userRepository.findByEmail(email);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        String nickname = signupRequestDto.getNickname();

        // 패스워드 암호화
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = new User(email,nickname,password);
        userRepository.save(user);
    }
}
