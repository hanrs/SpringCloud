package com.dhxx.api.rest.permission;

import com.dhxx.api.rpc.permission.PermissionFeignClient;
import com.dhxx.common.entity.permission.Permission;
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
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionFeignClient permissionFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody Permission permission) throws Exception {
        try {
            permissionFeignClient.save(permission);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(permission);
    }

    @PostMapping("update")
    public Object update(@RequestBody Permission permission) throws  Exception {
        try {
            permissionFeignClient.update(permission);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(permission);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody Permission permission) throws  Exception {
        try {
            permissionFeignClient.delete(permission);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(permission);
    }

    @PostMapping("findPermission")
    public Object findPermission() throws  Exception {
        List<Permission> list= new ArrayList<Permission>();
        try {
            list = permissionFeignClient.findPermission();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }
}
