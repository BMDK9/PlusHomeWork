**토이 프로젝트**

---
# PlusHomeWork
구현하지 못한 부분은 이메일 인증 부분입니다.
해당 기능을 구현하기 위해서는 Redis 환경의 구축이 필요하다고 생각됩니다.
저는 아직 Redis 환경을 할 줄 모르기에 다른 과제들부터 먼저 진행했고 시간 문제로 인해 결국 인증 부분을 미구현한 채로 제출합니다.

같은 이유로 테스트 코드 또한 미구현 상태로 제출합니다.

---

[2024.03.24 인터페이스 적용 리팩토링 시작](https://github.com/BMDK9/PlusHomeWork/wiki/Interface-%ED%99%9C%EC%9A%A9-%EB%A6%AC%ED%8C%A9%ED%86%A0%EB%A7%81)

## ERD
![PracticeERD](https://github.com/BMDK9/PlusHomeWork/assets/144665614/845c7b46-3cd4-42ef-bfd0-322c78a34179)


## API
![practiceAPI](https://github.com/BMDK9/PlusHomeWork/assets/144665614/b4721409-bde0-4ba6-80fc-6a921df92513)

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
