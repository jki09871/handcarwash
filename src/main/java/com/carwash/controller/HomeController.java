package com.carwash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/home.do")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("session.getAttribute(\"login\") = " + session.getAttribute("login"));
        return "/home";
    }

}
