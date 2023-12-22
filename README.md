# PlusHomeWork

## API
https://documenter.getpostman.com/view/30903657/2s9Ykraed1

## Directory
```bash
├─build
│  │  resolvedMainClassName
│  │
│  ├─classes
│  │  └─java
│  │      ├─main
│  │      │  └─com
│  │      │      └─example
│  │      │          └─practice
│  │      │              │  PracticeApplication.class
│  │      │              │
│  │      │              ├─domain
│  │      │              │  ├─comment
│  │      │              │  │  ├─controller
│  │      │              │  │  │      CommentController.class
│  │      │              │  │  │
│  │      │              │  │  ├─dto
│  │      │              │  │  │      CommentResponseDto$CommentResponseDtoBuilder.class
│  │      │              │  │  │      CommentResponseDto.class
│  │      │              │  │  │      CreateCommentRequestDto.class
│  │      │              │  │  │      CreateCommentResponseDto$CreateCommentResponseDtoBuilder.class
│  │      │              │  │  │      CreateCommentResponseDto.class
│  │      │              │  │  │      UpdateCommentRequestDto.class
│  │      │              │  │  │      UpdateCommentResponseDto$UpdateCommentResponseDtoBuilder.class
│  │      │              │  │  │      UpdateCommentResponseDto.class
│  │      │              │  │  │
│  │      │              │  │  ├─entity
│  │      │              │  │  │      Comment$CommentBuilder.class
│  │      │              │  │  │      Comment.class
│  │      │              │  │  │
│  │      │              │  │  ├─exception
│  │      │              │  │  │      CommentErrorCode.class
│  │      │              │  │  │      CommentException.class
│  │      │              │  │  │
│  │      │              │  │  ├─repository
│  │      │              │  │  │      CommentRepository.class
│  │      │              │  │  │
│  │      │              │  │  └─service
│  │      │              │  │          CommentService.class
│  │      │              │  │
│  │      │              │  ├─core
│  │      │              │  │  └─service
│  │      │              │  │          postCommentMatcherService.class
│  │      │              │  │
│  │      │              │  ├─post
│  │      │              │  │  ├─constant
│  │      │              │  │  │      PostConstant.class
│  │      │              │  │  │
│  │      │              │  │  ├─controller
│  │      │              │  │  │      PostController.class
│  │      │              │  │  │
│  │      │              │  │  ├─dto
│  │      │              │  │  │      CreatePostRequestDto.class
│  │      │              │  │  │      CreatePostResponseDto$CreatePostResponseDtoBuilder.class
│  │      │              │  │  │      CreatePostResponseDto.class
│  │      │              │  │  │      GetPostPageResponseDto$GetPostPageResponseDtoBuilder.class
│  │      │              │  │  │      GetPostPageResponseDto.class
│  │      │              │  │  │      GetPostResponseDto$GetPostResponseDtoBuilder.class
│  │      │              │  │  │      GetPostResponseDto.class
│  │      │              │  │  │      UpdatePostRequestDto.class
│  │      │              │  │  │      UpdatePostResponseDto$UpdatePostResponseDtoBuilder.class
│  │      │              │  │  │      UpdatePostResponseDto.class
│  │      │              │  │  │
│  │      │              │  │  ├─entity
│  │      │              │  │  │      Post$PostBuilder.class
│  │      │              │  │  │      Post.class
│  │      │              │  │  │
│  │      │              │  │  ├─exception
│  │      │              │  │  │      PostErrorCode.class
│  │      │              │  │  │      PostException.class
│  │      │              │  │  │
│  │      │              │  │  ├─repository
│  │      │              │  │  │      PostRepository.class
│  │      │              │  │  │
│  │      │              │  │  └─service
│  │      │              │  │          PostService.class
│  │      │              │  │
│  │      │              │  ├─postLike
│  │      │              │  │  ├─constant
│  │      │              │  │  │      PostConstant.class
│  │      │              │  │  │
│  │      │              │  │  ├─controller
│  │      │              │  │  │      PostLikeController.class
│  │      │              │  │  │
│  │      │              │  │  ├─dto
│  │      │              │  │  │      PostLikeResponseDto$PostLikeResponseDtoBuilder.class
│  │      │              │  │  │      PostLikeResponseDto.class
│  │      │              │  │  │
│  │      │              │  │  ├─entity
│  │      │              │  │  │      PostLike$PostLikeBuilder.class
│  │      │              │  │  │      PostLike.class
│  │      │              │  │  │
│  │      │              │  │  ├─repository
│  │      │              │  │  │      PostLikeRepository.class
│  │      │              │  │  │
│  │      │              │  │  └─service
│  │      │              │  │          PostLikeService.class
│  │      │              │  │
│  │      │              │  ├─scheduler
│  │      │              │  │      Scheduler.class
│  │      │              │  │
│  │      │              │  ├─user
│  │      │              │  │  ├─controller
│  │      │              │  │  │      UserController.class
│  │      │              │  │  │
│  │      │              │  │  ├─dto
│  │      │              │  │  │      CheckNameRequestDto.class
│  │      │              │  │  │      CommonUserResponseDto$CommonUserResponseDtoBuilder.class
│  │      │              │  │  │      CommonUserResponseDto.class
│  │      │              │  │  │      LoginRequestDto.class
│  │      │              │  │  │      SignupRequestDto.class
│  │      │              │  │  │
│  │      │              │  │  ├─entity
│  │      │              │  │  │      User$UserBuilder.class
│  │      │              │  │  │      User.class
│  │      │              │  │  │
│  │      │              │  │  ├─exception
│  │      │              │  │  │      UserErrorCode.class
│  │      │              │  │  │      UserException.class
│  │      │              │  │  │
│  │      │              │  │  ├─repository
│  │      │              │  │  │      UserRepository.class
│  │      │              │  │  │
│  │      │              │  │  └─service
│  │      │              │  │          UserService.class
│  │      │              │  │
│  │      │              │  └─util
│  │      │              │          BaseTime.class
│  │      │              │
│  │      │              └─global
│  │      │                  ├─common
│  │      │                  │      CommonCode.class
│  │      │                  │      CommonErrorCode.class
│  │      │                  │      CommonResponseDto.class
│  │      │                  │
│  │      │                  ├─config
│  │      │                  │      AuditingConfig.class
│  │      │                  │      JasyptConfig.class
│  │      │                  │      SchedulingConfig.class
│  │      │                  │      WebSecurityConfig.class
│  │      │                  │
│  │      │                  ├─exception
│  │      │                  │  │  ErrorCode.class
│  │      │                  │  │  RestApiException.class
│  │      │                  │  │
│  │      │                  │  ├─advice
│  │      │                  │  │      GlobalExceptionHandler.class
│  │      │                  │  │
│  │      │                  │  └─response
│  │      │                  │          ErrorResponse$ErrorResponseBuilder.class
│  │      │                  │          ErrorResponse$ValidationError$ValidationErrorBuilder.class
│  │      │                  │          ErrorResponse$ValidationError.class
│  │      │                  │          ErrorResponse.class
│  │      │                  │
│  │      │                  ├─jwt
│  │      │                  │      JwtUtil.class
│  │      │                  │
│  │      │                  └─security
│  │      │                          AuthenticationFilter.class
│  │      │                          UserDetailsImpl.class
│  │      │                          UserDetailsServiceImpl.class
│  │      │
│  │      └─test
│  │          └─com
│  │              └─example
│  │                  └─practice
│  │                          PracticeApplicationTests.class
