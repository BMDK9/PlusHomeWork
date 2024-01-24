package com.example.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ThymeleafController {

    @GetMapping
    public String basic(Model model) {

        model.addAttribute("key", "basic 파일로 보내는 겁니다.");

        return "basic";
    }
}
