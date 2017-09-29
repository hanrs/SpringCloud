package com.dhxx.service.rest.tcn;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.tcn.TcnInfo;
import com.dhxx.service.biz.tcn.TcnInfoBiz;
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
@RequestMapping("tcn")
public class TcnInfoController {
    private static Logger logger = LoggerFactory.getLogger(TcnInfoController.class);

    @Autowired
    private TcnInfoBiz tcnInfoBiz;

    @PostMapping("/save")
    public void save(@RequestBody TcnInfo tcn) {
        logger.debug("/tcn/save>>>>tcn="+ JSON.toJSONString(tcn));
        try {
            tcnInfoBiz.save(tcn);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/ms/save>>>>保存成功");
    }

    @PostMapping("update")
    public void update(@RequestBody TcnInfo tcn) {
        logger.debug("/tcn/update>>>>tcn="+ JSON.toJSONString(tcn));
        try {
            tcnInfoBiz.update(tcn);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("delete")
    public void delete(@RequestBody TcnInfo tcn) {
        logger.debug("/tcn/delete>>>>tcn="+ JSON.toJSONString(tcn));
        try {
            tcnInfoBiz.delete(tcn);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }
}
