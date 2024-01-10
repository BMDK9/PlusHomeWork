package com.example.practice.domain.comment.controller;

import com.example.practice.domain.comment.dto.CreateCommentRequestDto;
import com.example.practice.domain.comment.dto.CreateCommentResponseDto;
import com.example.practice.domain.comment.dto.UpdateCommentRequestDto;
import com.example.practice.domain.comment.dto.UpdateCommentResponseDto;
import com.example.practice.domain.core.service.postCommentMatcherService;
import com.example.practice.global.common.CommonCode;
import com.example.practice.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {


    private final postCommentMatcherService postCommentMatcherService;

    @PostMapping
    public CreateCommentResponseDto createComment(@PathVariable Long postId,
            @RequestBody CreateCommentRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postCommentMatcherService.createComment(postId, requestDto, userDetails);
    }

    @PatchMapping("/{commentId}")
    public UpdateCommentResponseDto updateComment(@PathVariable Long postId,
            @PathVariable Long commentId,
            @RequestBody UpdateCommentRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postCommentMatcherService.updateComment(postId, commentId, requestDto, userDetails);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId,
            @PathVariable Long commentId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postCommentMatcherService.deleteComment(postId, commentId, userDetails);

        return ResponseEntity.status(CommonCode.OK.getStatusCode())
                .body(CommonCode.OK.getMessage());
    }
}
