package com.dhxx.service.biz.permission;

import com.dhxx.common.entity.permission.Permission;
import com.dhxx.service.mapper.permission.PermissionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年10月21日
 * @version 1.01
 */
@Service
@Transactional
public class PermissionBiz {

    private static Logger logger = LoggerFactory.getLogger(PermissionBiz.class);

    @Autowired
    private PermissionMapper permissionMapper;

    //新增
    public void save(Permission permission) { permissionMapper.save(permission); }

    //删除
    public void delete(Permission permission) { permissionMapper.delete(permission); }

    //修改
    public  void update(Permission permission) { permissionMapper.update(permission); }

    //查找所有权限
    public List<Permission> findPermission() { return  permissionMapper.findPermission(); }
}
