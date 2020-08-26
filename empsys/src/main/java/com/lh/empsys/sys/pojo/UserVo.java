package com.lh.empsys.sys.pojo;

import com.lh.empsys.user.pojo.UserInfo;
import lombok.Data;

import java.util.List;

/**
 * @author liuhui
 * @title: UserVo
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1716:21
 */
@Data
public class UserVo {
    private String code; //状态码
    private String msg;  //信息
    private Integer count; //总条数
    private List<UserInfo> data; //用户信息
}
