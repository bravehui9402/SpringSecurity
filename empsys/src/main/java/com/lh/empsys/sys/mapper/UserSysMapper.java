package com.lh.empsys.sys.mapper;

import cn.hutool.json.JSONObject;
import com.lh.empsys.sys.pojo.Role;
import com.lh.empsys.user.pojo.UserInfo;

import java.util.List;

/**
 * @author liuhui
 * @title: UserSysMapper
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1716:25
 */
public interface UserSysMapper {
    public List<UserInfo> getUserList(JSONObject userInfo);

    void addUser(UserInfo userInfo);

    List<Role> getUserRoleList(String userId);
}
