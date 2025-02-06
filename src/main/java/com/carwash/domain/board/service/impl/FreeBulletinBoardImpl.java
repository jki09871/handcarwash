package com.carwash.domain.board.service.impl;

import com.carwash.domain.board.service.FreeBulletinBoardService;
import com.carwash.repository.mapper.FreeBulletinBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RequiredArgsConstructor
public class FreeBulletinBoardImpl implements FreeBulletinBoardService {

    @Resource(name = "freeBulletinBoardMapper")
    private final FreeBulletinBoardMapper freeBulletinBoardMapper;
}
