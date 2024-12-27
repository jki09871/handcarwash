package com.carwash.repository.mapper;

import com.carwash.domain.user.UserVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userMapper")
public interface UserMapper {

    void postJoinForm(UserVO userVo);

    UserVO selectUser(UserVO userVO);
}
