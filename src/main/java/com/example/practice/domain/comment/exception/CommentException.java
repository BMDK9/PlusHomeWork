package com.example.practice.domain.comment.exception;

import com.example.practice.global.exception.ErrorCode;
import com.example.practice.global.exception.RestApiException;

public class CommentException extends RestApiException {

    public CommentException(ErrorCode errorCode) {
        super(errorCode);
    }

}
