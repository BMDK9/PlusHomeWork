package com.example.practice.domain.post.entity;

import com.example.practice.domain.comment.entity.Comment;
import com.example.practice.domain.post.dto.UpdatePostRequestDto;
import com.example.practice.domain.postLike.entity.PostLike;
import com.example.practice.domain.user.entity.User;
import com.example.practice.domain.util.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String image;

    private Long postLikeCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    List<PostLike> postLikesList;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    List<Comment> commentList;

    @Builder
    private Post(Long id, String title, User user, String content, String image, Long postLikeCnt) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.content = content;
        this.image = image;
        this.postLikeCnt = postLikeCnt;
    }

    public void update(UpdatePostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.image = requestDto.getImg();
    }

    public void updatePostLikeCnt(boolean updatePostLike) {
        if (updatePostLike) {
            this.postLikeCnt++;
            return;
        }
        this.postLikeCnt--;
    }
}
