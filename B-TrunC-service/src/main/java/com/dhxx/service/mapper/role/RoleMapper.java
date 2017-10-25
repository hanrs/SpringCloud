package com.dhxx.service.mapper.role;

import com.dhxx.common.entity.role.Role;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-21
 * @version 1.01
 */
public interface RoleMapper {
    void save(Role role); //增

    void delete(Role role); //删

    void update(Role role); //改

    List<Role> findRole(); //查
}
