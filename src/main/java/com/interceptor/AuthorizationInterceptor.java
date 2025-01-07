package com.interceptor;

import com.carwash.domain.user.UserRole;
import com.carwash.domain.user.UserVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 세션에서 UserVO 가져오기
        UserVO userVO = (UserVO) request.getSession().getAttribute("login");

        // 권한 확인: ADMIN이 아니면 메시지와 함께 msg.do로 포워딩
        if (userVO == null || userVO.getRole() != UserRole.ADMIN) {
            request.setAttribute("msg", "권한이 없습니다.");
            request.setAttribute("returnUrl", "/api/v1/home.do");
            request.setAttribute("method", "get");
            request.getRequestDispatcher("/api/v1/notifications/msg.do").forward(request, response);
            return false; // 요청을 처리하지 않고 종료
        }

        return true; // 요청 처리 계속 진행
    }
}
