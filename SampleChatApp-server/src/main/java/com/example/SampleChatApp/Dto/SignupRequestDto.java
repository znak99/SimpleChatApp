package com.example.SampleChatApp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {

    // 이름
    // @NotBlank 문자열 형태의 값이 null 이 아니고 공백이 아님을 검증하는 어노테이션
    @NotBlank(message = "이름을 입력해주세요.")
    private String nickname;

    //야이디는 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)로 구성
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String email;

    // 최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;

}
