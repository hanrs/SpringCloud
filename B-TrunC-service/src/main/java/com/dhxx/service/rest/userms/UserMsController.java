package com.dhxx.service.rest.userms;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.usergrp.UserGrp;
import com.dhxx.common.entity.userms.UserMs;
import com.dhxx.service.biz.user.UserBiz;
import com.dhxx.service.biz.usergrp.UserGrpBiz;
import com.dhxx.service.biz.userms.UserMsBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangz
 * Date 2017-10-20
 * @version 1.01
 */
@RestController
@RequestMapping("userMs")
public class UserMsController {
    private static Logger logger = LoggerFactory.getLogger(UserMsController.class);

    @Autowired
    private UserMsBiz userMsBiz;

    @PostMapping("/save")
    public void save(@RequestBody UserMs userMs) {
        logger.debug("/userMs/save>>>>userMs="+ JSON.toJSONString(userMs));
        try {
            userMsBiz.save(userMs);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/userMs/save>>>>保存成功");
    }

    @PostMapping("update")
    public void update(@RequestBody UserMs userMs) {
        logger.debug("/userMs/userMs>>>>userMs="+ JSON.toJSONString(userMs));
        try {
            userMsBiz.update(userMs);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

}
