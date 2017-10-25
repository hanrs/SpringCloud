package com.dhxx.api.rpc.usergrp;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.tcn.TcnInfo;
import com.dhxx.common.entity.usergrp.UserGrp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author liangz
 * Date 2017-10-20
 * @version 1.01
 */
@Primary
@FeignClient(name = "B-TrunC-service", fallback = UserGrpFeignClient.HystrixUserGrpFeignClientFallback.class)
public interface UserGrpFeignClient {

    @PostMapping("/B-TrunC-service/userGrp/save")
    public void save(UserGrp userGrp);

    @PostMapping("/B-TrunC-service/userGrp/update")
    public void update(UserGrp userGrp);

    @Component
    static class HystrixUserGrpFeignClientFallback implements UserGrpFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixUserGrpFeignClientFallback.class);


        @Override
        public void save(UserGrp userGrp) {
            log.error("application=B-TrunC-service,url=/userGrp/save 异常发生，进入fallback方法，接收的参数：userGrp = " + JSON.toJSONString(userGrp));
            userGrp.setId(-1L);
        }

        @Override
        public void update(UserGrp userGrp) {
            log.error("application=B-TrunC-service,url=/userGrp/update 异常发生，进入fallback方法，接收的参数：userGrp = " + JSON.toJSONString(userGrp));
            userGrp.setId(-1L);
        }

    }
}