package com.dhxx.service.mapper.call;

import com.dhxx.common.entity.call.CallLog;
import com.dhxx.common.entity.vo.CallPageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-9
 * @version 1.01
 */
public interface CallMapper {
    void save(CallLog call); //增

    void delete(CallLog call); //删

    List<CallLog> findCallLogByType(CallPageVo callPageVo); //根据通话类型查询通话记录 分页

    Double findCallLogByCount(CallPageVo callPageVo); //根据通话类型查询通话记录总数

    Integer missedCalls(@Param("udn") String udn); //未接来电个数

    Integer emgCall(@Param("udn") String udn); //未接警告个数
}
