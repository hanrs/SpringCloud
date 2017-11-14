package com.dhxx.api.rpc.subscribe;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.dto.SubscribePageDTO;
import com.dhxx.common.entity.subscribe.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-21
 * @version 1.01
 */
@Primary
@FeignClient(name = "B-TrunC-service", fallback = SubsctibeFeignClient.HystrixSubFeignClientFallback.class)
public interface SubsctibeFeignClient {

    @PostMapping("/B-TrunC-service/sub/save")
    public void save(Subscribe subscribe);

    @PostMapping("/B-TrunC-service/sub/findSubByPage")
    public List<Subscribe> findSubByPage(SubscribePageDTO subscribePageDTO);

    @PostMapping("/B-TrunC-service/sub/findSubByCount")
    public Integer findSubByCount(SubscribePageDTO subscribePageDTO);

    @Component
    static class HystrixSubFeignClientFallback implements SubsctibeFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixSubFeignClientFallback.class);


        @Override
        public void save(Subscribe subscribe) {
            log.error("application=B-TrunC-service,url=/sub/save 异常发生，进入fallback方法，接收的参数：subscribe = " + JSON.toJSONString(subscribe));
            subscribe.setId(-1L);
        }

        @Override
        public List<Subscribe> findSubByPage(SubscribePageDTO subscribePageDTO) {
            log.error("application=B-TrunC-service,url=/sub/findSubByPage 异常发生，进入fallback方法，接收的参数：subscribePageDTO = " + JSON.toJSONString(subscribePageDTO));
            return null;
        }

        @Override
        public Integer findSubByCount(SubscribePageDTO subscribePageDTO) {
            log.error("application=B-TrunC-service,url=/sub/findSubByCount 异常发生，进入fallback方法，接收的参数：subscribePageDTO = " + JSON.toJSONString(subscribePageDTO));
            return -1;
        }

    }
}