package com.dhxx.service.rest.ms;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.ms.MsInfo;
import com.dhxx.service.biz.ms.MsBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangz
 * Date 2017-9-28
 * @version 1.01
 */
@RestController
@RequestMapping("ms")
public class MsController {
    private static Logger logger = LoggerFactory.getLogger(MsController.class);

    @Autowired
    private MsBiz msBiz;

    @PostMapping("/save")
    public void save(@RequestBody MsInfo ms) {
        logger.debug("/ms/save>>>>ms="+ JSON.toJSONString(ms));
        try {
            msBiz.save(ms);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/ms/save>>>>保存成功");
    }

    @PostMapping("update")
    public void update(@RequestBody MsInfo ms) {
        logger.debug("/ms/update>>>>ms="+ JSON.toJSONString(ms));
        try {
            msBiz.update(ms);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("delete")
    public void delete(@RequestBody MsInfo ms) {
        logger.debug("/ms/delete>>>>ms="+ JSON.toJSONString(ms));
        try {
            msBiz.delete(ms);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }
}
