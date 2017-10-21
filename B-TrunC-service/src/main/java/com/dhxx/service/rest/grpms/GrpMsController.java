package com.dhxx.service.rest.grpms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dhxx.common.entity.grpms.GroupMs;
import com.dhxx.service.biz.grpms.GrpMsBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private static Logger logger = LoggerFactory.getLogger(GrpMsController.class);

    @Autowired
    private GrpMsBiz grpMsBiz;

    @PostMapping("/save")
    public void save(@RequestBody GroupMs groupMs) {
        logger.debug("/grpms/save>>>>groupMs="+ JSON.toJSONString(groupMs));
        try {
            grpMsBiz.save(groupMs);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/grpms/save>>>>保存成功");
    }

    @PostMapping("delete")
    public void delete(@RequestBody GroupMs groupMs) {
        logger.debug("/group/delete>>>>groupMs="+ JSON.toJSONString(groupMs));
        try {
            grpMsBiz.delete(groupMs);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("getMenu")
    public JSONObject queryGrpMsByUdn(@RequestBody GroupMs groupMs) {
        logger.debug("/group/queryGrpMsByUdn>>>>udn="+ groupMs.getUdn());
        JSONObject jsonMenu = null;
        try {
            jsonMenu = grpMsBiz.queryMenuByUdn(groupMs.getUdn());
        } catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }

        return jsonMenu;
    }
}
