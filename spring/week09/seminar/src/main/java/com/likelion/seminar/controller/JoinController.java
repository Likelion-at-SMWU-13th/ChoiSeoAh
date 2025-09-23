package com.likelion.seminar.controller;

import com.likelion.seminar.dto.JoinDTO;
import com.likelion.seminar.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/join")
    public String joinP() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProc(JoinDTO joinDTO) {
        joinService.joinProcess(joinDTO);
        return "redirect:/join";
    }
}
