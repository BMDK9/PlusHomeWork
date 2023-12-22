package com.example.practice.domain.scheduler;

import com.example.practice.domain.comment.entity.Comment;
import com.example.practice.domain.comment.repository.CommentRepository;
import com.example.practice.domain.post.entity.Post;
import com.example.practice.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Component
@Slf4j(topic = "스케줄러")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Scheduler {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    @Scheduled(cron = "0 0 5 * * *") // 매일 오전 5시 마다
    public void autoDelete() {
        LocalDateTime now = LocalDateTime.now();

        List<Post> postList = postRepository.findAll();
        List<Comment> commentList = commentRepository.findAll();

        for (Post p : postList) {
            if (p.getModifiedAt().isBefore(now.minusDays(90))) {
                postRepository.delete(p);
            }
        }

        for (Comment c : commentList) {
            if (c.getModifiedAt().isBefore(now.minusDays(90))) {
                commentRepository.delete(c);
            }
        }
    }
}
