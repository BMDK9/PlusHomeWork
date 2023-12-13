package com.example.practice.domain.user.controller;

import com.example.practice.domain.user.dto.CheckNameRequestDto;
import com.example.practice.domain.user.dto.CommonUserResponseDto;
import com.example.practice.domain.user.dto.LoginRequestDto;
import com.example.practice.domain.user.dto.SignupRequestDto;
import com.example.practice.domain.user.service.UserService;
import com.example.practice.global.common.CommonCode;
import com.example.practice.global.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/check-name")
    public CommonUserResponseDto checkName(@Valid @RequestBody CheckNameRequestDto checkNameRequestDto) {
        userService.checkName(checkNameRequestDto);
        return CommonUserResponseDto.of(CommonCode.GOOD);
    }

    @PostMapping("/signup")
    public CommonUserResponseDto signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return CommonUserResponseDto.of(CommonCode.OK);
    }

    @PostMapping("/login")
    public CommonUserResponseDto login(@RequestBody LoginRequestDto loginRequestDto,
                                       HttpServletResponse httpServletResponse) {
        userService.login(loginRequestDto, httpServletResponse);
        return CommonUserResponseDto.of(CommonCode.OK);
    }
}
