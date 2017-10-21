package com.dhxx.api.rest.userms;

import com.dhxx.api.rpc.usergrp.UserGrpFeignClient;
import com.dhxx.api.rpc.userms.UserMsFeignClient;
import com.dhxx.common.entity.usergrp.UserGrp;
import com.dhxx.common.entity.userms.UserMs;
import com.dhxx.common.utils.Resp;
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

    @Autowired
    private UserMsFeignClient userMsFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody UserMs userMs) throws Exception {
        try {
            userMsFeignClient.save(userMs);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(userMs);
    }

    @PostMapping("update")
    public Object update(@RequestBody UserMs userMs) throws  Exception {
        try {
            userMsFeignClient.update(userMs);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(userMs);
    }

}
