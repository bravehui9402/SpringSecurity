package com.lh.empsys.sys.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author liuhui
 * @title: MenuVo
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1710:54
 */
@Data
public class MenuVo {
    private HomeInfo homeInfo ;
    private LogoInfo logoInfo ;
    private List<Menu> menuInfo;
}
