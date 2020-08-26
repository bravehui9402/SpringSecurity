package com.lh.empsys.sys.pojo;

import lombok.Data;

/**
 * @author liuhui
 * @title: Role
 * @projectName empsys
 * @description: TODO
 * @date 2020/8/1818:07
 */
@Data
public class Role {
    private String roleId;//角色Id
    private String roleName;//角色名称
    private String roleRemark;//角色备注
    private String createTime;//创建时间
    private String updateTime;//修改时间
}
