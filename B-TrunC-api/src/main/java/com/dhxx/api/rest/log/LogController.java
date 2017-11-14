package com.dhxx.api.rest.log;

import com.dhxx.api.rpc.log.LogFeignClient;
import com.dhxx.common.entity.dto.LogPageDTO;
import com.dhxx.common.entity.log.Log;
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
 * Date 2017-9-28
 * @version 1.01
 */
@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private LogFeignClient logFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody Log log) throws Exception {
        try {
            logFeignClient.save(log);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(log);
    }


    @PostMapping("findLogByPage")
    public Object findLogByPage(@RequestBody LogPageDTO logPageDTO) throws  Exception {
        List<Log> list= new ArrayList<>();
        try {
            list = logFeignClient.findLogByPage(logPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("findLogByCount")
    public Object findLogByCount(@RequestBody LogPageDTO logPageDTO) throws  Exception {
        int count = -1;
        try {
            count = logFeignClient.findLogByCount(logPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }
}
