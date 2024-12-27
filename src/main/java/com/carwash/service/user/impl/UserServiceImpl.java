package com.carwash.service.user.impl;

import com.carwash.domain.user.UserVO;
import com.carwash.repository.mapper.UserMapper;
import com.carwash.service.user.UserService;
import egovframework.rte.fdl.cryptography.EgovPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Resource(name = "passwordEncoder")
    private EgovPasswordEncoder passwordEncoder;

    @Resource(name = "userMapper")
    private final UserMapper userMapper;

    @Override
    public void postJoinForm(UserVO userVO) {
        String encryptPassword = passwordEncoder.encryptPassword(userVO.getPassword());
        userVO.setPassword(encryptPassword);

        userMapper.postJoinForm(userVO);
    }

    @Override
    public UserVO login(UserVO userVO) {
        UserVO selectUser = userMapper.selectUser(userVO);
        if (selectUser != null){
            passwordEncoder.checkPassword(userVO.getPassword(), selectUser.getPassword());
            return selectUser;
        }
        return null;
    }
}