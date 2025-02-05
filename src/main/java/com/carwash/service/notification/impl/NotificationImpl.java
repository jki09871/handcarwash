package com.carwash.service.notification.impl;

import com.carwash.domain.notification.NotificationVO;
import com.carwash.dto.PagingDTO;
import com.carwash.repository.mapper.NotificationMapper;
import com.carwash.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationImpl implements NotificationService {

    @Resource(name = "NotificationMapper")
    private final NotificationMapper notificationMapper;

    @Override
    public void notificationPost(NotificationVO notificationVO) { // 공지사항 작성
        notificationMapper.notificationPost(notificationVO);
    }

    @Override
    public List<NotificationVO> notificationListPaging(PagingDTO pageNo) { // 공지사항 목록 페이징
        return notificationMapper.notificationList(pageNo);
    }

    @Override
    public NotificationVO notificationDetail(int id) { // 공지사항 상세보기
        return notificationMapper.notificationDetail(id);
    }

    @Override
    public void notificationModify(NotificationVO notificationVO) { // 공지사항 수정
        notificationMapper.notificationModify(notificationVO);
    }

    @Override
    public void hitsIncrease(int id) { // 조회수 증가
        notificationMapper.hitsIncrease(id);
    }

    @Override
    public void notificationDelete(int id) { // 공지사항 삭제
        notificationMapper.notificationDelete(id);
    }

    @Override
    public int notificationTotalCount() {
        return notificationMapper.notificationTotalCount();
    }

}
