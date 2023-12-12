package com.example.practice.global.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class CommonResponseDto {
    String message;
    HttpStatus statusCode;

}