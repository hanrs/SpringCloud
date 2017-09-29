package com.dhxx.api.rpc.user;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 使用@FeignClient("B-TrunC-service")注解绑定B-TrunC-service服务，还可以使用url参数指定一个URL。
 *
 * @author hanrs
 */
@Primary
@FeignClient(name = "B-TrunC-service", fallback = UserFeignClient.HystrixUserFeignClientFallback.class)
public interface UserFeignClient {

    /**
     * 这里需要注意的两个地方
     * <p>
     * 1、在这里不支持GetMapping注解，如果用这个注解，不能启动
     * <p>
     * 2、@PathVariable需要设置value，如果不设置也不能成功启动
     *
     * @param user
     * @return user
     */

    @PostMapping("/B-TrunC-service/user/login")
    public User login(User user);

    @PostMapping("/B-TrunC-service/user/save")
    public void save(User user);

    @PostMapping("/B-TrunC-service/user/update")
    public void update(User user);

    @PostMapping("/B-TrunC-service/user/delete")
    public void delete(User user);

    @Component
    static class HystrixUserFeignClientFallback implements UserFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixUserFeignClientFallback.class);

        @Override
        public User login(User user) {
            log.error("application=B-TrunC-service,url=/user/login 异常发生，进入fallback方法，接收的参数：user = " + JSON.toJSONString(user));
            user.setId(-1L);
            return user;
        }

        @Override
        public void save(User user) {
            log.error("application=B-TrunC-service,url=/user/save 异常发生，进入fallback方法，接收的参数：user = " + JSON.toJSONString(user));
            user.setId(-1L);
        }

        @Override
        public void update(User user) {
            log.error("application=B-TrunC-service,url=/user/update 异常发生，进入fallback方法，接收的参数：user = " + JSON.toJSONString(user));
            user.setId(-1L);
        }

        @Override
        public void delete(User user) {
            log.error("application=B-TrunC-service,url=/user/delete 异常发生，进入fallback方法，接收的参数：user = " + JSON.toJSONString(user));
            user.setId(-1L);
        }
    }
}


