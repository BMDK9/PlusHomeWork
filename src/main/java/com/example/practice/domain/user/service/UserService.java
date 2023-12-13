package com.example.practice.domain.user.service;

import com.example.practice.domain.user.dto.CheckNameRequestDto;
import com.example.practice.domain.user.dto.LoginRequestDto;
import com.example.practice.domain.user.dto.SignupRequestDto;
import com.example.practice.domain.user.entity.User;
import com.example.practice.domain.user.exception.UserErrorCode;
import com.example.practice.domain.user.exception.UserException;
import com.example.practice.domain.user.repository.UserRepository;
import com.example.practice.global.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void checkName(CheckNameRequestDto checkNameRequestDto) {
        String checkedUsername = checkNameRequestDto.getUsername();

        checkUsername(checkedUsername);
    }

    @Transactional
    public void signup(SignupRequestDto signupRequestDto) {
        checkUsername(signupRequestDto.getUsername());
        passwordDistinctUsername(signupRequestDto);
        checkPasswordInSignup(signupRequestDto);

        String username = signupRequestDto.getUsername();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        User saveUser = User.builder()
            .username(username)
            .password(password)
            .build();

        userRepository.save(saveUser);
    }

    public void login(LoginRequestDto loginRequestDto, HttpServletResponse httpServletResponse) {
        User user = loginCheck(loginRequestDto);
        String jwtToken = jwtUtil.createJwtToken(user.getUsername());
        jwtUtil.addJwtToCookie(jwtToken, httpServletResponse);
    }

    private User loginCheck(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByUsername(loginRequestDto.getUsername())
            .orElseThrow(()-> new UserException(UserErrorCode.WRONG_LOGIN));
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new UserException(UserErrorCode.WRONG_LOGIN);
        }
        return user;
    }

    private void checkPasswordInSignup(SignupRequestDto signupRequestDto) {
        if (!signupRequestDto.getCheckPassword().equals(signupRequestDto.getPassword())) {
            throw new UserException(UserErrorCode.DIFFERENT_PASSWORD);
        }
    }

    private void passwordDistinctUsername(SignupRequestDto signupRequestDto) {
        if (signupRequestDto.getPassword().contains(signupRequestDto.getUsername())) {
            throw new UserException(UserErrorCode.ANOTHER_PASSWORD);
        }
    }

    private void checkUsername(String username) {
        Optional<User> checkUser = userRepository.findByUsername(username);
        if (checkUser.isPresent()) {
            throw new UserException(UserErrorCode.ALREADY_EXSIST);
        }
    }
}
