package com.example.practice.domain.postLike.repository;

import com.example.practice.domain.post.entity.Post;
import com.example.practice.domain.postLike.entity.PostLike;
import com.example.practice.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    Optional<PostLike> findByUserAndPost(User user, Post post);
}
