package com.dhxx.api.rest.user;

import com.dhxx.api.authorization.annotation.Authorization;
import com.dhxx.api.authorization.manager.TokenManager;
import com.dhxx.api.exception.RestException;
import com.dhxx.api.rpc.user.UserFeignClient;
import com.dhxx.common.entity.user.User;
import com.dhxx.common.entity.user.UserInfo;
import com.dhxx.common.entity.vo.UserVo;
import com.dhxx.common.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    TokenManager manager;

    private String msg = null;
    private boolean isSuccess = true;

    @PostMapping("login")
    public Object login(@RequestBody User user) throws Exception {
        UserInfo u = new UserInfo();
        User usered = userFeignClient.login(user);
        if(usered!=null){
            String token = UUID.randomUUID().toString();
            u.setAccount(usered.getAccount());
            u.setRole(usered.getRole());
            u.setUserName(usered.getUserName());
            u.setToken(token);
            manager.createToken(u);
            msg = "登陆成功";
        }else {
            msg = "用户名或密码错误";
        }
        return Resp.SUCCESS(isSuccess, msg, u);
    }

    @PostMapping("save")
    public Object save(@RequestBody User user) throws Exception {
        try {
            userFeignClient.save(user);
            msg = "注册成功";
        }catch (Exception e) {
            e.printStackTrace();
            msg = "注册失败";
            isSuccess = false;
            return null;
        }

        return Resp.SUCCESS(isSuccess, msg, user);
    }

    @PostMapping("update")
    public Object update(@RequestBody User user) throws  Exception {
        try {
            userFeignClient.update(user);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(user);

    }

    @PostMapping("delete")
    public Object delete(@RequestBody User user) throws  Exception {
        try {
            userFeignClient.delete(user);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(user);
    }

    @PostMapping("personalInfo")
    public Object personalInfo(@RequestBody UserVo userVo) throws  Exception {
        UserVo userVoRps = null;
        try {
            userVoRps = userFeignClient.personalInfo(userVo);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(userVoRps);
    }
}
