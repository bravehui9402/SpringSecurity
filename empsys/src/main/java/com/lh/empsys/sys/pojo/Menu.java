package com.lh.empsys.sys.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author liuhui
 * @title: Menu
 * @projectName empsys
 * @description: 菜单类
 * @date 2020/8/1410:27
 */
@Data
public class Menu {
    String menuId       ;//菜单id
    @JsonProperty("title")
    String menuName     ;//菜单名称
    @JsonProperty("href")
    String menuPath     ;//菜单路径
    String menuParentId;//上级id
    @JsonProperty("icon")
    String menuIcom     ;//菜单图标
    String menuOrderNum;//菜单序号
    String menuChecked  ;//未定义
    String meunIsmenu   ;//未定义
    String createTime   ;//创建时间
    String updateTime   ;//修改时间
    List<Menu> child     ;//子菜单
}
