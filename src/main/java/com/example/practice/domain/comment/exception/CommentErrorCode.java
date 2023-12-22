package com.example.practice.domain.comment.exception;

import com.example.practice.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommentErrorCode implements ErrorCode {

    NO_EXIST("해당 댓글이 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    NO_AUTHORITY("해당 권한이 없습니다.", HttpStatus.FORBIDDEN);

    private final String message;
    private final HttpStatus httpStatus;

}
