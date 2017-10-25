package com.dhxx.service.mapper.permission;

import com.dhxx.common.entity.permission.Permission;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-21
 * @version 1.01
 */
public interface PermissionMapper {
    void save(Permission permission); //增

    void delete(Permission permission); //删

    void update(Permission permission); //改

    List<Permission> findPermission(); //查
}
