package com.example.practice.global.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CommonCode {

    OK("성공했습니다.", HttpStatus.OK),
    GOOD("사용 가능합니다.", HttpStatus.OK);

    private final String message;
    private final HttpStatus statusCode;

    CommonCode(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
