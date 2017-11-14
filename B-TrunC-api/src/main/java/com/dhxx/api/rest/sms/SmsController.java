package com.dhxx.api.rest.sms;

import com.dhxx.api.rpc.sms.SmsFeignClient;
import com.dhxx.common.entity.dto.SmsPageDTO;
import com.dhxx.common.entity.sms.SmsLog;
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
@RequestMapping("sms")
public class SmsController {

    @Autowired
    private SmsFeignClient smsFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody SmsLog sms) throws Exception {
        try {
            smsFeignClient.save(sms);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(sms);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody List<SmsLog> sms) throws  Exception {
        try {
            smsFeignClient.delete(sms);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(sms);
    }

    @PostMapping("update")
    public Object update(@RequestBody SmsLog sms) throws  Exception {
        try {
            smsFeignClient.update(sms);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(sms);
    }

    @PostMapping("findSmsLogByPage")
    public Object findSmsLogByPage(@RequestBody SmsPageDTO smsPageVon) throws  Exception {
        List<SmsLog> list = new ArrayList<SmsLog>();
        try {
            list = smsFeignClient.findSmsLogByPage(smsPageVon);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("findSmsLogByCount")
    public Object findSmsLogByCount(@RequestBody SmsPageDTO smsPageVon) throws  Exception {
        int count = -1;
        try {
            count = smsFeignClient.findSmsLogByCount(smsPageVon);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }

    @PostMapping("smsCountByStatus0")
    public Object smsCountByStatus0(@RequestBody SmsLog sms) throws  Exception {
        int count = -1;
        try {
            count = smsFeignClient.smsCountByStatus0(sms);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }
}
