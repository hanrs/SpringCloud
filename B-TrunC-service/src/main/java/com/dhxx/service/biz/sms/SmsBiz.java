package com.dhxx.service.biz.sms;

import com.dhxx.common.entity.dto.SmsPageDTO;
import com.dhxx.common.entity.sms.SmsLog;
import com.dhxx.service.mapper.sms.SmsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 */
@Service
@Transactional
public class SmsBiz {
    private static Logger logger = LoggerFactory.getLogger(SmsBiz.class);

    @Autowired
    private SmsMapper smsMapper;

    //新增
    public void save(SmsLog sms) { smsMapper.save(sms); }

    //删除
    public void delete(List<SmsLog> sms) {
        for(int i = 0; i <sms.size(); i++) {
            smsMapper.delete(sms.get(i));
        }
    }

    //修改
    public void update(SmsLog sms) { smsMapper.update(sms); }

    //短信记录分页按条件查询
    public List<SmsLog> findSmsLogByPage(SmsPageDTO smsPageDTO) {
        return smsMapper.findSmsLogByPage(smsPageDTO);
    }

    //短信记录查询 总记录
    public Integer findSmsLogByCount(SmsPageDTO smsPageDTO) {
        double count =  smsMapper.findSmsLogByCount(smsPageDTO);
        int totalPages = (int) Math.ceil(count/ smsPageDTO.getPageSize());
        return totalPages;
    }

    //未阅读消息
    public Integer smsCountByStatus0(String udn) { return smsMapper.smsCountByStatus0(udn); }
}
