package com.dhxx.api.rpc.log;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.dto.LogPageDTO;
import com.dhxx.common.entity.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author liangz
 * Date 2017-9-28
 * @version 1.01
 */
@Primary
@FeignClient(name = "B-TrunC-service", fallback = LogFeignClient.HystrixLogFeignClientFallback.class)
public interface LogFeignClient {

    @PostMapping("/B-TrunC-service/log/save")
    public void save(Log log);

    @PostMapping("/B-TrunC-service/log/findLogByPage")
    public List<Log> findLogByPage(LogPageDTO logPageDTO);

    @PostMapping("/B-TrunC-service/log/findLogByCount")
    public Integer findLogByCount(LogPageDTO logPageDTO);

    @Component
    static class HystrixLogFeignClientFallback implements LogFeignClient {

        private static final Logger logger = LoggerFactory.getLogger(HystrixLogFeignClientFallback.class);


        @Override
        public void save(Log log) {
            logger.error("application=B-TrunC-service,url=/log/save 异常发生，进入fallback方法，接收的参数：log = " + JSON.toJSONString(log));
            log.setId(-1L);
        }

        @Override
        public List<Log> findLogByPage(LogPageDTO logPageDTO) {
            logger.error("application=B-TrunC-service,url=/log/logPageDTO 异常发生，进入fallback方法，接收的参数：logPageDTO = " + JSON.toJSONString(logPageDTO));
            return null;
        }

        @Override
        public Integer findLogByCount(LogPageDTO logPageDTO) {
            logger.error("application=B-TrunC-service,url=/log/logPageDTO 异常发生，进入fallback方法，接收的参数：logPageDTO = " + JSON.toJSONString(logPageDTO));
            return -1;
        }
    }
}