package com.example.practice.domain.user.service;

import com.example.practice.domain.user.dto.SignupRequestDto;
import com.example.practice.domain.user.entity.User;
import com.example.practice.domain.user.exception.UserErrorCode;
import com.example.practice.domain.user.exception.UserException;
import com.example.practice.domain.user.repository.UserRepository;
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

    @Transactional
    public void signup(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        checkUsername(signupRequestDto);
        passwordDistinctUsername(signupRequestDto);
        checkPassword(signupRequestDto);

        User user = User.builder()
            .username(username)
            .password(password)
            .build();

        userRepository.save(user);
    }

    private void checkPassword(SignupRequestDto signupRequestDto) {
        if (!signupRequestDto.getCheckPassword().equals(signupRequestDto.getPassword())) {
            throw new UserException(UserErrorCode.DIFFERENT_PASSWORD);
        }
    }

    private void passwordDistinctUsername(SignupRequestDto signupRequestDto) {
        if (signupRequestDto.getPassword().contains(signupRequestDto.getUsername())) {
            throw new UserException(UserErrorCode.ANOTHER_PASSWORD);
        }
    }

    private void checkUsername(SignupRequestDto signupRequestDto) {
        Optional<User> checkUser = userRepository.findByUsername(signupRequestDto.getUsername());
        if (checkUser.isPresent()) {
            throw new UserException(UserErrorCode.ALREADY_EXSIST);
        }
    }
}
