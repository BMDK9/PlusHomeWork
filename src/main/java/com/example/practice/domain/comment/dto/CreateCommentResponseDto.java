package com.example.practice.domain.comment.dto;

import com.example.practice.domain.comment.entity.Comment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateCommentResponseDto {

    private Long id;
    private String username;
    private String commentText;

    @Builder
    private CreateCommentResponseDto(Long id, String username, String commentText) {
        this.id = id;
        this.username = username;
        this.commentText = commentText;
    }

    public static CreateCommentResponseDto of(Comment comment) {

        return CreateCommentResponseDto.builder()
            .id(comment.getId())
            .username(comment.getUser().getUsername())
            .commentText(comment.getCommentText())
            .build();
    }
}
