package com.dhxx.service.biz.log;

import com.dhxx.common.entity.log.Log;
import com.dhxx.common.entity.vo.LogPageVo;
import com.dhxx.service.mapper.log.LogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年9月28日
 * @version 1.01
 */
@Service
@Transactional
public class LogBiz {

    private static Logger logger = LoggerFactory.getLogger(LogBiz.class);

    @Autowired
    private LogMapper logMapper;

    //新增
    public void save(Log log) { logMapper.save(log); }

    //操作日志分页
    public List<Log> findLogByPage(LogPageVo logPageVo) { return  logMapper.findLogByPage(logPageVo); }

    //日志分页总页数
    public Integer findLogByCount(LogPageVo logPageVo) {
        double count =  logMapper.findLogByCount(logPageVo);
        int totalPages = (int) Math.ceil(count/logPageVo.getPageSize());
        return totalPages;
    }
}
