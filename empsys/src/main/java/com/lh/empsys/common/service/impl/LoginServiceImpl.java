package com.lh.empsys.common.service.impl;

import com.lh.empsys.common.pojo.Result;
import com.lh.empsys.common.mapper.LoginMapper;
import com.lh.empsys.common.service.LoginService;
import com.lh.empsys.user.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuhui
 * @title: LoginServiceImpl
 * @projectName empsys
 * @description: 登录接口的实现类
 * @date 2020/8/1317:03
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public Result verifyLogin(UserInfo userInfo) {
        log.info("用户登录..."+userInfo);
        //根据用户名查询用户信息
        UserInfo userInfoByFind = loginMapper.findUserByLoginName(userInfo);
        if(userInfoByFind != null && userInfo.getPassword().equals(userInfoByFind.getPassword())){//用户名密码正确
            log.info("验证成功...");
            return new Result("200","通过验证",userInfoByFind);
        }else {//用户名密码不匹配
            log.info("验证失败...");
            return new Result("300","用户名或密码不正确!");
        }
    }
}
