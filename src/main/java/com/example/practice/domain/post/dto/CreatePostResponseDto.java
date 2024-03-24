package com.example.practice.domain.post.dto;

import com.example.practice.domain.post.entity.Post;
import com.example.practice.global.inter.dto.ResponseDto;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePostResponseDto implements ResponseDto {

    private Long id;
    private String title;
    private String username;
    private String content;
    private String image;
    private LocalDateTime createdAt;

    @Builder
    private CreatePostResponseDto(Long id, String title, String username, String content,
            String image, LocalDateTime createdAt) {

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
