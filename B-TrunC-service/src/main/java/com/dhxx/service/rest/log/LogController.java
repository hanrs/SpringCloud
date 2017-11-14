package com.dhxx.service.rest.log;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.dto.LogPageDTO;
import com.dhxx.common.entity.log.Log;
import com.dhxx.service.biz.log.LogBiz;
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
 * Date 2017-9-28
 * @version 1.01
 */
@RestController
@RequestMapping("log")
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogBiz logBiz;

    @PostMapping("/save")
    public void save(@RequestBody Log log) {
        logger.debug("/log/save>>>>log="+ JSON.toJSONString(log));
        try {
            logBiz.save(log);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/log/save>>>>保存成功");
    }

    @PostMapping("findLogByPage")
    public List<Log> findLogByPage(@RequestBody LogPageDTO logPageDTO) {
        logger.debug("/log/findLogByPage>>>>logPageDTO="+ JSON.toJSONString(logPageDTO));
        List<Log> list = new ArrayList<>();
        try {
            list = logBiz.findLogByPage(logPageDTO);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return list;
    }

    @PostMapping("findLogByCount")
    public Integer findLogByCount(@RequestBody LogPageDTO logPageDTO) {
        logger.debug("/log/findLogByCount>>>>logPageDTO="+ JSON.toJSONString(logPageDTO));
        int count = -1;
        try {
            count = logBiz.findLogByCount(logPageDTO);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return count;
    }
}
