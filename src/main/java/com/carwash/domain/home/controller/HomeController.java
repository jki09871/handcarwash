package com.carwash.domain.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/v1")
public class HomeController {

    @GetMapping("/home.do")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return "/home";
    }

}
