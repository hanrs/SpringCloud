package com.dhxx.service.rest.roleper;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.roleper.RolePermission;
import com.dhxx.common.entity.userms.UserMs;
import com.dhxx.service.biz.roleper.RolePerBiz;
import com.dhxx.service.biz.userms.UserMsBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangz
 * Date 2017-10-21
 * @version 1.01
 */
@RestController
@RequestMapping("rolePer")
public class RolePerController {
    private static Logger logger = LoggerFactory.getLogger(RolePerController.class);

    @Autowired
    private RolePerBiz rolePerBiz;

    @PostMapping("/save")
    public void save(@RequestBody RolePermission rolePermission) {
        logger.debug("/rolePer/save>>>>rolePermission="+ JSON.toJSONString(rolePermission));
        try {
            rolePerBiz.save(rolePermission);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/rolePer/save>>>>保存成功");
    }

    @PostMapping("delete")
    public void update(@RequestBody RolePermission rolePermission) {
        logger.debug("/rolePer/delete>>>>rolePermission="+ JSON.toJSONString(rolePermission));
        try {
            rolePerBiz.delete(rolePermission);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("findRolePerByRoleId")
    public List<RolePermission> findRolePerByRoleId(@RequestBody RolePermission rolePermission) {
        logger.debug("/rolePer/findRolePerByRoleId>>>>rolePermission="+ JSON.toJSONString(rolePermission));

        List<RolePermission> list = new ArrayList<RolePermission>();
        try {
            list = rolePerBiz.findRolePerByRoleId(rolePermission);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return list;
    }

}
