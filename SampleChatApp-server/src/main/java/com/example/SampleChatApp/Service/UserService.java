package com.example.SampleChatApp.Service;

import com.example.SampleChatApp.Dto.PasswordRequestDto;
import com.example.SampleChatApp.Dto.SignupRequestDto;
import com.example.SampleChatApp.Repository.UserRepository;
import com.example.SampleChatApp.domain.User;
import com.example.SampleChatApp.mail.EmailServiceImpl;
import com.example.SampleChatApp.Dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailServiceImpl emailService;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, EmailServiceImpl emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
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

    //패스워드 초기화를 위한 본인인증 - 메일
    public int checkMail(MailDto mailDto) throws MessagingException {
        Random random = new Random();
        int num = random.nextInt(100);
        mailDto.setSubject("chatApp 본인인증");
        mailDto.setContent("본인인증을 위한 숫자입니다. --"+num);

        emailService.sendMail(mailDto);

        return num;
    }

    public String resetPassword(PasswordRequestDto passwordRequestDto) {
        User user = userRepository.findByEmail(passwordRequestDto.getEmail()).
                orElseThrow(()->new RuntimeException("해당 아이디가 존재하지 않습니다."));
        user.setPassword(passwordRequestDto.getPassword());


        userRepository.save(user);
        return "비밀번호 변경 성공";
    }
}
