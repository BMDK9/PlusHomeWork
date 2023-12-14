package com.example.practice.domain.post.exception;

import com.example.practice.global.exception.ErrorCode;
import com.example.practice.global.exception.RestApiException;

public class PostException extends RestApiException {

    public PostException(ErrorCode errorCode) {
        super(errorCode);
    }
}
