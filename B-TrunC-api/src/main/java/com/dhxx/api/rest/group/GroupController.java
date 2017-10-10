package com.dhxx.api.rest.group;

import com.dhxx.api.rpc.group.GroupFeignClient;
import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.common.entity.vo.GrpPageVo;
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
 * Date 2017-9-29
 * @version 1.01
 */
@RestController
@RequestMapping("group")
public class GroupController {

    @Autowired
    private GroupFeignClient groupFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody GroupInfo group) throws Exception {
        try {
            groupFeignClient.save(group);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(group);
    }

    @PostMapping("update")
    public Object update(@RequestBody GroupInfo group) throws Exception {
        try {
            groupFeignClient.update(group);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(group);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody GroupInfo group) throws Exception {
        try {
            groupFeignClient.delete(group);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(group);
    }

    @PostMapping("findGrpByPage")
    public Object findGrpByPage(GrpPageVo grpPageVo) throws Exception {
        List<GroupInfo> list = new ArrayList<GroupInfo>();
        try {
            list = groupFeignClient.findGrpByPage(grpPageVo);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @PostMapping("findGrpByCount")
    public Object findGrpByCount(GrpPageVo grpPageVo) throws Exception {
        int count = -1;
        try {
            count = groupFeignClient.findGrpByCount(grpPageVo);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
