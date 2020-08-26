package com.lh.empsys.user.pojo;

import com.lh.empsys.sys.pojo.Role;
import lombok.Data;

import java.util.List;

/**
 * @author liuhui
 * @title: UserInfo
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1314:48
 */
@Data
public class UserInfo {
    private String userId;
    private String loginName; //登录名
    private String username;  //用户名
    private String password;  //登录密码
    private String phone;    //手机号
    private String createTime;  //创建时间
    private String updateTime; //修改时间
    private List<Role> role; //权限信息
    private String roleString; //role的权限信息展示

}
