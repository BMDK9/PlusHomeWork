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

    private Long id;
    private String title;
    private String username;
    private String content;
    private String image;
    private LocalDateTime createdAt;

    @Builder
    private CreatePostResponseDto(Long id, String title, String username, String content, String image,LocalDateTime createdAt) {

        this.id = id;
        this.title = title;
        this.username = username;
        this.content = content;
        this.image = image;
        this.createdAt = createdAt;
    }

    public static CreatePostResponseDto of(Post post) {
        return CreatePostResponseDto.builder()
            .id(post.getId())
            .title(post.getTitle())
            .username(post.getUser().getUsername())
            .content(post.getContent())
            .image(post.getImage())
            .createdAt(post.getCreatedAt())
            .build();
    }

}
