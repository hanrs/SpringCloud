package com.dhxx.service.biz.tcn;

import com.dhxx.common.entity.tcn.TcnInfo;
import com.dhxx.service.mapper.tcn.TcnInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年9月28日
 * @version 1.01
 */
@Service
@Transactional
public class TcnInfoBiz {

    private static Logger logger = LoggerFactory.getLogger(TcnInfoBiz.class);

    @Autowired
    private TcnInfoMapper tcninfoMapper;

    //新增
    public void save(TcnInfo tcn) { tcninfoMapper.save(tcn); }

    //删除
    public void delete(TcnInfo tcn) { tcninfoMapper.delete(tcn); }

    //修改
    public  void update(TcnInfo tcn) { tcninfoMapper.update(tcn); }
}
