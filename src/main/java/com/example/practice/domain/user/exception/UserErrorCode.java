package com.example.practice.domain.user.exception;

import com.example.practice.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    ALREADY_EXSIST("이미 사용하고 있는 아이디입니다.", HttpStatus.BAD_REQUEST),
    ANOTHER_PASSWORD("다른 비밀번호를 사용해주세요.", HttpStatus.BAD_REQUEST),
    DIFFERENT_PASSWORD("입력하신 비밀번호가 다릅니다", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;
}
