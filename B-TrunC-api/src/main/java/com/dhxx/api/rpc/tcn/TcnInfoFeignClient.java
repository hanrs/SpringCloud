package com.dhxx.api.rpc.tcn;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.tcn.TcnInfo;
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
@FeignClient(name = "B-TrunC-service", fallback = TcnInfoFeignClient.HystrixTcnFeignClientFallback.class)
public interface TcnInfoFeignClient {

    @PostMapping("/B-TrunC-service/tcn/save")
    public void save(TcnInfo tcn);

    @PostMapping("/B-TrunC-service/tcn/update")
    public void update(TcnInfo tcn);

    @PostMapping("/B-TrunC-service/tcn/delete")
    public void delete(TcnInfo tcn);

    @PostMapping("/B-TrunC-service/tcn/tcnInfoByAccount")
    public TcnInfo tcnInfoByAccount(TcnInfo tcn);

    @Component
    static class HystrixTcnFeignClientFallback implements TcnInfoFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixTcnFeignClientFallback.class);


        @Override
        public void save(TcnInfo tcn) {
            log.error("application=B-TrunC-service,url=/tcn/save 异常发生，进入fallback方法，接收的参数：tcn = " + JSON.toJSONString(tcn));
            tcn.setId(-1L);
        }

        @Override
        public void update(TcnInfo tcn) {
            log.error("application=B-TrunC-service,url=/tcn/update 异常发生，进入fallback方法，接收的参数：tcn = " + JSON.toJSONString(tcn));
            tcn.setId(-1L);
        }

        @Override
        public void delete(TcnInfo tcn) {
            log.error("application=B-TrunC-service,url=/tcn/delete 异常发生，进入fallback方法，接收的参数：tcn = " + JSON.toJSONString(tcn));
            tcn.setId(-1L);
        }

        @Override
        public TcnInfo tcnInfoByAccount(TcnInfo tcn) {
            log.error("application=B-TrunC-service,url=/tcn/tcnInfoByAccount 异常发生，进入fallback方法，接收的参数：tcn = " + JSON.toJSONString(tcn));
            return null;
        }
    }
}