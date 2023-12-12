package com.example.practice.domain.user.controller;

import com.example.practice.domain.user.dto.CommonUserResponseDto;
import com.example.practice.domain.user.dto.SignupRequestDto;
import com.example.practice.domain.user.service.UserService;
import com.example.practice.global.common.CommonCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    //    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("/signup")
    public CommonUserResponseDto signup(@Validated @RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return CommonUserResponseDto.of(CommonCode.OK);
    }
}
