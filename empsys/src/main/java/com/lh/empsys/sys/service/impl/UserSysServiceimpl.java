package com.lh.empsys.sys.service.impl;

import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.empsys.common.pojo.Result;
import com.lh.empsys.sys.mapper.UserSysMapper;
import com.lh.empsys.sys.pojo.Role;
import com.lh.empsys.sys.service.UserSysService;
import com.lh.empsys.user.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuhui
 * @title: UserSysServiceimpl
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1716:32
 */
@Service
public class UserSysServiceimpl  implements UserSysService {
    @Autowired
    UserSysMapper userSysMapper;
    @Override
    public PageInfo<UserInfo> getUserList(Integer page, Integer limit, JSONObject userInfo) {
        PageHelper.startPage(page,limit);
        List<UserInfo> userList = userSysMapper.getUserList(userInfo);
        //根据userid获取用户的权限信息
        for (UserInfo user: userList){
             List<Role> roleList=userSysMapper.getUserRoleList(user.getUserId());
             String s = new String();
             for(Role role: roleList){
                 s += role.getRoleRemark()+"|";
             }
             user.setRoleString("|"+s);
        }
        return new PageInfo(userList);
    }   

    @Override
    public Result addUser(UserInfo userInfo) {
        userSysMapper.addUser(userInfo);
        return Result.success("创建成功！");
    }
}
