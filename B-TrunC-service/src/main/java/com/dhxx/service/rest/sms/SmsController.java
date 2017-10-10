package com.dhxx.service.rest.sms;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.sms.SmsLog;
import com.dhxx.common.entity.vo.SmsPageVo;
import com.dhxx.service.biz.sms.SmsBiz;
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
 * Date 2017-10-09
 * @version 1.01
 */
@RestController
@RequestMapping("sms")
public class SmsController {
    private static Logger logger = LoggerFactory.getLogger(SmsController.class);

    @Autowired
    private SmsBiz smsBiz;

    @PostMapping("/save")
    public void save(@RequestBody SmsLog sms) {
        logger.debug("/sms/save>>>>sms="+ JSON.toJSONString(sms));
        try {
            smsBiz.save(sms);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/sms/save>>>>保存成功");
    }


    @PostMapping("delete")
    public void delete(@RequestBody SmsLog sms) {
        logger.debug("/sms/delete>>>>sms="+ JSON.toJSONString(sms));
        try {
            smsBiz.delete(sms);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("update")
    public void update(@RequestBody SmsLog sms) {
        logger.debug("/sms/update>>>>sms="+ JSON.toJSONString(sms));
        try {
            smsBiz.update(sms);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("findSmsLogByPage")
    public List<SmsLog> findSmsLogByPage(SmsPageVo smsPageVo) {
        logger.debug("/sms/findSmsLogByPage>>>>smsPageVo="+ JSON.toJSONString(smsPageVo));

        List<SmsLog> list = new ArrayList<SmsLog>();
        try {
           list = smsBiz.findSmsLogByPage(smsPageVo);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return list;
    }

    @PostMapping("findSmsLogByCount")
    public Integer findSmsLogByCount(SmsPageVo smsPageVo) {
        logger.debug("/sms/findSmsLogByCount>>>>smsPageVo="+ JSON.toJSONString(smsPageVo));

        Integer count = -1;
        try {
            count = smsBiz.findSmsLogByCount(smsPageVo);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return count;
    }

    @PostMapping("smsCountByStatus0")
    public Integer smsCountByStatus0(@RequestBody SmsLog sms) {
        logger.debug("/sms/missedCalls>>>>call="+ JSON.toJSONString(sms));
        int count = -1;
        try {
            count = smsBiz.smsCountByStatus0(sms.getUdn());
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return count;
    }
}
