package com.likelion.seminar.controller;

import com.likelion.seminar.Exception.CustomException;
import com.likelion.seminar.Repository.UserRepository;
import com.likelion.seminar.dto.SignupRequestDTO;
import com.likelion.seminar.entity.User;
import com.likelion.seminar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;


    @PostMapping("siunup/")
    public ResponseEntity<String> siunup (@Valid @RequestBody SignupRequestDTO request) {
        userService.signup(request);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
}
