package com.example.practice.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    @NotBlank
    String username;

    @NotBlank
    String password;
}
