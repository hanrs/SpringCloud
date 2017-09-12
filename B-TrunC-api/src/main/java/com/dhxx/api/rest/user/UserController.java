package com.dhxx.api.rest.user;

import com.dhxx.api.authorization.annotation.Authorization;
import com.dhxx.api.authorization.manager.TokenManager;
import com.dhxx.api.exception.RestException;
import com.dhxx.api.rpc.user.UserFeignClient;
import com.dhxx.common.entity.user.User;
import com.dhxx.common.entity.user.UserInfo;
import com.dhxx.common.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    TokenManager manager;

    @PostMapping("save/{phone}")
    public Object save(@PathVariable String phone) throws Exception {
        UserInfo u = new UserInfo();
        u.setToken(phone);
        manager.createToken(u);
        return Resp.SUCCESS(u);
    }

    @PostMapping("info/{phone}")
    @Authorization
    public Object info(@PathVariable String phone) {
        User u = new User();
        u.setPhone(phone);
        u = userFeignClient.info(u);
        if (u == null)
            throw RestException.USER_NOT_EXISTS;
        return Resp.SUCCESS(u);
    }
}
