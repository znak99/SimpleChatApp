package com.example.SampleChatApp.Controller;

import com.example.SampleChatApp.Dto.SignupRequestDto;
import com.example.SampleChatApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원가입
    @PostMapping("/api/signup")
    public ResponseEntity<String> registerUser(@RequestBody @Valid SignupRequestDto signupRequestDto, Errors errors){
        //유효성검사 실패했을시
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors(); // 모든 오류 정보 가져오기
            String errors1 = null;
            for (ObjectError error : errorList) {
                errors1 = error.getDefaultMessage();
            }
            return new ResponseEntity(errors1,HttpStatus.valueOf(403));
        }

        try {
            userService.registerUser(signupRequestDto);
        }catch (Exception e){
            return new ResponseEntity(e,HttpStatus.valueOf(403));
        }

        //성공시
        return  ResponseEntity.ok("회원가입 성공");


    }

    //패스워드 찾기
    @GetMapping("/api/reset-password")
    public String FindPassword(){
        return null;
    }


}
