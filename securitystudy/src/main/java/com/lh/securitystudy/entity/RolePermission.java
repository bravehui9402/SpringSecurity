package com.lh.securitystudy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lh
 * @since 2020-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_permission")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    @TableId("RID")
    private Integer rid;

    /**
     * 权限编号
     */
    @TableField("PID")
    private Integer pid;


}
