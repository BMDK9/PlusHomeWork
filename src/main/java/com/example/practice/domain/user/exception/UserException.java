package com.example.practice.domain.user.exception;

import com.example.practice.global.exception.ErrorCode;
import com.example.practice.global.exception.RestApiException;

public class UserException extends RestApiException {

    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
