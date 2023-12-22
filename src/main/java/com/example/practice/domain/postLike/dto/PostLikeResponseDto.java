package com.example.practice.domain.postLike.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostLikeResponseDto {

    private Boolean isPostLiked;

    @Builder
    private PostLikeResponseDto(Boolean isPostLiked) {
        this.isPostLiked = isPostLiked;
    }

    public static PostLikeResponseDto of(Boolean isPostLiked) {
        return PostLikeResponseDto.builder()
            .isPostLiked(isPostLiked)
            .build();
    }
}
