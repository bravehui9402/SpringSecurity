package com.lh.empsys.sys.service;

import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lh.empsys.common.pojo.Result;
import com.lh.empsys.user.pojo.UserInfo;

import java.util.List;

/**
 * @author liuhui
 * @title: UserSysService
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1716:31
 */
public interface UserSysService {
    PageInfo<UserInfo> getUserList(Integer page, Integer limit, JSONObject userInfo);

    Result addUser(UserInfo userInfo);
}
