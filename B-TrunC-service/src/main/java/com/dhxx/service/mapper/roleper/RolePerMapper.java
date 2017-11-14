package com.dhxx.service.mapper.roleper;

import com.dhxx.common.entity.roleper.RolePermission;

import java.util.List;

/**
 * @author liangz
 * Date: 2017-10-21
 * @version 1.01
 */
public interface RolePerMapper {

    void save(RolePermission rolePermission);   //增

    void delete(RolePermission rolePermission); //改

    List<RolePermission> findRolePerByRoleId(RolePermission rolePermission); //根据角色ID查该角色所拥有得到权限


}
