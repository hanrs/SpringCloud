package com.dhxx.service.rest.call;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.call.CallLog;
import com.dhxx.common.entity.dto.CallPageDTO;
import com.dhxx.service.biz.call.CallBiz;
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
@RequestMapping("call")
public class CallController {
    private static Logger logger = LoggerFactory.getLogger(CallController.class);

    @Autowired
    private CallBiz callBiz;

    @PostMapping("/save")
    public void save(@RequestBody CallLog call) {
        logger.debug("/call/save>>>>call="+ JSON.toJSONString(call));
        try {
            callBiz.save(call);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/call/save>>>>保存成功");
    }


    @PostMapping("delete")
    public void delete(@RequestBody List<CallLog> calls) {
        logger.debug("/call/delete>>>>call="+ JSON.toJSONString(calls));
        try {
            callBiz.delete(calls);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("findCallLogByType")
    public List<CallLog> findCallLogByType(@RequestBody CallPageDTO callPageDTO) {
        logger.debug("/call/findCallLogByType>>>>callPageDTO="+ JSON.toJSONString(callPageDTO));
        List<CallLog> list = new ArrayList<CallLog>();
        try {
           list = callBiz.findCallLogByType(callPageDTO);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return list;
    }

    @PostMapping("findCallLogByCount")
    public Integer findCallLogByCount(@RequestBody CallPageDTO callPageDTO) {
        logger.debug("/call/findCallLogByCount>>>>callPageDTO="+ JSON.toJSONString(callPageDTO));
        Integer count = -1;
        try {
            count = callBiz.findCallLogByCount(callPageDTO);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return count;
    }

    @PostMapping("missedCalls")
    public Integer missedCalls(@RequestBody CallLog call) {
        logger.debug("/call/missedCalls>>>>call="+ JSON.toJSONString(call));
        int count = -1;
        try {
            count = callBiz.missedCalls(call.getUdn());
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return count;
    }

    @PostMapping("emgCall")
    public Integer emgCall(@RequestBody CallLog call) {
        logger.debug("/call/emgCall>>>>call="+ JSON.toJSONString(call));
        int count = -1;
        try {
            count = callBiz.emgCall(call.getUdn());
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return count;
    }
}
