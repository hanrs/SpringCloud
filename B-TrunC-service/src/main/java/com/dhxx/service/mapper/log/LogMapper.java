package com.dhxx.service.mapper.log;



import com.dhxx.common.entity.log.Log;
import com.dhxx.common.entity.vo.LogPageVo;

import java.util.List;

/**
 * @author liangz
 * Date: 2017-9-28
 * @version 1.01
 */
public interface LogMapper {

    void save(Log log);   //增

    List<Log> findLogByPage(LogPageVo logPageVo); //操作日志分页

    Double findLogByCount(LogPageVo logPageVo); //操作日志总页数
}
