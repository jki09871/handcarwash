package com.carwash.controller.user;

import com.carwash.domain.user.UserVO;
import com.carwash.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login.do")
    public String loginPage() {
        return "/userjoin/login";
    }

    @PostMapping("/login.do")
    public String login(UserVO userVO, Model model) {
        System.out.println("userVO = " + userVO);
        
        if (userService.login(userVO) != null) {
            return "redirect:/api/v1/home.do"; // 로그인 성공 시 리다이렉트
        }
        model.addAttribute("fail", "아이디 혹은 비밀번호를 확인해주세요.");
        return "/userjoin/login"; // JSP로 반환
    }


    @GetMapping("/join.do")
    public String getJoinPage() {
        return "/userjoin/userjoin";
    }

    @PostMapping("/join.do")
    public String postJoinForm(UserVO userVO) {
        userService.postJoinForm(userVO);
        return "/userjoin/login";
    }
}
