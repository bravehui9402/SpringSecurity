package com.lh.empsys.sys.service.impl;

import cn.hutool.json.JSONObject;
import com.lh.empsys.sys.mapper.MenuMapper;
import com.lh.empsys.sys.pojo.Menu;
import com.lh.empsys.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhui
 * @title: MenuServiceImpl
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1410:23
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getMenusByUserId(String userId) {
        List<Menu> oneLevelMenusByUserId = menuMapper.getOneLevelMenusByUserId(userId);//一级菜单
        List<Menu> twoLevelMenusByUserId = menuMapper.getTwoLevelMenusByUserId(userId);//二级菜单
        List<Menu> result = new ArrayList<>();
        for (Menu parent:oneLevelMenusByUserId){
            List<Menu> childList = new ArrayList<>();
            for (Menu child:twoLevelMenusByUserId){
                if(child.getMenuParentId().equals(parent.getMenuId())){
                    childList.add(child);
                }
            }
            parent.setChild(childList);
        }
        return oneLevelMenusByUserId;
    }


}
