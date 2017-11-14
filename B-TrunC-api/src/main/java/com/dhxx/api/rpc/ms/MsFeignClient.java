package com.dhxx.api.rpc.ms;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.dto.MsPageDTO;
import com.dhxx.common.entity.ms.MsInfo;
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
@FeignClient(name = "B-TrunC-service", fallback = MsFeignClient.HystrixMsFeignClientFallback.class)
public interface MsFeignClient {

    @PostMapping("/B-TrunC-service/ms/save")
    public void save(MsInfo ms);

    @PostMapping("/B-TrunC-service/ms/update")
    public void update(MsInfo ms);

    @PostMapping("/B-TrunC-service/ms/delete")
    public void delete(MsInfo ms);

    @PostMapping("/B-TrunC-service/ms/findMsByUdn")
    public MsInfo findMsByUdn(MsInfo ms);

    @PostMapping("/B-TrunC-service/ms/findMsByPage")
    public List<MsInfo> findMsByPage(MsPageDTO msPageDTO);

    @PostMapping("/B-TrunC-service/ms/findMsByCount")
    public Integer findMsByCount(MsPageDTO msPageDTO);

    @PostMapping("/B-TrunC-service/ms/findMsOnManage")
    public List<MsInfo> findMsOnManage(MsPageDTO msPageDTO);

    @PostMapping("/B-TrunC-service/ms/findMsOnManageCount")
    public Integer findMsOnManageCount(MsPageDTO msPageDTO);

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

        @Override
        public MsInfo findMsByUdn(MsInfo ms) {
            log.error("application=B-TrunC-service,url=/ms/findMsByUdn 异常发生，进入fallback方法，接收的参数：ms = " + JSON.toJSONString(ms));
           return ms;
        }

        @Override
        public List<MsInfo> findMsByPage(MsPageDTO msPageDTO) {
            log.error("application=B-TrunC-service,url=/ms/findMsByPage 异常发生，进入fallback方法，接收的参数：msPageDTO = " + JSON.toJSONString(msPageDTO));
            return null;
        }

        @Override
        public Integer findMsByCount(MsPageDTO msPageDTO) {
            log.error("application=B-TrunC-service,url=/ms/findMsByCount 异常发生，进入fallback方法，接收的参数：msPageDTO = " + JSON.toJSONString(msPageDTO));
            return -1;
        }

        @Override
        public List<MsInfo> findMsOnManage(MsPageDTO msPageDTO) {
            log.error("application=B-TrunC-service,url=/ms/findMsOnManage 异常发生，进入fallback方法，接收的参数：msPageDTO = " + JSON.toJSONString(msPageDTO));
            return null;
        }

        @Override
        public Integer findMsOnManageCount(MsPageDTO msPageDTO) {
            log.error("application=B-TrunC-service,url=/ms/findMsOnManageCount 异常发生，进入fallback方法，接收的参数：msPageDTO = " + JSON.toJSONString(msPageDTO));
            return -1;
        }
    }
}