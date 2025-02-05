package com.carwash.controller.notification;

import com.carwash.domain.notification.NotificationVO;
import com.carwash.dto.PagingDTO;
import com.carwash.service.notification.NotificationService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
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
    public String notificationList(@RequestParam(value = "pageNo",
                                    required = false, defaultValue = "1")int pageNo,
                                   Model model) {

        System.out.println("pageNo = " + pageNo);
        //PaginationInfo에 필수 정보를 넣어 준다.
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(pageNo); // 현 페이지 번호
        paginationInfo.setRecordCountPerPage(10); // 한 페이지 보여줄 글의 수
        paginationInfo.setPageSize(10); // 페이지 리스트에 게시되는 페이지 건수

        int firstRecordIndex = paginationInfo.getFirstRecordIndex(); // limit 0, 10;
        int recordCountPerPage = paginationInfo.getRecordCountPerPage(); // limit 0, 10; 에서 10

        PagingDTO pagingDTO = new PagingDTO();
        pagingDTO.setFirstRecordIndex(firstRecordIndex);
        pagingDTO.setRecordCountPerPage(recordCountPerPage);

        int employeeCount = service.notificationTotalCount(); //전체 게시물 건 수
        paginationInfo.setTotalRecordCount(employeeCount); //전체 게시물 건 수


        List<NotificationVO> notificationVO = service.notificationListPaging(pagingDTO);
        model.addAttribute("notificationVO", notificationVO);
        model.addAttribute("paginationInfo", paginationInfo);



        return "/notification/list";
    }

    // 공지사항 리스트
    @GetMapping("/read.do")
    public String notificationDetail(@RequestParam("id") int id, Model model,@RequestParam(value = "pageNo", required = false) int pageNo) {
        service.hitsIncrease(id); // 조회수 증가
        NotificationVO notificationVO = service.notificationDetail(id);
        model.addAttribute("notificationVO", notificationVO);
        model.addAttribute("pageNo", pageNo);
        return "/notification/detail";
    }

    // 공지사항 수정
    @GetMapping("/modified.do")
    public String notificationModify(@RequestParam("id") int id,@RequestParam(value = "pageNo", required = false) int pageNo, Model model) {
        model.addAttribute("notificationVO", service.notificationDetail(id));
        model.addAttribute("pageNo", pageNo);
        return "/notification/modified";
    }

    // 공지사항 수정
    @PostMapping("/modified.do")
    public String notificationModified(@RequestParam(value = "pageNo", required = false) int pageNo,NotificationVO notificationVO) {
        service.notificationModify(notificationVO);
        return "redirect:/api/v1/notifications/read.do?id=" + notificationVO.getId() + "&pageNo=" + pageNo;
    }

    // 공지사항 삭제
    @GetMapping("/delete.do")
    public String notificationDelete(@RequestParam("id") int id,@RequestParam(value = "pageNo", required = false) int pageNo, Model model) {
        service.notificationDelete(id);
        return "redirect:/api/v1/notifications/list.do" + "?pageNo=" + pageNo;
    }

}
