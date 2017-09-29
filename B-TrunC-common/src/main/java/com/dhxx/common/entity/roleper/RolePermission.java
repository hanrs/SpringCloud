package com.dhxx.common.entity.roleper;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 角色权限表 (TB_ROLE_PERMISSION)
 */
public class RolePermission {
    private Long id; //主键
    private String role; //角色
    private Long permission; //权限ID
    private String describe; //描述

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public Long getPermission() { return permission; }

    public void setPermission(Long permission) { this.permission = permission; }

    public String getDescribe() { return describe; }

    public void setDescribe(String describe) { this.describe = describe; }
}
