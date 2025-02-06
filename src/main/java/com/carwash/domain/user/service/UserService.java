package com.carwash.domain.user.service;

import com.carwash.domain.user.vo.UserVO;

public interface UserService {
    void postJoinForm(UserVO userVO);

    UserVO login(UserVO userVO);

    boolean emailValidCheck(String email);
}
