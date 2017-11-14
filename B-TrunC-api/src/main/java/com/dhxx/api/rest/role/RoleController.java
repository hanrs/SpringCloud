package com.dhxx.api.rest.role;

import com.dhxx.api.authorization.annotation.Authorization;
import com.dhxx.api.authorization.annotation.Permission;
import com.dhxx.api.rpc.role.RoleFeignClient;
import com.dhxx.api.rpc.tcn.TcnInfoFeignClient;
import com.dhxx.common.entity.role.Role;
import com.dhxx.common.entity.tcn.TcnInfo;
import com.dhxx.common.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangz
 * Date 2017-10-21
 * @version 1.01
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleFeignClient roleFeignClient;

    @PostMapping("save")
    @Permission
    public Object save(@RequestBody Role role) throws Exception {
        try {
            roleFeignClient.save(role);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(role);
    }

    @PostMapping("update")
    public Object update(@RequestBody Role role) throws  Exception {
        try {
            roleFeignClient.update(role);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(role);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody Role role) throws  Exception {
        try {
            roleFeignClient.delete(role);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(role);
    }

    @PostMapping("findRole")
    public Object findRole() throws  Exception {
        List<Role> list= new ArrayList<Role>();
        try {
            list = roleFeignClient.findRole();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }
}
