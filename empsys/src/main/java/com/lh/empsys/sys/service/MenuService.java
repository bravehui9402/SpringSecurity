package com.lh.empsys.sys.service;

import cn.hutool.json.JSONObject;
import com.lh.empsys.sys.pojo.Menu;

import java.util.List;

/**
 * @author liuhui
 * @title: MenuService
 * @projectName empsys
 * @description: 菜单相关
 * @date 2020/8/1410:22
 */
public interface MenuService {
    public List<Menu> getMenusByUserId(String userId);
}
