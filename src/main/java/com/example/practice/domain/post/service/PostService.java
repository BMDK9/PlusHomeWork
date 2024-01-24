package com.example.practice.domain.post.service;

import static com.example.practice.domain.post.constant.PostConstant.DEFAULT_IMG;
import static com.example.practice.domain.post.constant.PostConstant.DEFAULT_POST_LIKE_CNT;
import static com.example.practice.domain.postLike.constant.PostConstant.DEFAULT_POSTLIKE;

import com.example.practice.domain.comment.dto.CommentResponseDto;
import com.example.practice.domain.comment.service.CommentService;
import com.example.practice.domain.post.dto.CreatePostRequestDto;
import com.example.practice.domain.post.dto.CreatePostResponseDto;
import com.example.practice.domain.post.dto.GetPostPageResponseDto;
import com.example.practice.domain.post.dto.GetPostResponseDto;
import com.example.practice.domain.post.dto.UpdatePostRequestDto;
import com.example.practice.domain.post.dto.UpdatePostResponseDto;
import com.example.practice.domain.post.entity.Post;
import com.example.practice.domain.post.exception.PostErrorCode;
import com.example.practice.domain.post.exception.PostException;
import com.example.practice.domain.post.repository.PostRepository;
import com.example.practice.domain.postLike.entity.PostLike;
import com.example.practice.domain.user.entity.User;
import com.example.practice.global.security.UserDetailsImpl;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final CommentService commentService;

    @Transactional
    public CreatePostResponseDto createPost(CreatePostRequestDto createPostRequestDto, User user) {

        Post savePost;

        if (createPostRequestDto.getImage() != null) {

            savePost = Post.builder()
                    .title(createPostRequestDto.getTitle())
                    .user(user)
                    .content(createPostRequestDto.getContent())
                    .image(createPostRequestDto.getImage())
                    .postLikeCnt(DEFAULT_POST_LIKE_CNT)
                    .build();

            postRepository.save(savePost);

            return CreatePostResponseDto.of(savePost);
        }

        savePost = Post.builder()
                .title(createPostRequestDto.getTitle())
                .user(user)
                .content(createPostRequestDto.getContent())
                .image(DEFAULT_IMG)
                .postLikeCnt(DEFAULT_POST_LIKE_CNT)
                .build();

        postRepository.save(savePost);

        return CreatePostResponseDto.of(savePost);
    }

    public GetPostResponseDto getPost(Pageable pageable, Long postId, User user) {
        Post post = findById(postId);
        Page<CommentResponseDto> commentPage = commentService.getCommentPage(post, pageable);
        Boolean isPostLiked = getPostLiked(user, post);

        return GetPostResponseDto.of(post, isPostLiked, commentPage);
    }

    //    public List<GetPostPageResponseDto> getPostPage(Pageable pageable, User user) {
//        return postRepository.findAllBy(pageable).stream().map(GetPostPageResponseDto::of).toList();
//    }
    public Page<GetPostPageResponseDto> getPostPage(Pageable pageable, User user) {
        Page<Post> allPost = postRepository.findAllBy(pageable);
        List<GetPostPageResponseDto> resList = new ArrayList<>();

        for (Post post : allPost) {
            GetPostPageResponseDto res = GetPostPageResponseDto.of(post);
            resList.add(res);
        }

        return new PageImpl<>(resList, pageable, allPost.getTotalElements());
    }

    private static Boolean getPostLiked(User user, Post post) {
        return post.getPostLikesList().stream()
                .filter(postLike -> postLike.getUser().getId().equals(user.getId()))
                .findFirst()
                .map(PostLike::getIsPostLiked)
                .orElse(DEFAULT_POSTLIKE);
    }

    @Transactional
    public UpdatePostResponseDto updatePost(Long postId, UpdatePostRequestDto requestDto,
            User user) {
        Post post = findById(postId);
        checkAuthority(user, post);
        post.update(requestDto);

        return UpdatePostResponseDto.of(post);
    }

    @Transactional
    public void delete(Long postId, UserDetailsImpl userDetails) {
        Post post = findById(postId);
        checkAuthority(userDetails.getUser(), post);
        postRepository.delete(post);
    }

    public Post findById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostException(PostErrorCode.NO_EXIST));
    }

    private void checkAuthority(User user, Post post) {
        if (!post.getUser().getId().equals(user.getId())) {
            throw new PostException(PostErrorCode.NO_AUTHORITY);
        }
    }
}
