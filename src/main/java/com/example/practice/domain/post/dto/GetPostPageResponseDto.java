package com.example.practice.domain.post.dto;

import com.example.practice.domain.post.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetPostPageResponseDto {

    private Long id;
    private String title;
    private String username;
    private String content;
    private String image;
    private Long postLikeCnt;
    private LocalDateTime createdAt;

    @Builder
    private GetPostPageResponseDto(Long id, String title, String username, String content,
                                   String image, Long postLikeCnt,LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.content = content;
        this.image = image;
        this.postLikeCnt = postLikeCnt;
        this.createdAt = createdAt;
    }

    public static GetPostPageResponseDto of(Post post) {

        return GetPostPageResponseDto.builder()
            .id(post.getId())
            .title(post.getTitle())
            .username(post.getUser().getUsername())
            .content(post.getContent())
            .image(post.getImage())
            .postLikeCnt(post.getPostLikeCnt())
            .createdAt(post.getCreatedAt())
            .build();
    }
}
