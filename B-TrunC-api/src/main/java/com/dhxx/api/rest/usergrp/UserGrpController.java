package com.dhxx.api.rest.usergrp;

import com.dhxx.api.rpc.usergrp.UserGrpFeignClient;
import com.dhxx.common.entity.usergrp.UserGrp;
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
@RequestMapping("userGrp")
public class UserGrpController {

    @Autowired
    private UserGrpFeignClient userGrpFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody UserGrp userGrp) throws Exception {
        try {
            userGrpFeignClient.save(userGrp);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(userGrp);
    }

    @PostMapping("update")
    public Object update(@RequestBody UserGrp userGrp) throws  Exception {
        try {
            userGrpFeignClient.update(userGrp);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(userGrp);
    }

}
