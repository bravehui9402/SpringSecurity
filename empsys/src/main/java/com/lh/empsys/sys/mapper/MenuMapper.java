package com.lh.empsys.sys.mapper;

import com.lh.empsys.sys.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuhui
 * @title: MenuMapper
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1410:24
 */
public interface MenuMapper {
    //根据用户id获取用户角色下所有的一级菜单
    public List<Menu> getOneLevelMenusByUserId(String userId);
    //根据用户id获取用户角色下所有的二级菜单
    public List<Menu> getTwoLevelMenusByUserId(String userId);
}
