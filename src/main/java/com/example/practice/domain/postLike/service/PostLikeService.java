package com.example.practice.domain.postLike.service;

import com.example.practice.domain.post.entity.Post;
import com.example.practice.domain.post.service.PostService;
import com.example.practice.domain.postLike.dto.PostLikeResponseDto;
import com.example.practice.domain.postLike.entity.PostLike;
import com.example.practice.domain.postLike.repository.PostLikeRepository;
import com.example.practice.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.practice.domain.postLike.constant.PostConstant.DEFAULT_POSTLIKE;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostService postService;

    @Transactional
    public PostLikeResponseDto clickPostLike(Long postId, User user) {
        Post post = postService.findById(postId);
        PostLike postLike = postLikeRepository.findByUserAndPost(user, post)
            .orElseGet(()-> savePostLike(user, post));

        boolean updated = postLike.clickPostLike();
        post.updatePostLikeCnt(updated);

        return PostLikeResponseDto.of(postLike.getIsPostLiked());
    }

    @Transactional
    public PostLike savePostLike(User user, Post post) {
        PostLike postLike = PostLike.builder()
            .user(user)
            .post(post)
            .isPostLiked(DEFAULT_POSTLIKE)
            .build();

        return postLikeRepository.save(postLike);
        }
}
