package com.dhxx.service.rest.user;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.vo.UserVo;
import com.dhxx.service.biz.user.UserBiz;
import com.dhxx.common.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        logger.debug("/user/login>>>>user="+ JSON.toJSONString(user));
        try {
            user = userBiz.login(user);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }

        return user;
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        logger.debug("/user/save>>>>user="+ JSON.toJSONString(user));
        try {
            userBiz.save(user);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/user/save>>>>保存成功");
    }

    @PostMapping("update")
    public void update(@RequestBody User user) {
        logger.debug("/user/update>>>>user="+ JSON.toJSONString(user));
        try {
            userBiz.update(user);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("delete")
    public void delete(@RequestBody User user) {
        logger.debug("/user/delete>>>>user="+ JSON.toJSONString(user));
        try {
            userBiz.delete(user);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("personalInfo")
    public UserVo personalInfo(@RequestBody UserVo userVo) {
        logger.debug("/user/personalInfo>>>>personalInfo="+ JSON.toJSONString(userVo));
        UserVo userVoRps = null;
        try {
            userVoRps= userBiz.personalInfo(userVo);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }

        return userVoRps;
    }
}
