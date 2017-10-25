package com.dhxx.service.biz.roleper;

import com.dhxx.common.entity.roleper.RolePermission;
import com.dhxx.common.entity.userms.UserMs;
import com.dhxx.service.mapper.roleper.RolePerMapper;
import com.dhxx.service.mapper.userms.UserMsMapper;
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
public class RolePerBiz {

    private static Logger logger = LoggerFactory.getLogger(RolePerBiz.class);

    @Autowired
    private RolePerMapper rolePerMapper;

    //新增
    public void save(RolePermission rolePermission) { rolePerMapper.save(rolePermission); }


    //删除
    public void delete(RolePermission rolePermission) { rolePerMapper.delete(rolePermission); }

    //根据角色ID查该角色所拥有得到权限
    public List<RolePermission> findRolePerByRoleId(RolePermission rolePermission){
        return rolePerMapper.findRolePerByRoleId(rolePermission);
    }
}
