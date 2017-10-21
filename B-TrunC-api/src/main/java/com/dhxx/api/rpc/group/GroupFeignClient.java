package com.dhxx.api.rpc.group;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.common.entity.vo.GrpPageVo;
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
@FeignClient(name = "B-TrunC-service", fallback = GroupFeignClient.HystrixGroupFeignClientFallback.class)
public interface GroupFeignClient {

    @PostMapping("/B-TrunC-service/group/save")
    public GroupInfo save(GroupInfo group);

    @PostMapping("/B-TrunC-service/group/delete")
    public void delete(GroupInfo group);

    @PostMapping("/B-TrunC-service/group/update")
    public void update(GroupInfo group);

    @PostMapping("/B-TrunC-service/group/findGrpByPage")
    public List<GroupInfo> findGrpByPage(GrpPageVo grpPageVo);

    @PostMapping("/B-TrunC-service/group/findGrpByCount")
    public Integer findGrpByCount(GrpPageVo grpPageVo);

    @PostMapping("/B-TrunC-service/group/findGrpInfoByGrpId")
    public GroupInfo findGrpInfoByGrpId(GroupInfo groupInfo);

    @PostMapping("/B-TrunC-service/group/findGrpInfoAndSub")
    public List<GroupInfo> findGrpInfoAndSub(GrpPageVo grpPageVo);

    @PostMapping("/B-TrunC-service/group/findGrpInfoAndSubCount")
    public Integer findGrpInfoAndSubCount(GrpPageVo grpPageVo);

    @Component
    static class HystrixGroupFeignClientFallback implements GroupFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixGroupFeignClientFallback.class);


        @Override
        public GroupInfo save(GroupInfo group) {
            log.error("application=B-TrunC-service,url=/group/save 异常发生，进入fallback方法，接收的参数：group = " + JSON.toJSONString(group));
            group.setId(-1L);
            return group;
        }

        @Override
        public void update(GroupInfo group) {
            log.error("application=B-TrunC-service,url=/group/update 异常发生，进入fallback方法，接收的参数：group = " + JSON.toJSONString(group));
            group.setId(-1L);
        }

        @Override
        public void delete(GroupInfo group) {
            log.error("application=B-TrunC-service,url=/group/delete 异常发生，进入fallback方法，接收的参数：group = " + JSON.toJSONString(group));
            group.setId(-1L);
        }

        @Override
        public List<GroupInfo> findGrpByPage(GrpPageVo grpPageVo) {
            log.error("application=B-TrunC-service,url=/group/findGrpByPage 异常发生，进入fallback方法，接收的参数：grpPageVo = " + JSON.toJSONString(grpPageVo));
           return null;
        }

        @Override
        public Integer findGrpByCount(GrpPageVo grpPageVo) {
            log.error("application=B-TrunC-service,url=/group/findGrpByCount 异常发生，进入fallback方法，接收的参数：grpPageVo = " + JSON.toJSONString(grpPageVo));
            return -1;
        }

        @Override
        public GroupInfo findGrpInfoByGrpId(GroupInfo groupInfo) {
            log.error("application=B-TrunC-service,url=/group/findGrpInfoByGrpId 异常发生，进入fallback方法，接收的参数：groupInfo = " + JSON.toJSONString(groupInfo));
            return null;
        }

        @Override
        public List<GroupInfo> findGrpInfoAndSub(GrpPageVo grpPageVo) {
            log.error("application=B-TrunC-service,url=/group/findGrpInfoAndSub 异常发生，进入fallback方法，接收的参数：grpPageVo = " + JSON.toJSONString(grpPageVo));
            return null;
        }

        @Override
        public Integer findGrpInfoAndSubCount(GrpPageVo grpPageVo) {
            log.error("application=B-TrunC-service,url=/group/findGrpInfoAndSubCount 异常发生，进入fallback方法，接收的参数：grpPageVo = " + JSON.toJSONString(grpPageVo));
            return -1;
        }
    }
}