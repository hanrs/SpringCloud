package com.dhxx.api.rest.roleper;

import com.dhxx.api.rpc.roleper.RolePerFeignClient;
import com.dhxx.common.entity.roleper.RolePermission;
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
@RequestMapping("rolePer")
public class RolePerController {

    @Autowired
    private RolePerFeignClient rolePerFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody RolePermission rolePermission) throws Exception {
        try {
            rolePerFeignClient.save(rolePermission);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(rolePermission);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody RolePermission rolePermission) throws  Exception {
        try {
            rolePerFeignClient.delete(rolePermission);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(rolePermission);
    }

    @PostMapping("findRolePerByRoleId")
    public Object findRolePerByRoleId(@RequestBody RolePermission rolePermission) throws  Exception {
        List<RolePermission> list = new ArrayList<RolePermission>();
        try {
            list = rolePerFeignClient.findRolePerByRoleId(rolePermission);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

}
