package com.likelion.seminar.service;

import com.likelion.seminar.Exception.CustomException;
import com.likelion.seminar.Exception.HttpStatus;
import com.likelion.seminar.Repository.UserRepository;
import com.likelion.seminar.dto.SignupRequestDTO;
import com.likelion.seminar.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup(SignupRequestDTO request) {

        // 아이디 중복 체크
        if (userRepository.existsByUsername(request.getUsername()) {
            throw new CustomException(HttpStatus.CONFLICT, "이미 존재하는 아이디입니다.");
        }
        // 이메일 형식 검증
        String email = request.getEmail();
        if (email == null || !email.endsWith("@sookmyung.ac.kr")) {
            throw new CustomException(HttpStatus.BAD_REQUEST,"이메일은 @sookmyung.ac.kr로 끝나야 합니다.");
        }

       User user = User.builder()
               .username(request.getUsername())
               .email(email)
               .password(request.getPassword())
               .bulid();
        userRepository.save(user);

    }


}
