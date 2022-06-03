package com.lecture.spring.springbootclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "boot Project");
        return "hello";
    }
}
