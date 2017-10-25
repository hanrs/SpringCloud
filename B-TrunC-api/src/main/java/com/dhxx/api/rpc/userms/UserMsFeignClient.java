package com.dhxx.api.rpc.userms;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.usergrp.UserGrp;
import com.dhxx.common.entity.userms.UserMs;
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
@FeignClient(name = "B-TrunC-service", fallback = UserMsFeignClient.HystrixUserMsFeignClientFallback.class)
public interface UserMsFeignClient {

    @PostMapping("/B-TrunC-service/userGrp/save")
    public void save(UserMs userMs);

    @PostMapping("/B-TrunC-service/userGrp/update")
    public void update(UserMs userMs);

    @Component
    static class HystrixUserMsFeignClientFallback implements UserMsFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixUserMsFeignClientFallback.class);


        @Override
        public void save(UserMs userMs) {
            log.error("application=B-TrunC-service,url=/userMs/save 异常发生，进入fallback方法，接收的参数：userMs = " + JSON.toJSONString(userMs));
            userMs.setId(-1L);
        }

        @Override
        public void update(UserMs userMs) {
            log.error("application=B-TrunC-service,url=/userMs/update 异常发生，进入fallback方法，接收的参数：userMs = " + JSON.toJSONString(userMs));
            userMs.setId(-1L);
        }

    }
}