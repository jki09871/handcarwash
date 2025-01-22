package com.carwash.controller.notification;

import com.carwash.domain.notification.NotificationVO;
import com.carwash.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @RequestMapping("/msg.do")
    public String msgForward(HttpServletRequest request) {
        // 전달된 msg, returnUrl 등의 정보를 JSP로 전달
        request.setAttribute("msg", request.getAttribute("msg"));
        request.setAttribute("returnUrl", request.getAttribute("returnUrl"));
        request.setAttribute("method", request.getAttribute("method"));
        return "/msg"; // msg.jsp로 포워딩
    }

    // 공지사항 작성
    @GetMapping("/write.do")
    public String notificationWrite() {
        return "/notification/write"; // 정상적인 경우, 다른 뷰로 이동
    }

    // 공지사항 작성
    @PostMapping("/write.do")
    public String notificationPost(NotificationVO notificationVO) {
        service.notificationPost(notificationVO);
        return "redirect:/api/v1/notifications/list.do"; // 정상적인 경우, 다른 뷰로 이동
    }

    // 공지사항 리스트
    @GetMapping("/list.do")
    public String notificationList(Model model) {
        List<NotificationVO> notificationVO = service.notificationList();
        model.addAttribute("notificationVO", notificationVO);
        return "/notification/list";
    }

    // 공지사항 리스트
    @GetMapping("/read.do")
    public String notificationDetail(@RequestParam("id") int id, Model model) {
        service.hitsIncrease(id); // 조회수 증가
        NotificationVO notificationVO = service.notificationDetail(id);
        model.addAttribute("notificationVO", notificationVO);
        return "/notification/detail";
    }

    // 공지사항 수정
    @GetMapping("/modified.do")
    public String notificationModify(@RequestParam("id") int id, Model model) {
        model.addAttribute("notificationVO", service.notificationDetail(id));
        return "/notification/modified";
    }

    // 공지사항 수정
    @PostMapping("/modified.do")
    public String notificationModified(NotificationVO notificationVO) {
        service.notificationModify(notificationVO);
        return "redirect:/api/v1/notifications/read.do?id=" + notificationVO.getId();
    }

    // 공지사항 삭제
    @GetMapping("/delete.do")
    public String notificationDelete(@RequestParam("id") int id) {
        service.notificationDelete(id);
        return "redirect:/api/v1/notifications/list.do";
    }

}
