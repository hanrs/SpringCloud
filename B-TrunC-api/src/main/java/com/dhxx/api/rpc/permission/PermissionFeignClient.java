package com.dhxx.api.rpc.permission;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.permission.Permission;
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
@FeignClient(name = "B-TrunC-service", fallback = PermissionFeignClient.HystrixPermissionFeignClientFallback.class)
public interface PermissionFeignClient {

    @PostMapping("/B-TrunC-service/permission/save")
    public void save(Permission permission);

    @PostMapping("/B-TrunC-service/permission/update")
    public void update(Permission permission);

    @PostMapping("/B-TrunC-service/permission/delete")
    public void delete(Permission permission);

    @PostMapping("/B-TrunC-service/permission/findPermission")
    public List<Permission> findPermission();

    @Component
    static class HystrixPermissionFeignClientFallback implements PermissionFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixPermissionFeignClientFallback.class);


        @Override
        public void save(Permission permission) {
            log.error("application=B-TrunC-service,url=/permission/save 异常发生，进入fallback方法，接收的参数：permission = " + JSON.toJSONString(permission));
            permission.setId(-1L);
        }

        @Override
        public void update(Permission permission) {
            log.error("application=B-TrunC-service,url=/permission/update 异常发生，进入fallback方法，接收的参数：permission = " + JSON.toJSONString(permission));
            permission.setId(-1L);
        }

        @Override
        public void delete(Permission permission) {
            log.error("application=B-TrunC-service,url=/permission/delete 异常发生，进入fallback方法，接收的参数：permission = " + JSON.toJSONString(permission));
            permission.setId(-1L);
        }

        @Override
        public List<Permission> findPermission() {
            log.error("application=B-TrunC-service,url=/permission/findPermission 异常发生，进入fallback方法");
            return null;
        }
    }
}