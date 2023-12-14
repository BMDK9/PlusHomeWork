package com.example.practice.domain.post.dto;

import com.example.practice.domain.post.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePostResponseDto {

    private String title;
    private String username;
    private String content;
    private LocalDateTime createdAt;

    @Builder
    private CreatePostResponseDto(String title, String username, String content, LocalDateTime createdAt) {
        this.title = title;
        this.username = username;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static CreatePostResponseDto of(Post post) {
        return CreatePostResponseDto.builder()
            .title(post.getTitle())
            .username(post.getUser().getUsername())
            .content(post.getContent())
            .createdAt(post.getCreatedAt())
            .build();
    }

}
