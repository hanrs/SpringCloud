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
    private Long roleId; //角色
    private Long permissionId; //权限ID
    private String describe; //描述

    private String permissionName; //权限名

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getRoleId() { return roleId; }

    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public Long getPermissionId() { return permissionId; }

    public void setPermissionId(Long permissionId) { this.permissionId = permissionId; }

    public String getDescribe() { return describe; }

    public void setDescribe(String describe) { this.describe = describe; }

    public String getPermissionName() { return permissionName; }

    public void setPermissionName(String permissionName) { this.permissionName = permissionName; }
}
