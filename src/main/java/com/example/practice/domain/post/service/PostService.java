package com.example.practice.domain.post.service;

import com.example.practice.domain.post.dto.CreatePostRequestDto;
import com.example.practice.domain.post.dto.CreatePostResponseDto;
import com.example.practice.domain.post.dto.GetPostResponseDto;
import com.example.practice.domain.post.entity.Post;
import com.example.practice.domain.post.exception.PostErrorCode;
import com.example.practice.domain.post.exception.PostException;
import com.example.practice.domain.post.repository.PostRepository;
import com.example.practice.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public CreatePostResponseDto createPost(CreatePostRequestDto createPostRequestDto, User user) {
        Post savePost = Post.builder()
            .title(createPostRequestDto.getTitle())
            .user(user)
            .content(createPostRequestDto.getContent())
            .build();

        postRepository.save(savePost);

        return CreatePostResponseDto.of(savePost);
    }

    public GetPostResponseDto getPost(Long postId) {
        Post post = findById(postId);
        return GetPostResponseDto.of(post);
    }

    private Post findById(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new PostException(PostErrorCode.NO_EXIST));
    }
}
