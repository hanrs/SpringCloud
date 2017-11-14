package com.dhxx.service.rest.group;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.dto.GrpPageDTO;
import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.service.biz.group.GroupBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private GroupBiz groupBiz;

    @PostMapping("/save")
    public GroupInfo save(@RequestBody GroupInfo group) {
        logger.debug("/group/save>>>>group="+ JSON.toJSONString(group));
        GroupInfo grp = null;
        try {
            grp = groupBiz.save(group);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
        logger.debug("/group/save>>>>保存成功");
        return grp;
    }

    @PostMapping("update")
    public void update(@RequestBody GroupInfo group) {
        logger.debug("/group/update>>>>group="+ JSON.toJSONString(group));
        try {
            groupBiz.update(group);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("delete")
    public void delete(@RequestBody GroupInfo group) {
        logger.debug("/group/delete>>>>group="+ JSON.toJSONString(group));
        try {
            groupBiz.delete(group);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("findGrpByPage")
    public List<GroupInfo> findGrpByPage(@RequestBody GrpPageDTO grpPageDTO) {
        logger.debug("/group/findGrpByPage>>>>grpPageDTO="+ JSON.toJSONString(grpPageDTO));
        List<GroupInfo> list = new ArrayList<GroupInfo>();
        try {
            list = groupBiz.findGrpByPage(grpPageDTO);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return list;
    }

    @PostMapping("findGrpByCount")
    public Integer findGrpByCount(@RequestBody GrpPageDTO grpPageDTO) {
        logger.debug("/group/findGrpByPage>>>>grpPageDTO="+ JSON.toJSONString(grpPageDTO));
        int count = -1;
        try {
            count = groupBiz.findGrpByCount(grpPageDTO);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return count;
    }

    @PostMapping("findGrpInfoByGrpId")
    public GroupInfo findGrpInfoByGrpId(@RequestBody GroupInfo groupInfo) {
        logger.debug("/group/findGrpInfoByGrpId>>>>groupInfo="+ JSON.toJSONString(groupInfo));
        GroupInfo grpInfoRes = null;
        try {
            grpInfoRes = groupBiz.findGrpInfoByGrpId(groupInfo.getGrpId());
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return grpInfoRes;
    }

    @PostMapping("findGrpInfoAndSub")
    public List<GroupInfo> findGrpInfoAndSub(@RequestBody GrpPageDTO grpPageDTO) {
        logger.debug("/group/findGrpInfoAndSub>>>>grpPageDTO="+ JSON.toJSONString(grpPageDTO));
        List<GroupInfo> list = new ArrayList<GroupInfo>();
        try {
            list = groupBiz.findGrpInfoAndSub(grpPageDTO);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return list;
    }

    @PostMapping("findGrpInfoAndSubCount")
    public Integer findGrpInfoAndSubCount(@RequestBody GrpPageDTO grpPageDTO) {
        logger.debug("/group/findGrpInfoAndSubCount>>>>grpPageDTO="+ JSON.toJSONString(grpPageDTO));
        int count = -1;
        try {
            count = groupBiz.findGrpInfoAndSubCount(grpPageDTO);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return count;
    }
}
