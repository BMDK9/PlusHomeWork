package com.example.practice.domain.postLike.controller;

import com.example.practice.domain.postLike.dto.PostLikeResponseDto;
import com.example.practice.domain.postLike.service.PostLikeService;
import com.example.practice.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{postId}/postLikes")
public class PostLikeController {

    private final PostLikeService postLikeService;

    @PatchMapping
    public PostLikeResponseDto clickPostLike(@PathVariable Long postId,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        PostLikeResponseDto responseDto = postLikeService.clickPostLike(postId, userDetails.getUser());

        return responseDto;
    }
}
