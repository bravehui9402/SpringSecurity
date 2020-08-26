package com.lh.empsys.common.service;

import com.lh.empsys.common.pojo.Result;
import com.lh.empsys.user.pojo.UserInfo;

/**
 * @author liuhui
 * @title: LoginService
 * @projectName empsys
 * @description: 登录验证的接口
 * @date 2020/8/1316:55
 */
public interface LoginService {
    public Result verifyLogin(UserInfo userInfo);
}
