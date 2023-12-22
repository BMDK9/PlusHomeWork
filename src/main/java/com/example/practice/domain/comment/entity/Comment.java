package com.example.practice.domain.comment.entity;

import com.example.practice.domain.post.entity.Post;
import com.example.practice.domain.user.entity.User;
import com.example.practice.domain.util.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commentText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    private Comment(Long id, String commentText, User user, Post post) {
        this.id = id;
        this.commentText = commentText;
        this.user = user;
        this.post = post;
    }

    public void update(String commentText) {
        this.commentText = commentText;
    }
}
