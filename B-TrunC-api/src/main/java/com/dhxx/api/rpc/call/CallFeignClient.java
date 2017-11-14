package com.dhxx.api.rpc.call;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.call.CallLog;
import com.dhxx.common.entity.dto.CallPageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 */
@Primary
@FeignClient(name = "B-TrunC-service", fallback = CallFeignClient.HystrixCallFeignClientFallback.class)
public interface CallFeignClient {

    @PostMapping("/B-TrunC-service/call/save")
    public void save(CallLog call);

    @PostMapping("/B-TrunC-service/call/delete")
    public void delete(List<CallLog> calls);

    @PostMapping("/B-TrunC-service/call/findCallLogByType")
    public List<CallLog> findCallLogByType(CallPageDTO callPageDTO);

    @PostMapping("/B-TrunC-service/call/findCallLogByCount")
    public Integer findCallLogByCount(CallPageDTO callPageDTO);

    @PostMapping("/B-TrunC-service/call/missedCalls")
    public Integer missedCalls(CallLog call);

    @PostMapping("/B-TrunC-service/call/emgCall")
    public Integer emgCall(CallLog call);

    @Component
    static class HystrixCallFeignClientFallback implements CallFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixCallFeignClientFallback.class);


        @Override
        public void save(CallLog call) {
            log.error("application=B-TrunC-service,url=/call/save 异常发生，进入fallback方法，接收的参数：call = " + JSON.toJSONString(call));
            call.setId(-1L);
        }

        @Override
        public void delete(List<CallLog> calls) {
            log.error("application=B-TrunC-service,url=/call/delete 异常发生，进入fallback方法，接收的参数：call = " + JSON.toJSONString(calls));
        }

        @Override
        public List<CallLog> findCallLogByType(CallPageDTO callPageDTO) {
            log.error("application=B-TrunC-service,url=/call/findCallLogByType 异常发生，进入fallback方法，接收的参数：callPageDTO = " + JSON.toJSONString(callPageDTO));
            return null;
        }

        @Override
        public Integer findCallLogByCount(CallPageDTO callPageDTO) {
            log.error("application=B-TrunC-service,url=/call/findCallLogByType 异常发生，进入fallback方法，接收的参数：callPageDTO = " + JSON.toJSONString(callPageDTO));
            return -1;
        }

        @Override
        public Integer missedCalls(CallLog call) {
            log.error("application=B-TrunC-service,url=/call/missedCalls 异常发生，进入fallback方法，接收的参数：call = " + JSON.toJSONString(call));
            return -1;
        }

        @Override
        public Integer emgCall(CallLog call) {
            log.error("application=B-TrunC-service,url=/call/emgCall 异常发生，进入fallback方法，接收的参数：call = " + JSON.toJSONString(call));
            return -1;
        }
    }
}