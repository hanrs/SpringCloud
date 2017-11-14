package com.dhxx.service.mapper.sms;


import com.dhxx.common.entity.dto.SmsPageDTO;
import com.dhxx.common.entity.sms.SmsLog;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-9
 * @version 1.01
 */
public interface SmsMapper {
    void save(SmsLog sms); //增

    void delete(SmsLog sms); //删

    void update(SmsLog sms); //修改消息状态

    List<SmsLog> findSmsLogByPage(SmsPageDTO smsPageDTO); //短信记录分页按条件查询

    Double findSmsLogByCount(SmsPageDTO smsPageDTO); //短信记录查询 总记录

    Integer smsCountByStatus0(String udn); //未阅读消息
}
