package com.dhxx.api.rest.user;

import com.dhxx.api.authorization.annotation.Authorization;
import com.dhxx.api.authorization.manager.PermissionManager;
import com.dhxx.api.authorization.manager.TokenManager;
import com.dhxx.api.rpc.roleper.RolePerFeignClient;
import com.dhxx.api.rpc.user.UserFeignClient;
import com.dhxx.common.entity.dto.UserDTO;
import com.dhxx.common.entity.roleper.RolePermission;
import com.dhxx.common.entity.user.User;
import com.dhxx.common.entity.user.UserInfo;
import com.dhxx.common.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private RolePerFeignClient rolePerFeignClient;

    @Autowired
    TokenManager manager;

    @Autowired
    PermissionManager permissionManager;

    private String msg = null;
    private boolean isSuccess = true;

    @PostMapping("login")
    public Object login(@RequestBody User user) throws Exception {
        UserInfo u = new UserInfo();
        User usered = userFeignClient.login(user);
        if(usered!=null){
            String token = UUID.randomUUID().toString();
            u.setAccount(usered.getAccount());
            u.setRoleId(usered.getRoleId());
            u.setUserName(usered.getUserName());
            u.setToken(token);
            manager.createToken(u);

            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(usered.getRoleId());
            List<RolePermission> list = rolePerFeignClient.findRolePerByRoleId(rolePermission);
            permissionManager.createAccount(list, usered.getAccount());

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
    @Authorization
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
    public Object personalInfo(@RequestBody UserDTO userDTO) throws  Exception {
        UserDTO userDTORps = null;
        try {
            userDTORps = userFeignClient.personalInfo(userDTO);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(userDTORps);
    }

    @PostMapping("findUserByPage")
    public Object findUserByPage(@RequestBody UserDTO userDTO) throws  Exception {
        List<User> list = new ArrayList<User>();
        try {
            list = userFeignClient.findUserByPage(userDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("findUserByCount")
    public Object findUserByCount(@RequestBody UserDTO userDTO) throws  Exception {
        int count = -1;
        try {
            count = userFeignClient.findUserByCount(userDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }
}
