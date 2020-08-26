package com.lh.empsys.common.controller;

import cn.hutool.core.util.StrUtil;
import com.lh.empsys.common.pojo.Result;
import com.lh.empsys.common.service.LoginService;
import com.lh.empsys.user.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liuhui
 * @title: CommonController
 * @projectName empsys
 * @description: 主页跳转、登录等、
 * @date 2020/8/1314:44
 */
@Slf4j
@Controller
public class CommonController {
    @Autowired
    LoginService loginService;



}
