package com.example.practice.domain.user.dto;

import com.example.practice.global.common.CommonCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class CommonUserResponseDto {
    HttpStatus code;
    String message;

    @Builder
    private CommonUserResponseDto(String message, HttpStatus code) {
        this.code = code;
        this.message = message;
    }

    public static CommonUserResponseDto of(CommonCode commonCode) {
        return CommonUserResponseDto.builder()
            .message(commonCode.getMessage())
            .code(commonCode.getStatusCode())
            .build();
    }
}
