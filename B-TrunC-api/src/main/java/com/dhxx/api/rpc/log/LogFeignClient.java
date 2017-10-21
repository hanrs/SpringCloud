package com.dhxx.api.rpc.log;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.log.Log;
import com.dhxx.common.entity.vo.LogPageVo;
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
    public List<Log> findLogByPage(LogPageVo logPageVo);

    @PostMapping("/B-TrunC-service/log/findLogByCount")
    public Integer findLogByCount(LogPageVo logPageVo);

    @Component
    static class HystrixLogFeignClientFallback implements LogFeignClient {

        private static final Logger logger = LoggerFactory.getLogger(HystrixLogFeignClientFallback.class);


        @Override
        public void save(Log log) {
            logger.error("application=B-TrunC-service,url=/log/save 异常发生，进入fallback方法，接收的参数：log = " + JSON.toJSONString(log));
            log.setId(-1L);
        }

        @Override
        public List<Log> findLogByPage(LogPageVo logPageVo) {
            logger.error("application=B-TrunC-service,url=/log/logPageVo 异常发生，进入fallback方法，接收的参数：logPageVo = " + JSON.toJSONString(logPageVo));
            return null;
        }

        @Override
        public Integer findLogByCount(LogPageVo logPageVo) {
            logger.error("application=B-TrunC-service,url=/log/logPageVo 异常发生，进入fallback方法，接收的参数：logPageVo = " + JSON.toJSONString(logPageVo));
            return -1;
        }
    }
}