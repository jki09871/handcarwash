package com.carwash.service.user;

import com.carwash.domain.user.UserVO;

public interface UserService {
    void postJoinForm(UserVO userVO);

    UserVO login(UserVO userVO);

    boolean emailValidCheck(String email);
}
