package com.carwash.domain.board.controller;

import com.carwash.domain.board.service.FreeBulletinBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/board/free")
@RequiredArgsConstructor
public class FreeBulletinBoardController {

    private final FreeBulletinBoardService freeBulletinBoardService;
}
