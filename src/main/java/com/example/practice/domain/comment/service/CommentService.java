package com.example.practice.domain.comment.service;

import com.example.practice.domain.comment.dto.CommentResponseDto;
import com.example.practice.domain.comment.dto.CreateCommentRequestDto;
import com.example.practice.domain.comment.dto.CreateCommentResponseDto;
import com.example.practice.domain.comment.dto.UpdateCommentResponseDto;
import com.example.practice.domain.comment.entity.Comment;
import com.example.practice.domain.comment.exception.CommentErrorCode;
import com.example.practice.domain.comment.exception.CommentException;
import com.example.practice.domain.comment.repository.CommentRepository;
import com.example.practice.domain.post.entity.Post;
import com.example.practice.domain.user.entity.User;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public CreateCommentResponseDto createComment(Post post, CreateCommentRequestDto requestDto, User user) {

        Comment saveComment = Comment.builder()
                .commentText(requestDto.getCommentText())
                .user(user)
                .post(post)
                .build();

        commentRepository.save(saveComment);

        return CreateCommentResponseDto.of(saveComment);
    }

    public Page<CommentResponseDto> getCommentPage(Post post, Pageable pageable) {
        Page<Comment> commentPage = commentRepository.findAllByPostId(post.getId(), pageable);
        List<CommentResponseDto> responseDtoList = new ArrayList<>();

        for (Comment comment : commentPage) {
            CommentResponseDto res = CommentResponseDto.of(comment);
            responseDtoList.add(res);
        }

        return new PageImpl<>(responseDtoList, pageable, commentPage.getTotalElements());
    }

    @Transactional
    public UpdateCommentResponseDto updateComment(Long commentId, String commentText, User user) {

        Comment comment = checkComment(commentId);
        checkAuthority(comment, user);

        comment.update(commentText);

        return UpdateCommentResponseDto.of(comment);
    }

    @Transactional
    public void deleteComment(Post post, Long commentId, User user) {

        Comment comment = checkComment(commentId);
        if (post.getUser().getId().equals(user.getId()) || comment.getUser().getId().equals(user.getId())) {
            commentRepository.delete(comment);
        } else {
            throw new CommentException(CommentErrorCode.NO_AUTHORITY);
        }
    }

    private void checkAuthority(Comment comment, User user) {
        if (!comment.getUser().getId().equals(user.getId())) {
            throw new CommentException(CommentErrorCode.NO_AUTHORITY);
        }
    }

    public Comment checkComment(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new CommentException(CommentErrorCode.NO_EXIST));
    }
}
