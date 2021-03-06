package com.dhxx.api.rest.group;

import com.dhxx.api.rpc.group.GroupFeignClient;
import com.dhxx.common.entity.dto.GrpPageDTO;
import com.dhxx.common.entity.group.GroupInfo;
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
        GroupInfo grp = null;
        try {
            grp = groupFeignClient.save(group);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(grp);
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
    public Object findGrpByPage(@RequestBody GrpPageDTO grpPageDTO) throws Exception {
        List<GroupInfo> list = new ArrayList<GroupInfo>();
        try {
            list = groupFeignClient.findGrpByPage(grpPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("findGrpByCount")
    public Object findGrpByCount(@RequestBody GrpPageDTO grpPageDTO) throws Exception {
        int count = -1;
        try {
            count = groupFeignClient.findGrpByCount(grpPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }

    @PostMapping("findGrpInfoByGrpId")
    public Object findGrpInfoByGrpId(@RequestBody GroupInfo groupInfo) throws Exception {
        GroupInfo grpInfoRes = null;
        try {
            grpInfoRes = groupFeignClient.findGrpInfoByGrpId(groupInfo);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(grpInfoRes);
    }

    @PostMapping("findGrpInfoAndSub")
    public Object findGrpInfoAndSub(@RequestBody GrpPageDTO grpPageDTO) throws Exception {
        List<GroupInfo> list = new ArrayList<GroupInfo>();
        try {
            list = groupFeignClient.findGrpInfoAndSub(grpPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("findGrpInfoAndSubCount")
    public Object findGrpInfoAndSubCount(@RequestBody GrpPageDTO grpPageDTO) throws Exception {
        int count = -1;
        try {
            count = groupFeignClient.findGrpInfoAndSubCount(grpPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }
}
