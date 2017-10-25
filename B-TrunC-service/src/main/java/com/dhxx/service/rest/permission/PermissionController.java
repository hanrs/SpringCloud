package com.dhxx.service.rest.permission;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.permission.Permission;
import com.dhxx.service.biz.permission.PermissionBiz;
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
@RequestMapping("permission")
public class PermissionController {
    private static Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private PermissionBiz permissionBiz;

    @PostMapping("/save")
    public void save(@RequestBody Permission permission) {
        logger.debug("/role/save>>>>permission="+ JSON.toJSONString(permission));
        try {
            permissionBiz.save(permission);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/permission/save>>>>保存成功");
    }

    @PostMapping("update")
    public void update(@RequestBody Permission permission) {
        logger.debug("/permission/update>>>>permission="+ JSON.toJSONString(permission));
        try {
            permissionBiz.update(permission);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("delete")
    public void delete(@RequestBody Permission permission) {
        logger.debug("/permission/delete>>>>permission="+ JSON.toJSONString(permission));
        try {
            permissionBiz.delete(permission);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("findPermission")
    public List<Permission> findPermission() {
        List<Permission> list = new ArrayList<Permission>();
        try {
            list = permissionBiz.findPermission();
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return list;
    }
}
