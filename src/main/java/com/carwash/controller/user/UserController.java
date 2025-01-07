package com.carwash.controller.user;

import com.carwash.domain.user.UserVO;
import com.carwash.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login.do")
    public String loginPage() {
        return "/user/login";
    }

    @PostMapping("/login.do")
    public String login(UserVO userVO, Model model, HttpServletRequest request) {
        UserVO dbVO = userService.login(userVO);
        HttpSession session = request.getSession();
        if (dbVO != null) {
            session.setAttribute("login", dbVO);
            return "redirect:/api/v1/home.do"; // 로그인 성공 시 리다이렉트
        }
        model.addAttribute("fail", "아이디 혹은 비밀번호를 확인해주세요.");
        return "/user/login"; // JSP로 반환
    }

    @GetMapping("/logout.do")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("login");
        session.invalidate(); //세션의 모든 속성을 삭제
        return "redirect:/api/v1/home.do";
    }


    @GetMapping("/join.do")
    public String getJoinPage() {
        return "/user/user";
    }

    @PostMapping("/join.do")
    public String postJoinForm(UserVO userVO) {
        userService.postJoinForm(userVO);
        return "redirect:/api/v1/home.do";
    }

    @GetMapping("/emailchecks.do")
    @ResponseBody
    public String emailValidCheck(@RequestParam(name = "email") String email) {
        boolean emailCheck = userService.emailValidCheck(email);
        return String.valueOf(emailCheck);
    }
}
