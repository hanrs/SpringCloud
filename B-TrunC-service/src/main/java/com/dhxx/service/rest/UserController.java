package com.dhxx.service.rest;

import com.alibaba.fastjson.JSON;
import com.dhxx.service.biz.user.UserBiz;
import com.dhxx.common.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作用：
 * ① 测试服务实例的相关内容
 * ② 为后来的服务做提供
 * @author hanrs
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserBiz userBiz;

    /**
     * 注：@GetMapping("/{phone}")是spring 4.3的新注解等价于：
     * @RequestMapping(value = "/phone", method = RequestMethod.GET)
     * 类似的注解还有@PostMapping等等
     * @param user
     * @return user信息
     */
    @PostMapping("/info")
    public Object info(@RequestBody User user) {
        logger.debug("/user/info>>>>user="+ JSON.toJSONString(user));
        try {
            user =userBiz.info(user);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
        return user;
    }
}
