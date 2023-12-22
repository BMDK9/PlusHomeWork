package com.example.practice.domain.post.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdatePostRequestDto {

    @Size(max = 500)
    private String title;

    @Size(max = 5000)
    private String content;

    private String img;
}
