package com.example.practice.domain.user.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class SignupRequestDto {

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z]{3,}$", message = "숫자와 영문자를 이용해 최소 3자 이상으로 작성해주세요.")
    private String username;

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z]{4,}$", message = "숫자와 영문자를 이용해 최소 4자 이상으로 작성해주세요")
    private String password;
}
