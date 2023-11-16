package com.study.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class MemberRequest {

    private Long id;                // 회원 번호 (PK)
    private String loginId;         // 로그인 ID
    private String password;        // 비밀번호
    private String nickName;		// 닉네임
    private String name;            // 이름
    private Gender gender;          // 성별
    private LocalDate birthday;     // 생년월일

    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (StringUtils.isEmpty(password)) {
            return;
        }
        password = passwordEncoder.encode(password);
    }

}