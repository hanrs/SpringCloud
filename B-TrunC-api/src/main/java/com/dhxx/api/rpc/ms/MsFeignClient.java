package com.dhxx.api.rpc.ms;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.ms.MsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author liangz
 * Date 2017-9-28
 * @version 1.01
 */
@Primary
@FeignClient(name = "B-TrunC-service", fallback = MsFeignClient.HystrixMsFeignClientFallback.class)
public interface MsFeignClient {

    @PostMapping("/B-TrunC-service/ms/save")
    public void save(MsInfo ms);

    @PostMapping("/B-TrunC-service/ms/delete")
    public void delete(MsInfo ms);

    @PostMapping("/B-TrunC-service/ms/update")
    public void update(MsInfo ms);

    @Component
    static class HystrixMsFeignClientFallback implements MsFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixMsFeignClientFallback.class);


        @Override
        public void save(MsInfo ms) {
            log.error("application=B-TrunC-service,url=/ms/save 异常发生，进入fallback方法，接收的参数：ms = " + JSON.toJSONString(ms));
            ms.setId(-1L);
        }

        @Override
        public void update(MsInfo ms) {
            log.error("application=B-TrunC-service,url=/ms/update 异常发生，进入fallback方法，接收的参数：ms = " + JSON.toJSONString(ms));
            ms.setId(-1L);
        }

        @Override
        public void delete(MsInfo ms) {
            log.error("application=B-TrunC-service,url=/ms/delete 异常发生，进入fallback方法，接收的参数：ms = " + JSON.toJSONString(ms));
            ms.setId(-1L);
        }
    }
}