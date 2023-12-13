package com.example.practice.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CheckNameRequestDto {

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z]{3,}$", message = "숫자와 영문자를 이용해 최소 3자 이상으로 작성해주세요.")
    private String username;
}
