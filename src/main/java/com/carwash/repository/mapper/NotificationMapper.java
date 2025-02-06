package com.carwash.repository.mapper;

import com.carwash.domain.notification.vo.NotificationVO;
import com.carwash.domain.dto.PagingDTO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("NotificationMapper")
public interface NotificationMapper {
    void notificationPost(NotificationVO notificationVO); // 공지사항 작상

    List<NotificationVO> notificationList(PagingDTO pageNo); // 공지사항 목록

    NotificationVO notificationDetail(int id); // 공지사항 상세보기

    void notificationModify(NotificationVO notificationVO); // 공지사항 수정

    void hitsIncrease(int id); // 조회수 증가

    void notificationDelete(int id); // 공지사항 삭제

    int notificationTotalCount();
}
