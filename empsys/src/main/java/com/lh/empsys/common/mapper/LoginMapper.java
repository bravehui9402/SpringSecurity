package com.lh.empsys.common.mapper;

import com.lh.empsys.user.pojo.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author liuhui
 * @title: LoginMapper
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1317:04
 */
@Repository
public interface LoginMapper {
    public UserInfo findUserByLoginName(UserInfo userInfo);
}
