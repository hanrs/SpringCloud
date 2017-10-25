package com.dhxx.api.rpc.role;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.role.Role;
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
@FeignClient(name = "B-TrunC-service", fallback = RoleFeignClient.HystrixRoleFeignClientFallback.class)
public interface RoleFeignClient {

    @PostMapping("/B-TrunC-service/role/save")
    public void save(Role role);

    @PostMapping("/B-TrunC-service/role/update")
    public void update(Role role);

    @PostMapping("/B-TrunC-service/role/delete")
    public void delete(Role role);

    @PostMapping("/B-TrunC-service/role/findRole")
    public List<Role> findRole();

    @Component
    static class HystrixRoleFeignClientFallback implements RoleFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixRoleFeignClientFallback.class);


        @Override
        public void save(Role role) {
            log.error("application=B-TrunC-service,url=/role/save 异常发生，进入fallback方法，接收的参数：role = " + JSON.toJSONString(role));
            role.setId(-1L);
        }

        @Override
        public void update(Role role) {
            log.error("application=B-TrunC-service,url=/role/update 异常发生，进入fallback方法，接收的参数：role = " + JSON.toJSONString(role));
            role.setId(-1L);
        }

        @Override
        public void delete(Role role) {
            log.error("application=B-TrunC-service,url=/role/delete 异常发生，进入fallback方法，接收的参数：role = " + JSON.toJSONString(role));
            role.setId(-1L);
        }

        @Override
        public List<Role> findRole() {
            log.error("application=B-TrunC-service,url=/role/findRole 异常发生，进入fallback方法");
            return null;
        }
    }
}