package com.dhxx.api.rest.grpms;

import com.dhxx.api.rpc.group.GroupFeignClient;
import com.dhxx.api.rpc.grpms.GrpMsFeignClient;
import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.common.entity.grpms.GroupMs;
import com.dhxx.common.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liangz
 * Date 2017-9-29
 * @version 1.01
 */
@RestController
@RequestMapping("grpms")
public class GrpMsController {

    @Autowired
    private GrpMsFeignClient grpMsFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody GroupMs groupMs) throws Exception {
        try {
            grpMsFeignClient.save(groupMs);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(groupMs);
    }

    @PostMapping("update")
    public Object update(@RequestBody GroupMs groupMs) throws  Exception {
        try {
            grpMsFeignClient.update(groupMs);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(groupMs);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody GroupMs groupMs) throws  Exception {
        try {
            grpMsFeignClient.delete(groupMs);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(groupMs);
    }

    @PostMapping("queryGrpMsByUdn")
    public Object queryGrpMsByUdn(@RequestBody GroupMs groupMs) throws Exception {
        String jsonMenu = null;
        try {
            jsonMenu = grpMsFeignClient.queryGrpMsByUdn(groupMs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return jsonMenu;
    }
}
