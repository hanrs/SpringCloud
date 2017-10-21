package com.dhxx.api.rpc.grpms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.common.entity.grpms.GroupMs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author liangz
 * Date 2017-9-29
 * @version 1.01
 */
@Primary
@FeignClient(name = "B-TrunC-service", fallback = GrpMsFeignClient.HystrixGrpMsFeignClientFallback.class)
public interface GrpMsFeignClient {

    @PostMapping("/B-TrunC-service/grpms/save")
    public void save(GroupMs groupMs);

    @PostMapping("/B-TrunC-service/grpms/delete")
    public void delete(GroupMs groupMs);

    @PostMapping("/B-TrunC-service/grpms/getMenu")
    public JSONObject queryGrpMsByUdn(GroupMs groupMs);

    @Component
    static class HystrixGrpMsFeignClientFallback implements GrpMsFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixGrpMsFeignClientFallback.class);


        @Override
        public void save(GroupMs groupMs) {
            log.error("application=B-TrunC-service,url=/grpms/save 异常发生，进入fallback方法，接收的参数：groupMs = " + JSON.toJSONString(groupMs));
            groupMs.setId(-1L);
        }

        @Override
        public void delete(GroupMs groupMs) {
            log.error("application=B-TrunC-service,url=/grpms/delete 异常发生，进入fallback方法，接收的参数：groupMs = " + JSON.toJSONString(groupMs));
            groupMs.setId(-1L);
        }

        @Override
        public JSONObject queryGrpMsByUdn(GroupMs groupMs) {
            log.error("application=B-TrunC-service,url=/grpms/queryGrpMsByUdn 异常发生，进入fallback方法，接收的参数：udn = " + groupMs.getUdn());
            return null;
        }
    }
}