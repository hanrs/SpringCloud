package com.dhxx.api.rest.call;

import com.dhxx.api.rpc.call.CallFeignClient;
import com.dhxx.common.entity.call.CallLog;
import com.dhxx.common.entity.dto.CallPageDTO;
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
 * Date 2017-10-09
 * @version 1.01
 */
@RestController
@RequestMapping("call")
public class CallController {

    @Autowired
    private CallFeignClient callFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody CallLog call) throws Exception {
        try {
            callFeignClient.save(call);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(call);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody List<CallLog> calls) throws  Exception {
        try {
            callFeignClient.delete(calls);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(calls);
    }

    @PostMapping("findCallLogByType")
    public Object findCallLogByType(@RequestBody CallPageDTO callPageDTO) throws  Exception {
        List<CallLog> list = new ArrayList<CallLog>();
        try {
            list = callFeignClient.findCallLogByType(callPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("findCallLogByCount")
    public Object findCallLogByCount(@RequestBody CallPageDTO callPageDTO) throws  Exception {
        int count = -1;
        try {
            count = callFeignClient.findCallLogByCount(callPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }

    @PostMapping("missedCalls")
    public Object missedCalls(@RequestBody CallLog call) throws Exception {
        int count = -1;
        try {
            count = callFeignClient.missedCalls(call);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }

    @PostMapping("emgCall")
    public Object emgCall(@RequestBody CallLog call) throws Exception {
        int count = -1;
        try {
            count = callFeignClient.emgCall(call);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }
}
