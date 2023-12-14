package com.example.practice.domain.post.controller;

import com.example.practice.domain.post.dto.CreatePostResponseDto;
import com.example.practice.domain.post.dto.CreatePostRequestDto;
import com.example.practice.domain.post.dto.GetPostResponseDto;
import com.example.practice.domain.post.service.PostService;
import com.example.practice.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public CreatePostResponseDto createPost(@RequestBody CreatePostRequestDto createPostRequestDto,
                                            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        CreatePostResponseDto responseDto = postService.createPost(createPostRequestDto, userDetails.getUser());
        return responseDto;
    }

    @GetMapping("/{postId}")
    public GetPostResponseDto getPost(@PathVariable Long postId) {
        GetPostResponseDto responseDto = postService.getPost(postId);
        return responseDto;
    }
}
