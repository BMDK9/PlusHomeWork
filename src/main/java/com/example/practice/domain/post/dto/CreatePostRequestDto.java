package com.example.practice.domain.post.dto;

import com.example.practice.global.inter.dto.RequestDto;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreatePostRequestDto implements RequestDto {

    @Size(max = 500)
    private String title;

    @Size(max = 5000)
    private String content;

    private String image;
}