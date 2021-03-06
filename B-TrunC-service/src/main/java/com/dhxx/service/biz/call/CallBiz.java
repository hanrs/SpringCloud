package com.dhxx.service.biz.call;

import com.dhxx.common.entity.call.CallLog;
import com.dhxx.common.entity.dto.CallPageDTO;
import com.dhxx.service.mapper.call.CallMapper;
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
public class CallBiz {
    private static Logger logger = LoggerFactory.getLogger(CallBiz.class);

    @Autowired
    private CallMapper callMapper;

    //新增
    public void save(CallLog call) { callMapper.save(call); }

    //删除
    public void delete(List<CallLog> calls) {
        for(int i = 0; i < calls.size(); i++) {
            callMapper.delete(calls.get(i));
        }
    }

    //根据通话类型查询通话记录分页
    public List<CallLog> findCallLogByType(CallPageDTO callPageDTO) {
        return callMapper.findCallLogByType(callPageDTO);
    }

    //根据通话类型查询通话记录总页数
    public Integer findCallLogByCount(CallPageDTO callPageDTO) {
        double count =  callMapper.findCallLogByCount(callPageDTO);
        int totalPages = (int) Math.ceil(count/ callPageDTO.getPageSize());
        return totalPages;
    }

    //未接来电个数
    public Integer missedCalls(String udn) { return callMapper.missedCalls(udn); }

    //未接警告个数
    public Integer emgCall(String udn) { return callMapper.emgCall(udn); }
}
