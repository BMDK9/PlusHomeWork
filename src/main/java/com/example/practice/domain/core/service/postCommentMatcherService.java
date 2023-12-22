package com.example.practice.domain.core.service;

import com.example.practice.domain.comment.dto.CreateCommentRequestDto;
import com.example.practice.domain.comment.dto.CreateCommentResponseDto;
import com.example.practice.domain.comment.dto.UpdateCommentRequestDto;
import com.example.practice.domain.comment.dto.UpdateCommentResponseDto;
import com.example.practice.domain.comment.service.CommentService;
import com.example.practice.domain.post.entity.Post;
import com.example.practice.domain.post.service.PostService;
import com.example.practice.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class postCommentMatcherService {

    private final CommentService commentService;
    private final PostService postService;

    public CreateCommentResponseDto createComment(Long postId,
                                                  CreateCommentRequestDto requestDto,
                                                  UserDetailsImpl userDetails) {
        Post post = checkPost(postId);
        CreateCommentResponseDto responseDto = commentService.createComment(post, requestDto, userDetails.getUser());
        return responseDto;
    }

    public UpdateCommentResponseDto updateComment(Long postId, Long commentId,
                                                  UpdateCommentRequestDto requestDto, UserDetailsImpl userDetails) {
        Post post = checkPost(postId);
        UpdateCommentResponseDto responseDto = commentService.updateComment(commentId,
            requestDto.getCommentText(), userDetails.getUser());
        return responseDto;
    }

    public void deleteComment(Long postId, Long commentId, UserDetailsImpl userDetails) {
        Post post = checkPost(postId);
        commentService.deleteComment(post, commentId, userDetails.getUser());
    }

    private Post checkPost(Long postId) {
        Post post = postService.findById(postId);
        return post;
    }
}
