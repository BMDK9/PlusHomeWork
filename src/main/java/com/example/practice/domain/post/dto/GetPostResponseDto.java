package com.example.practice.domain.post.dto;

import com.example.practice.domain.comment.dto.CommentResponseDto;
import com.example.practice.domain.post.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetPostResponseDto {

    private Long id;
    private String title;
    private String username;
    private String content;
    private String image;
    private Long postLikeCnt;
    private Boolean isPostLiked;
    private LocalDateTime createdAt;
    private List<CommentResponseDto> commentPage;


    @Builder
    private GetPostResponseDto(Long id, String title, String username, String content,
                               String image, Long postLikeCnt, Boolean isPostLiked,
                               LocalDateTime createdAt, List<CommentResponseDto> commentPage) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.content = content;
        this.image = image;
        this.postLikeCnt = postLikeCnt;
        this.isPostLiked = isPostLiked;
        this.createdAt = createdAt;
        this.commentPage = commentPage;
    }

    public static GetPostResponseDto of(Post post, Boolean isPostLiked, List<CommentResponseDto> commentPage) {
        return GetPostResponseDto.builder()
            .id(post.getId())
            .title(post.getTitle())
            .username(post.getUser().getUsername())
            .content(post.getContent())
            .image(post.getImage())
            .postLikeCnt(post.getPostLikeCnt())
            .isPostLiked(isPostLiked)
            .createdAt(post.getCreatedAt())
            .commentPage(commentPage)
            .build();
    }
}
