package com.dhxx.service.mapper.roleper;

import com.dhxx.common.entity.roleper.RolePermission;

/**
 * @author liangz
 * Date: 2017-10-21
 * @version 1.01
 */
public interface RolePerMapper {

    void save(RolePermission rolePermission);   //增

    void delete(RolePermission rolePermission); //改

}
