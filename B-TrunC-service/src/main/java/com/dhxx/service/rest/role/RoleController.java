package com.dhxx.service.rest.role;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.role.Role;
import com.dhxx.common.entity.tcn.TcnInfo;
import com.dhxx.service.biz.role.RoleBiz;
import com.dhxx.service.biz.tcn.TcnInfoBiz;
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
@RequestMapping("role")
public class RoleController {
    private static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleBiz roleBiz;

    @PostMapping("/save")
    public void save(@RequestBody Role role) {
        logger.debug("/role/save>>>>role="+ JSON.toJSONString(role));
        try {
            roleBiz.save(role);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/role/save>>>>保存成功");
    }

    @PostMapping("update")
    public void update(@RequestBody Role role) {
        logger.debug("/role/update>>>>role="+ JSON.toJSONString(role));
        try {
            roleBiz.update(role);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("delete")
    public void delete(@RequestBody Role role) {
        logger.debug("/role/delete>>>>role="+ JSON.toJSONString(role));
        try {
            roleBiz.delete(role);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("findRole")
    public List<Role> findRole() {
        List<Role> list = new ArrayList<Role>();
        try {
            list = roleBiz.findRole();
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return list;
    }
}
