package com.carwash.service.notification;

import com.carwash.domain.notification.NotificationVO;

import java.util.List;

public interface NotificationService {
    void notificationPost(NotificationVO notificationVO); // 공지사항 작성

    List<NotificationVO> notificationList(); // 공지사항 목록

    NotificationVO notificationDetail(int id); // 공지사항 상세보기

    void notificationModify(NotificationVO notificationVO); // 공지사항 수정

    void hitsIncrease(int id); // 조회수 증가

    void notificationDelete(int id); // 공지사항 삭제
}