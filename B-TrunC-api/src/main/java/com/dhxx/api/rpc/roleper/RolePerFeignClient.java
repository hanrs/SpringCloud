package com.dhxx.api.rpc.roleper;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.roleper.RolePermission;
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
@FeignClient(name = "B-TrunC-service", fallback = RolePerFeignClient.HystrixRolePerFeignClientFallback.class)
public interface RolePerFeignClient {

    @PostMapping("/B-TrunC-service/rolePer/save")
    public void save(RolePermission rolePermission);

    @PostMapping("/B-TrunC-service/rolePer/delete")
    public void delete(RolePermission rolePermission);

    @PostMapping("/B-TrunC-service/rolePer/findRolePerByRoleId")
    public List<RolePermission> findRolePerByRoleId(RolePermission rolePermission);

    @Component
    static class HystrixRolePerFeignClientFallback implements RolePerFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixRolePerFeignClientFallback.class);


        @Override
        public void save(RolePermission rolePermission) {
            log.error("application=B-TrunC-service,url=/rolePer/save 异常发生，进入fallback方法，接收的参数：rolePermission = " + JSON.toJSONString(rolePermission));
            rolePermission.setId(-1L);
        }

        @Override
        public void delete(RolePermission rolePermission) {
            log.error("application=B-TrunC-service,url=/rolePer/delete 异常发生，进入fallback方法，接收的参数：rolePermission = " + JSON.toJSONString(rolePermission));
            rolePermission.setId(-1L);
        }

        @Override
        public List<RolePermission> findRolePerByRoleId(RolePermission rolePermission) {
            log.error("application=B-TrunC-service,url=/rolePer/findRolePerByRoleId 异常发生，进入fallback方法，接收的参数：rolePermission = " + JSON.toJSONString(rolePermission));
            return null;
        }

    }
}