package com.lh.empsys.sys.controller;

import cn.hutool.json.JSONObject;
import com.lh.empsys.common.pojo.Result;
import com.lh.empsys.sys.pojo.HomeInfo;
import com.lh.empsys.sys.pojo.LogoInfo;
import com.lh.empsys.sys.pojo.Menu;
import com.lh.empsys.sys.pojo.MenuVo;
import com.lh.empsys.sys.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author liuhui
 * @title: MenuController
 * @projectName empsys
 * @description: 菜单的常用功能
 * @date 2020/8/1410:12
 */
@Slf4j
@RequestMapping("/sys/menu")
@RestController
public class MenuController {
    @Autowired
    MenuService menuService;
    /**
     * 根据用户id获取到用户权限下的所有菜单
     * @param userid
     * @return
     */
    @GetMapping("/{userid}")
    public MenuVo getMenus(@PathVariable(required = false) String userid){
        List<Menu> menusByUserId = menuService.getMenusByUserId(userid);
        MenuVo menuVo = new MenuVo();

        HomeInfo homeInfo = new HomeInfo();
        homeInfo.setTitle("欢迎来到德莱联盟");
        homeInfo.setHref("page/welcome-1.html?t=1");
        menuVo.setHomeInfo(homeInfo);

        LogoInfo logoInfo = new LogoInfo();
        logoInfo.setTitle(" ");
        logoInfo.setImage("images/logo.png");
        menuVo.setLogoInfo(logoInfo);

        menuVo.setMenuInfo(menusByUserId);
        log.info(menuVo.toString());
        return menuVo;
    }

}
