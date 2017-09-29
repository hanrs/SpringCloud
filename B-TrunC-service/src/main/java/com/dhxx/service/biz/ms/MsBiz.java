package com.dhxx.service.biz.ms;

import com.dhxx.common.entity.ms.MsInfo;
import com.dhxx.service.mapper.ms.MsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liangz
 * Date 2017-9-28
 * @version 1.01
 */
@Service
@Transactional
public class MsBiz {
    private static Logger logger = LoggerFactory.getLogger(MsBiz.class);

    @Autowired
    private MsMapper msMapper;

    //新增终端
    public void save(MsInfo ms) { msMapper.save(ms); }

    //删除终端
    public void delete(MsInfo ms) { msMapper.delete(ms); }

    //修改终端
    public  void update(MsInfo ms) { msMapper.update(ms); }

}
