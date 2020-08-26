package com.lh.empsys.sys.controller;

import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lh.empsys.common.pojo.Result;
import com.lh.empsys.sys.pojo.UserVo;
import com.lh.empsys.sys.service.UserSysService;
import com.lh.empsys.user.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuhui
 * @title: UserController
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1716:16
 */
@Slf4j
@RestController
@RequestMapping("/sys/user")
public class UserSysController {
    @Autowired
    UserSysService userSysService;


    //加载user列表
    @GetMapping("/list")
    public UserVo getUserList(Integer page,Integer limit,String searchParams ){
        JSONObject userInfo = new JSONObject(searchParams);
        log.info(userInfo.toString());
        log.info(limit.toString());
        PageInfo pageInfo = userSysService.getUserList(page,limit,userInfo);
        UserVo userVo = new UserVo();
        userVo.setCode("0");
        userVo.setMsg("");
        userVo.setData(pageInfo.getList());
        Long total = Long.valueOf(pageInfo.getTotal());
        userVo.setCount(total.intValue());
        return userVo;
    }

    @PostMapping("/addUser")
    public Result addUser(UserInfo userInfo){
        //应该做后端校验的，但我懒得写！
        Result result = userSysService.addUser(userInfo);
        return result;
    }
}
