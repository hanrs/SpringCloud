package com.dhxx.service.biz.role;

import com.dhxx.common.entity.role.Role;
import com.dhxx.common.entity.tcn.TcnInfo;
import com.dhxx.service.mapper.role.RoleMapper;
import com.dhxx.service.mapper.tcn.TcnInfoMapper;
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
public class RoleBiz {

    private static Logger logger = LoggerFactory.getLogger(RoleBiz.class);

    @Autowired
    private RoleMapper roleMapper;

    //新增
    public void save(Role role) { roleMapper.save(role); }

    //删除
    public void delete(Role role) { roleMapper.delete(role); }

    //修改
    public  void update(Role role) { roleMapper.update(role); }

    //查看所有角色
    public List<Role> findRole() { return  roleMapper.findRole(); }
}
