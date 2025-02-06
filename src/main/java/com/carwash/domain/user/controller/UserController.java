package com.carwash.domain.user.controller;

import com.carwash.domain.user.vo.UserVO;
import com.carwash.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String login(UserVO userVO, Model model,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        String toUrl, boolean rememberId) {

        UserVO dbVO = userService.login(userVO);
        HttpSession session = request.getSession();
        if (dbVO != null) {
            memoryId(userVO, response, rememberId);
            session.setAttribute("login", dbVO);
            toUrl = toUrl == null || toUrl.equals("")? "/api/v1/home.do" : toUrl;
            return "redirect:" + toUrl; // 로그인 성공 시 리다이렉트
        }
        model.addAttribute("fail", "아이디 혹은 비밀번호를 확인해주세요.");
        return "/user/login"; // JSP로 반환
    }

    private void memoryId(UserVO userVO, HttpServletResponse response, boolean rememberId) {
        Cookie cookie = new Cookie("rememberId", userVO.getEmail());
        if (rememberId) {
            response.addCookie(cookie);
        } else {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    @GetMapping("/logout.do")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate(); // 세션의 모든 속성을 삭제
        return "redirect:/api/v1/home.do";
    }

    @GetMapping("/join.do")
    public String getJoinPage() {
        return "/user/userjoin";
    }

    @PostMapping("/join.do")
    public String postJoinForm(UserVO userVO) {
        userService.postJoinForm(userVO);
        return "redirect:/api/v1/home.do";
    }

    @GetMapping("/emailValidCheck.do")
    @ResponseBody
    public String emailValidCheck(@RequestParam(name = "email") String email) {
        boolean emailCheck = userService.emailValidCheck(email);
        return String.valueOf(emailCheck);
    }
}
