package com.dhxx.common.entity.permission;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 权限表 (TB_PERMISSION)
 */
public class Permission {
    private Long id; //主键
    private String  permissionName; //权限名
    private String describe; //描述

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getPermissionName() { return permissionName; }

    public void setPermissionName(String permissionName) { this.permissionName = permissionName; }

    public String getDescribe() { return describe; }

    public void setDescribe(String describe) { this.describe = describe; }
}
