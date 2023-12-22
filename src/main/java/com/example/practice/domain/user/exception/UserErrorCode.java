package com.example.practice.domain.user.exception;

import com.example.practice.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    ALREADY_EXSIST("중복된 닉네임입니다.", HttpStatus.BAD_REQUEST),
    ANOTHER_PASSWORD("닉네임이 포함되지 않은 비밀번호를 사용해주세요.", HttpStatus.BAD_REQUEST),
    DIFFERENT_PASSWORD("입력하신 비밀번호가 다릅니다", HttpStatus.BAD_REQUEST),
    WRONG_LOGIN("닉네임 또는 패스워드를 확인해주세요", HttpStatus.FORBIDDEN);

    private final String message;
    private final HttpStatus httpStatus;
}
