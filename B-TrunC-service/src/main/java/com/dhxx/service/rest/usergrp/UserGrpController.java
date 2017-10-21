package com.dhxx.service.rest.usergrp;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.usergrp.UserGrp;
import com.dhxx.service.biz.usergrp.UserGrpBiz;
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
@RequestMapping("userGrp")
public class UserGrpController {
    private static Logger logger = LoggerFactory.getLogger(UserGrpController.class);

    @Autowired
    private UserGrpBiz userGrpBiz;

    @PostMapping("/save")
    public void save(@RequestBody UserGrp userGrp) {
        logger.debug("/userGrp/save>>>>userGrp="+ JSON.toJSONString(userGrp));
        try {
            userGrpBiz.save(userGrp);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/userGrp/save>>>>保存成功");
    }

    @PostMapping("update")
    public void update(@RequestBody UserGrp userGrp) {
        logger.debug("/userGrp/update>>>>userGrp="+ JSON.toJSONString(userGrp));
        try {
            userGrpBiz.update(userGrp);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

}
