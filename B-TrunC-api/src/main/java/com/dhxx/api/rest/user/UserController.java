package com.dhxx.api.rest.user;

import com.dhxx.api.authorization.annotation.Authorization;
import com.dhxx.api.authorization.manager.TokenManager;
import com.dhxx.api.exception.RestException;
import com.dhxx.api.rpc.user.UserFeignClient;
import com.dhxx.common.entity.user.User;
import com.dhxx.common.entity.user.UserInfo;
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

    @PostMapping("login")
    public Object login(@RequestBody User user) throws Exception {
        UserInfo u = new UserInfo();
        User usered = userFeignClient.login(user);
        if(usered!=null){
            String token = UUID.randomUUID().toString();
            u.setAccount(user.getAccount());
            u.setRole(user.getRole());
            u.setUserName(user.getUserName());
            u.setToken(token);
            manager.createToken(u);
        }
        return Resp.SUCCESS(u);
    }

    @PostMapping("save")
    public Object save(@RequestBody User user) throws Exception {
        try {
            userFeignClient.save(user);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(user);
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
}
