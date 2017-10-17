package com.dhxx.api.rpc.sms;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.call.CallLog;
import com.dhxx.common.entity.sms.SmsLog;
import com.dhxx.common.entity.vo.SmsPageVo;
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
@FeignClient(name = "B-TrunC-service", fallback = SmsFeignClient.HystrixSmsFeignClientFallback.class)
public interface SmsFeignClient {

    @PostMapping("/B-TrunC-service/sms/save")
    public void save(SmsLog sms);

    @PostMapping("/B-TrunC-service/sms/delete")
    public void delete(List<SmsLog> sms);

    @PostMapping("/B-TrunC-service/sms/update")
    public void update(SmsLog sms);

    @PostMapping("/B-TrunC-service/sms/findSmsLogByPage")
    public List<SmsLog> findSmsLogByPage(SmsPageVo smsPageVo);

    @PostMapping("/B-TrunC-service/sms/findSmsLogByCount")
    public Integer findSmsLogByCount(SmsPageVo smsPageVo);

    @PostMapping("/B-TrunC-service/sms/smsCountByStatus0")
    public Integer smsCountByStatus0(SmsLog sms);

    @Component
    static class HystrixSmsFeignClientFallback implements SmsFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixSmsFeignClientFallback.class);


        @Override
        public void save(SmsLog sms) {
            log.error("application=B-TrunC-service,url=/sms/save 异常发生，进入fallback方法，接收的参数：sms = " + JSON.toJSONString(sms));
            sms.setId(-1L);
        }

        @Override
        public void delete(List<SmsLog> sms) {
            log.error("application=B-TrunC-service,url=/sms/delete 异常发生，进入fallback方法，接收的参数：sms = " + JSON.toJSONString(sms));
        }

        @Override
        public void update(SmsLog sms) {
            log.error("application=B-TrunC-service,url=/sms/update 异常发生，进入fallback方法，接收的参数：sms = " + JSON.toJSONString(sms));
            sms.setId(-1L);
        }

        @Override
        public List<SmsLog> findSmsLogByPage(SmsPageVo smsPageVo) {
            log.error("application=B-TrunC-service,url=/call/findSmsLogByPage 异常发生，进入fallback方法，接收的参数：smsPageVo = " + JSON.toJSONString(smsPageVo));
            return null;
        }

        @Override
        public Integer findSmsLogByCount(SmsPageVo smsPageVo) {
            log.error("application=B-TrunC-service,url=/call/findSmsLogByCount 异常发生，进入fallback方法，接收的参数：smsPageVo = " + JSON.toJSONString(smsPageVo));
            return -1;
        }

        @Override
        public Integer smsCountByStatus0(SmsLog sms) {
            log.error("application=B-TrunC-service,url=/sms/smsCountByStatus0 异常发生，进入fallback方法，接收的参数：sms = " + JSON.toJSONString(sms));
            return -1;
        }
    }
}