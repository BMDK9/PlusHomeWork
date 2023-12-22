package com.example.practice.domain.postLike.entity;

import com.example.practice.domain.post.entity.Post;
import com.example.practice.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isPostLiked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    private PostLike(Long id, Boolean isPostLiked, User user, Post post) {
        this.id = id;
        this.isPostLiked = isPostLiked;
        this.user = user;
        this.post = post;
    }

    public Boolean clickPostLike() {
        this.isPostLiked = !isPostLiked;
        return this.isPostLiked;
    }
}
