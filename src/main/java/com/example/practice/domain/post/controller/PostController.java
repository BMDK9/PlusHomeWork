package com.example.practice.domain.post.controller;

import com.example.practice.domain.post.dto.*;
import com.example.practice.domain.post.service.PostService;
import com.example.practice.global.common.CommonCode;
import com.example.practice.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public GetPostResponseDto getPost(Pageable pageable,
                                      @PathVariable Long postId,
                                      @AuthenticationPrincipal UserDetailsImpl userDetails) {
        GetPostResponseDto responseDto = postService.getPost(pageable, postId, userDetails.getUser());
        return responseDto;
    }

    @GetMapping
    public List<GetPostPageResponseDto> getPostPage(Pageable pageable,
                                                    @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.getPostPage(pageable, userDetails.getUser());
    }

    @PatchMapping("/{postId}")
    public UpdatePostResponseDto updatePost(@PathVariable Long postId,
                                            @RequestBody UpdatePostRequestDto requestDto,
                                            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        UpdatePostResponseDto responseDto = postService.updatePost(postId, requestDto, userDetails.getUser());
        return responseDto;
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.delete(postId, userDetails);
        return ResponseEntity.status(CommonCode.OK.getStatusCode()).body(CommonCode.OK.getMessage());
    }
}
