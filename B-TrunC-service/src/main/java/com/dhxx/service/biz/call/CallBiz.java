package com.dhxx.service.biz.call;

import com.dhxx.common.entity.call.CallLog;
import com.dhxx.common.entity.vo.CallPageVo;
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

    //根据通话类型查询通话记录
    public List<CallLog> findCallLogByType(CallPageVo callPageVo) {
        return callMapper.findCallLogByType(callPageVo);
    }

    //根据通话类型查询通话记录
    public Integer findCallLogByCount(CallPageVo callPageVo) {
        double count =  callMapper.findCallLogByCount(callPageVo);
        int totalPages = (int) Math.ceil(count/callPageVo.getPageSize());
        return totalPages;
    }

    //未接来电个数
    public Integer missedCalls(String udn) { return callMapper.missedCalls(udn); }

    //未接警告个数
    public Integer emgCall(String udn) { return callMapper.emgCall(udn); }
}
