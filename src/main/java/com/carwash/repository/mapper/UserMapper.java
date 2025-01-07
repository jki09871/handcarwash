package com.carwash.repository.mapper;

import com.carwash.domain.user.UserVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper("userMapper")
public interface UserMapper {
    void postJoinForm(UserVO userVo);

    UserVO findUserByEmail(UserVO userVO);

    boolean emailValidCheck(@Param("email") String email);
}
